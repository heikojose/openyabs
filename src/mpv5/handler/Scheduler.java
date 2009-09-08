package mpv5.handler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import mpv5.db.common.Context;
import mpv5.db.common.NodataFoundException;
import mpv5.db.common.QueryHandler;
import mpv5.db.common.ReturnValue;
import mpv5.db.objects.Item;
import mpv5.db.objects.Schedule;
import mpv5.globals.Messages;
import mpv5.logging.Log;
import mpv5.ui.dialogs.Popup;
import mpv5.ui.frames.MPView;
import mpv5.ui.panels.GeneralListPanel;
import mpv5.usermanagement.MPSecurityManager;
import mpv5.utils.date.DateConverter;
import mpv5.utils.date.vTimeframe;

/**
 * This class handles the scheduled events
 */
public class Scheduler extends Thread {

    @Override
    public void run() {

        while (true) {
          try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
            }
            checkForOverdueEvents();
            checkForCreateBillEvents();
            try {
                Thread.sleep(600000);
            } catch (InterruptedException ignore) {
            }
        }
    }

    @SuppressWarnings("static-access")
    private void checkForCreateBillEvents() {
        ArrayList<Schedule> data = Schedule.getEvents(new vTimeframe(DateConverter.addYears(new Date(), -2), new Date()));
        List<Item> list = new Vector<Item>();
        for (int i = 0; i < data.size(); i++) {
            Schedule schedule = data.get(i);
            if (!schedule.__getIsdone()) {
                try {
                    Item item = schedule.getItem();
                    item.setIDS(-1);
                    item.setDateadded(new Date());
                    item.setDatetodo(new Date());
                    item.setDateend(new Date());
                    item.setIntreminders(0);
                    item.setIntstatus(item.STATUS_IN_PROGRESS);
                    item.setDescription(item.__getDescription() +
                            "\n" +
                            Messages.SCHEDULE_GENERATED +
                            "\n" +
                            item.__getCName());
                    item.save();

                    Date olddate = schedule.__getNextdate();
                    schedule.setNextdate(DateConverter.addMonths(schedule.__getNextdate(), schedule.__getIntervalmonth()));
                    if (schedule.__getNextdate().before(schedule.__getStopdate())) {
                        Schedule s2 = (Schedule) schedule.clone();
                        s2.setIsdone(false);
                        s2.setIDS(-1);
                        s2.save(true);
                        schedule.setNextdate(olddate);
                        schedule.setIsdone(true);
                        schedule.save(true);
                    } else {
                        schedule.setNextdate(olddate);
                        schedule.setIsdone(true);
                        schedule.save(true);
                        MPView.addMessage(Messages.SCHEDULE_ITEM_REMOVED + " " + schedule);
                    }
                    list.add(item);
                } catch (NodataFoundException ex) {
                    Log.Debug(ex);
                }
            }
        }

        if (list.size() > 0) {
            if (Popup.Y_N_dialog(list.size() + " " + Messages.SCHEDULE_NEW_ITEMS)) {
                for (int i = 0; i < list.size(); i++) {
                    Item item = list.get(i);
                    MPView.identifierView.addTab(item);
                }
            }
        }
    }

    private void checkForOverdueEvents() {

        List<Item> warnings = new Vector<Item>();
        List<Item> alerts = new Vector<Item>();
        List<Item> waitings = new Vector<Item>();
        try {
            if (MPView.getUser().getProperties().hasProperty("bills.warn.days")) {
                Integer warn = Integer.valueOf(MPView.getUser().getProperties().getProperty("bills.warn.days"));
                String sql = "SELECT ids FROM items WHERE dateadded <= '" +
                        DateConverter.getSQLDateString(DateConverter.addDays(new Date(), warn * -1)) +
                        "' AND intstatus <> " + Item.STATUS_PAID;
                ReturnValue data = QueryHandler.getConnection().freeSelectQuery(sql, MPSecurityManager.VIEW, null);

                if (data.hasData()) {
                    Object[][] d = data.getData();
                    for (int i = 0; i < d.length; i++) {
                        int id = Integer.valueOf(d[i][0].toString());
                        try {
                            Item it = (Item) Item.getObject(Context.getItems(), id);
                            warnings.add(it);
                        } catch (NodataFoundException ex) {
                            Log.Debug(ex);
                        }
                    }
                }
            } else {
                Log.Debug(this, "No warn treshold for bills defined.");
            }
        } catch (Exception numberFormatException) {
            Log.Debug(numberFormatException);
        }

        if (MPView.getUser().getProperties().hasProperty("bills.alert.days")) {
            Integer alert = Integer.valueOf(MPView.getUser().getProperties().getProperty("bills.alert.days"));
            String sql = "SELECT ids FROM items WHERE dateadded <= '" +
                    DateConverter.getSQLDateString(DateConverter.addDays(new Date(), alert * -1)) +
                    "' AND intstatus <> " + Item.STATUS_PAID;
            ReturnValue data = QueryHandler.getConnection().freeSelectQuery(sql, MPSecurityManager.VIEW, null);

            if (data.hasData()) {
                Object[][] d = data.getData();
                for (int i = 0; i < d.length; i++) {
                    int id = Integer.valueOf(d[i][0].toString());
                    try {
                        Item it = (Item) Item.getObject(Context.getItems(), id);
                        alerts.add(it);
                    } catch (NodataFoundException ex) {
                        Log.Debug(ex);
                    }
                }
            }
        } else {
            Log.Debug(this, "No alert treshold for bills defined.");
        }

        String sql = "SELECT ids FROM items WHERE intstatus <> " + Item.STATUS_PAID;
        ReturnValue data = QueryHandler.getConnection().freeSelectQuery(sql, MPSecurityManager.VIEW, null);

        if (data.hasData()) {
            Object[][] d = data.getData();
            for (int i = 0; i < d.length; i++) {
                int id = Integer.valueOf(d[i][0].toString());
                try {
                    Item it = (Item) Item.getObject(Context.getItems(), id);
                    waitings.add(it);
                } catch (NodataFoundException ex) {
                    Log.Debug(ex);
                }
            }
        }

        for (Item i : alerts) {//Remove dupes
            if (warnings.contains(i)) {
                warnings.remove(i);
            }
            if (waitings.contains(i)) {
                waitings.remove(i);
            }
        }

        for (Item i : warnings) {//Remove dupes
            if (waitings.contains(i)) {
                waitings.remove(i);
            }
        }


        HashMap<Color, List<Item>> map = new HashMap<Color, List<Item>>();
        map.put(Color.red, alerts);
        map.put(Color.yellow, warnings);
        map.put(Color.green, waitings);
//
//        if (!warnings.isEmpty()) {
////            if (Popup.Y_N_dialog(warnings.size() + " " + Messages.SCHEDULE_NEW_WARNINGS, Messages.WARNING)) {
//        for (int i = 0; i < warnings.size(); i++) {
//            Item item = warnings.get(i);
//            MPView.identifierView.addTab(item);
//        }
//                 MPView.identifierView.addTab(new GeneralListPanel(warnings), Messages.UNPAID_BILLS.toString());
////            }
//        }

        if (!alerts.isEmpty() || !warnings.isEmpty() || !waitings.isEmpty()) {
//            alerts.addAll(warnings);
//            if (Popup.Y_N_dialog(alerts.size() + " " + Messages.SCHEDULE_NEW_ALERTS, Messages.WARNING)) {

            MPView.identifierView.addTab(new GeneralListPanel(map), Messages.UNPAID_BILLS_OVERDUE.toString());
//            }
        }
    }
}