package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingResultSeTryWithResourcesDemo {
    public static void main(String ...args){


        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from player");
                ){

            String format = "%-4d%-20s%-20s%-12s%-22s%-5d%-5d%-5d\n";

            while(rs.next()){
                System.out.format(
                        format,
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
            }

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
    }
}

