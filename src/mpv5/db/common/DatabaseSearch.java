package mpv5.db.common;

import java.util.ArrayList;
import java.util.Arrays;
import mpv5.db.objects.User;
import mpv5.usermanagement.MPSecurityManager;
import mpv5.utils.arrays.ArrayUtilities;

/**
 *
 * Convenience class for database searches.
 * <br/>Does <b>NOT</b> automatically take care of multi-client capability needs.
 */
public class DatabaseSearch {

    public static String ALL_COLUMNS = "*";
    private Context context;
    private int ROWLIMIT = 0;

    /**
     * Initiates a new search
     * @param context
     */
    public DatabaseSearch(Context context) {
        this.context = context;
    }

    /**
     * Initiates a new search
     * @param obj The DBOBJ the search will rely on
     */
    public DatabaseSearch(DatabaseObject obj) {
        this.context = new Context(obj);
        context.setDbIdentity(obj.getDbIdentity());
        context.setSubID(Context.DEFAULT_SUBID);
    }

    /**
     * Initiates a new search and allows to limit the resulting rows
     * @param context
     * @param rowlimit
     */
    public DatabaseSearch(Context context, int rowlimit) {
        this.context = context;
        this.ROWLIMIT = rowlimit;
    }

    /**
     * Get multiple values from a search
     * @return select("*", null);
     */
    public Object[][] getValuesFor() {
        return QueryHandler.instanceOf().clone(context, ROWLIMIT).select("*", (String[]) null);
    }

    /**
     * Get multiple values from a search
     * @param resultingFieldNames What do you like to get (columns)?
     * @param what Which column do you like to take for the condition?
     * @param where And what value should the column value have?
     * @return
     */
    public Object[][] getValuesFor(String resultingFieldNames, String what, String where) {
        return QueryHandler.instanceOf().clone(context, ROWLIMIT).select(resultingFieldNames, new String[]{what, where, "'"});
    }

    /**
     * Get multiple values from a search, where the search column is a number column
     * @param resultingFieldNames What do you like to get (columns)?
     * @param what Which column do you like to take for the condition?
     * @param  value
     * @return
     */
    public Object[][] getValuesFor(String resultingFieldNames, String what, Number value) {
        return QueryHandler.instanceOf().clone(context, ROWLIMIT).select(resultingFieldNames, new String[]{what, value.toString(), ""});
    }

    /**
     * Get multiple values from a search
     * @param resultingFieldNames What do you like to get (columns)?
     * @param possibleColumns Which columns do you like to take for the condition?
     * @param where And what value should the column value have?
     * @param searchForLike Shall we search with "like" condition?
     * @return 
     */
    public Object[][] getValuesFor(String resultingFieldNames, String[] possibleColumns, String where, boolean searchForLike) {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < possibleColumns.length; i++) {
            String string = possibleColumns[i];
            list.addAll(Arrays.asList(QueryHandler.instanceOf().clone(context, ROWLIMIT).select(resultingFieldNames, new String[]{string, where, "'"}, null, searchForLike)));
        }
        ArrayUtilities.removeDuplicates(list);
        return list.toArray(new Object[][]{});
    }

    /**
     * Get multiple values from a search, ignores reference tables and is herewith faster
     * @param resultingFieldNames What do you like to get (columns)?
     * @param possibleColumns Which columns do you like to take for the condition?
     * @param where And what value should the column value have?
     * @param searchForLike Shall we search with "like" condition?
     * @param withIds If true, the first column is alway the IDS field
     * @return
     */
    public Object[][] getValuesFor2(String resultingFieldNames, String[] possibleColumns, String where, boolean searchForLike) {
        String w = "";
        String like = "LIKE '%";
        String like2 = "%'";
        if (!searchForLike) {
            like = "'";
            like2 = "'";
        }
        for (int i = 0; i < possibleColumns.length; i++) {
            w += possibleColumns[i] + " " + like + where + like2 +
                    " OR ";
        }
        return QueryHandler.instanceOf().clone(context, ROWLIMIT).freeSelectQuery(context.prepareSQLString(
                "SELECT " + resultingFieldNames + " FROM " + context.getDbIdentity() + " WHERE " + w.substring(0, w.length() - 4)), MPSecurityManager.VIEW, null).getData();
    }

