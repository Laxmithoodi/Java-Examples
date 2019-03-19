package jdbc.crud;

import jdbc.introduction.DbManagerDemo;
import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollingResultSet {
    public static void main(String ...args){
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("Select * from Player LIMIT 10");
                )
        {
            String format = "%-4d%-20s%-20s%-12s%-22s%-5d%-5d%-5d\n";

            /*
            rs.beforeFirst();
            System.out.println("Fist 10 Rows: ");
            while(rs.next()){
                System.out.format(format, rs.getInt(2), rs.getString("first_name"),
                        rs.getString(4), rs.getString("position"),
                        rs.getString(6), rs.getInt("appearances"),
                        rs.getInt(8), rs.getInt("assists"));
            }
            /**/

            /*
            rs.afterLast();
            System.out.println("\nLast 10 Rows: ");
            while(rs.previous()){
                System.out.format(format, rs.getInt(2), rs.getString("first_name"),
                        rs.getString(4), rs.getString("position"),
                        rs.getString(6), rs.getInt("appearances"),
                        rs.getInt(8), rs.getInt("assists"));
            }
            /**/

            /*
            rs.first();
            System.out.println("\nFirst Record: ");
            System.out.format(format, rs.getInt(2), rs.getString("first_name"), rs.getString(4),
                    rs.getString("position"), rs.getString(6), rs.getInt("appearances"),
                    rs.getInt(8), rs.getInt("assists"));
            /**/

            /*
            rs.last();
            System.out.println("\nLast Record: ");
            System.out.format(format, rs.getInt(2), rs.getString("first_name"), rs.getString(4),
                    rs.getString("position"), rs.getString(6), rs.getInt("appearances"),
                    rs.getInt(8), rs.getInt("assists"));
            /**/

            /*
            rs.absolute(4);
            System.out.println("\nRecord at 4th Row: ");
            System.out.format(format, rs.getInt(2), rs.getString("first_name"), rs.getString(4),
                    rs.getString("position"), rs.getString(6), rs.getInt("appearances"),
                    rs.getInt(8), rs.getInt("assists"));
            /**/

            /*
            rs.relative(2);
            System.out.println("\nRecord at 6th Row: ");
            System.out.format(format, rs.getInt(2), rs.getString("first_name"), rs.getString(4),
                    rs.getString("position"), rs.getString(6), rs.getInt("appearances"),
                    rs.getInt(8), rs.getInt("assists"));
            /**/

            /*
            rs.relative(-4);
            System.out.println("\nRecord at 2nd Row: ");
            System.out.format(format, rs.getInt(2), rs.getString("first_name"), rs.getString(4),
                    rs.getString("position"), rs.getString(6), rs.getInt("appearances"),
                    rs.getInt(8), rs.getInt("assists"));
            /**/

        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }
}
