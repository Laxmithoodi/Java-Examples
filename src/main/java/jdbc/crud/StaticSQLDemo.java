package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSQLDemo {
    public static void main(String ...args) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{

            conn = DBUtil.getConnection(DBType.MYSQLDB); //Establish Connection to a Database
            stmt = conn.createStatement(); //Create Statement Object
            rs = stmt.executeQuery("select * from player"); //Execute SQL Query
            rs.last(); //navagating to end of results
            System.out.println("Total No. of Rows:" + rs.getRow()); // Process the ResultSet

        } catch (SQLException e) {

            DBUtil.showErrorMessage(e);

        } finally {

            // You should always close a connection that you have opened
            // Always close in reverse order of how connections where opened

            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();

        }
    }
}