//    /**
//     * Get multiple values from a search<br/>
//     * if the specified {@link User} is not null and is group -restricted, only results for his group will be returned
//     * @param resultingFieldNames What do you like to get (columns)?
//     * @param possibleColumns Which columns do you like to take for the condition?
//     * @param where And what value should the column value have?
//     * @param searchForLike Shall we search with "like" condition?
//     * @param user
//     * @return
//     */
//    public Object[][] getValuesFor(String resultingFieldNames, String[] possibleColumns, String where, boolean searchForLike, User user) {
//        if (user == null || user.isGroupRestricted()) {
//            ArrayList<Object[]> list = new ArrayList<Object[]>();
//            for (int i = 0; i < possibleColumns.length; i++) {
//                String string = possibleColumns[i];
//                list.addAll(Arrays.asList(QueryHandler.instanceOf().clone(context, ROWLIMIT).select(resultingFieldNames, new String[]{string, where, "'"}, null, searchForLike)));
//            }
//            return list.toArray(new Object[][]{});
//        } else {
//            return getValuesFor(resultingFieldNames, possibleColumns, where, searchForLike);
//        }
//    }

    /**
     * Get multiple values from a search
     * @param resultingFieldNames What do you like to get (columns, comma separated)?
     * @param what Which column do you like to take for the condition?
     * @param where And what value should the column value have?
     * @param searchForLike Shall we search with "like" condition?
     * @return
     */
    public Object[][] getValuesFor(String resultingFieldNames, String what, String where, boolean searchForLike) {
        return QueryHandler.instanceOf().clone(context, ROWLIMIT).select(resultingFieldNames, new String[]{what, where, "'"}, null, searchForLike);

    }

    /**
     * Get a single dimension list from a search after values from the column
     * where the value is LIKE the given needle
     * @param what Which column do you like to get and search through?
     * @param needle
     * @return
     * @throws NodataFoundException If no data was found matching your search
     */
    public Object[] searchFor(String what, String needle) throws NodataFoundException {
        return searchFor(null, what, needle);
    }

    /**
     * Get a single dimension list from a search after values from the column
     * where the value is LIKE the given needle
     * @param columns Which columns to get?
     * @param what Which column do you like to search through?
     * @param needle
     * @param exactMatch
     * @return
     * @throws NodataFoundException If no data was found matching your search
     */
    public Object[] searchFor(String[] columns, String what, String needle, boolean exactMatch) throws NodataFoundException {
        Object[] data = QueryHandler.instanceOf().clone(context, ROWLIMIT).getValuesFor(columns, what, needle, exactMatch);
        if (data == null || data.length == 0) {
            throw new NodataFoundException();
        } else {
            return data;
        }
    }

    /**
     * Get a single dimension list from a search after values from the column
     * where the value is LIKE the given needle
     * @param columns Which columns to get?
     * @param what Which column do you like to search through?
     * @param needle
     * @return
     * @throws NodataFoundException If no data was found matching your search
     */
    public Object[] searchFor(String[] columns, String what, String needle) throws NodataFoundException {
        Object[] data = QueryHandler.instanceOf().clone(context, ROWLIMIT).getValuesFor(columns, what, needle, false);
        if (data == null || data.length == 0) {
            throw new NodataFoundException();
        } else {
            return data;
        }
    }

    /**
     * Search for an ID in this context
     * @param what The column which you like to search through
     * @param needle The value of the row in that column
     * @return An id if there is a matching dataset found, NULL otherwise
     */
    public Integer searchForID(String what, String needle) {
        Object[] data;
        try {
            data = QueryHandler.instanceOf().clone(context, ROWLIMIT).selectLast("ids", new String[]{what, needle, "'"}, true);
            return Integer.valueOf(data[0].toString());
        } catch (Exception ex) {
            return null;
        }
    }
}