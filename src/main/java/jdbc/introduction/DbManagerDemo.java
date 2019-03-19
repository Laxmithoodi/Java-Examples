package jdbc.introduction;

import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static jdbc.utils.DBType.MYSQLDB;

public class DbManagerDemo {


    public static void main(String ...args) throws SQLException {

        Connection conn = null;

        try{
            conn = DBUtil.getConnection(MYSQLDB);

            System.out.println("Connection Established to MYSQL Database");

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        } finally {

            conn.close();

        }
    }
}
