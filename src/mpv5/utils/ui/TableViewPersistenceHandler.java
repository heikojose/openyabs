/*
 *  This file is part of YaBS.
 *
 *      YaBS is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      YaBS is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with YaBS.  If not, see <http://www.gnu.org/licenses/>.
 */
package mpv5.utils.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;
import mpv5.db.objects.User;
import mpv5.ui.misc.MPTable;

/**
 *
 * @author anti
 */
public class TableViewPersistenceHandler {

    private final ColumnListener t;
    private final JTable target;
    private final JComponent identifier;
    private List<TableColumnModelListener> listeners = new ArrayList<TableColumnModelListener>();

    /**
     * 
     * @param target
     * @param identifier
     */
    public TableViewPersistenceHandler(final JTable target, final JComponent identifier) {
        t = new ColumnListener(target, identifier);
        this.target = target;
        this.identifier = identifier;
//        target.createDefaultColumnsFromModel();
//        omodel = target.getColumnModel();

//        Log.Debug(this, User.getCurrentUser().getLayoutProperties().get(target.getName() + "@" + identifier.getName()));
        try {
            ComponentStateManager.reload(User.getCurrentUser().getLayoutProperties().get(target.getName() + "@" + identifier.getName()), target);
        } catch (Exception ex) {
//            Log.Debug(this, ex);
            if (target instanceof MPTable) {
                ((MPTable) target).reset();
            }
            User.getCurrentUser().getLayoutProperties().remove(target.getName() + "@" + identifier.getName());
        }
    }

    /**
     * Set a listener
     */
    public void set() {
        try {
//            listeners.addAll(Arrays.asList(((DefaultTableColumnModel) target.getColumnModel()).getColumnModelListeners()));
            ComponentStateManager.reload(User.getCurrentUser().getLayoutProperties().get(target.getName() + "@" + identifier.getName()), target);
        } catch (Exception ex) {
//            Log.Debug(this, ex);
            User.getCurrentUser().getLayoutProperties().remove(target.getName() + "@" + identifier.getName());
            target.createDefaultColumnsFromModel();
        }
        target.getColumnModel().addColumnModelListener(t);
//        for (int i = 0; i < listeners.size(); i++) {
//            TableColumnModelListener tableColumnModelListener = listeners.get(i);
//            target.getColumnModel().addColumnModelListener(tableColumnModelListener);
//        }
//        listeners.retainAll(new ArrayList<TableColumnModelListener>());
    }

    /**
     * Remove the listener again
     */
    public void remove() {
        target.getColumnModel().removeColumnModelListener(t);
    }

    class ColumnListener implements TableColumnModelListener {

        private final JTable table;
        private final JComponent identifier;
        private String layout;

        private ColumnListener(JTable target, JComponent identifier) {
            this.identifier = identifier;
            this.table = target;
        }

        public void columnAdded(TableColumnModelEvent e) {
        }

        public void columnRemoved(TableColumnModelEvent e) {
        }

        public void columnMoved(TableColumnModelEvent e) {
            layout = ComponentStateManager.persist(table);
            User.getCurrentUser().getLayoutProperties().put(target.getName() + "@" + identifier.getName(), layout);
        }

        public void columnMarginChanged(ChangeEvent e) {
            layout = ComponentStateManager.persist(table);
            User.getCurrentUser().getLayoutProperties().put(target.getName() + "@" + identifier.getName(), layout);
        }

        public void columnSelectionChanged(ListSelectionEvent e) {
        }
    }
}