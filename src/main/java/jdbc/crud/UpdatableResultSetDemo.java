package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdatableResultSetDemo {
    public static void main(String ...args){
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("Select * from player where position = 'Midfielder'")
                )
        {
            rs.absolute(11);

            rs.updateInt("goals", 2);
            rs.updateRow();

            System.out.println("Record Updated Successfully");

            rs.moveToInsertRow();
            rs.updateInt("number", 3);
            rs.updateString("first_name", "Froilan");
            rs.updateString("last_name", "Miranda");
            rs.updateString("position", "Midfielder");
            rs.updateString("nationality", "usa");
            rs.updateInt("appearances", 20);
            rs.updateInt("goals", 4);
            rs.updateInt("assists", 10);
            rs.insertRow();

            System.out.println("Record Inserted Successfully");
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }
}