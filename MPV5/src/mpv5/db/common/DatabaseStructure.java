/*
 *  This file is part of MP by anti43 /GPL.
 *
 *  MP is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  MP is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with MP.  If not, see <http://www.gnu.org/licenses/>.
 */
package mpv5.db.common;

/**
 *
 * @author Administrator
 */
public class DatabaseStructure {

    public final static String[] DERBY = new String[]{"CREATE TABLE contacts (IDS BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
        "cnumber VARCHAR(250),title VARCHAR(250) default NULL," +
        "prename VARCHAR(250) default NULL, cname VARCHAR(250) default NULL, street VARCHAR(250) default NULL," +
        "zip VARCHAR(50) default NULL,city VARCHAR(300) default NULL, mainphone VARCHAR(250) default NULL," +
        "fax VARCHAR(250) default NULL,mobilephone VARCHAR(250) default NULL,workphone VARCHAR(250) default NULL," +
        "mailaddress VARCHAR(350) default NULL,companyuid INTEGER default NULL," +
        "website VARCHAR(350) default NULL,notes VARCHAR(10000),taxid VARCHAR(350) default NULL," +
        "dateadded DATE DEFAULT CURRENT_DATE,isactive SMALLINT DEFAULT 0,iscustomer SMALLINT DEFAULT 0," +
        "ismanufacturer SMALLINT DEFAULT 0,issupplier SMALLINT DEFAULT 0,iscompany SMALLINT DEFAULT 0," +
        "ismale SMALLINT DEFAULT 0,isenabled SMALLINT DEFAULT 1," +
        "reserve1 VARCHAR(500) default NULL,reserve2 VARCHAR(500) default NULL," +
        "PRIMARY KEY  (ids))"};
}