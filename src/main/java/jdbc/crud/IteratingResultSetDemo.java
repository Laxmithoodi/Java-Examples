package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingResultSetDemo {
    public static void main(String ...args) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection(DBType.MYSQLDB); //Establish Connection to a Database
            stmt = conn.createStatement(); //Create Statement Object
            rs = stmt.executeQuery("select * from player"); //Execute SQL Query

            String format = "%-4d%-20s%-20s%-12s%-22s%-5d%-5d%-5d\n";

            while(rs.next()){
                System.out.format(
                        format,
                        rs.getInt("number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("position"),
                        rs.getString("nationality"),
                        rs.getInt("appearances"),
                        rs.getInt("goals"),
                        rs.getInt("assists")
                );
            }

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        } finally {
            /* you should always close a connection that you have opened
               always close in reverse order of how connections where opened */
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();
        }
    }
}

