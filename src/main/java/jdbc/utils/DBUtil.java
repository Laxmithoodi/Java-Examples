package jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "";
    private static final String mySqlCS = "jdbc:mysql://localhost:3306/team_manager";

    private static final String oracalUser = "root";
    private static final String oracalPwd = "";
    private static final String oracalCS = "jdbc:oracle://localhost:1521:xe";

    public static Connection getConnection(DBType dbType) throws SQLException {
        Connection conn = null;
        switch (dbType){
            case MYSQLDB:
                conn = DriverManager.getConnection(mySqlCS, mySqlUser, mySqlPwd);
                break;
            case ORADB:
                conn = DriverManager.getConnection(oracalCS, oracalUser, oracalPwd);
                break;
            default:
                return null;
        }

        return conn;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }
}
