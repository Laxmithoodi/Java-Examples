package jdbc.abstraction;

import jdbc.abstraction.dao.PlayerDAO;
import jdbc.abstraction.model.Player;
import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoDemo {
    public static void main(String ...args){
        try(Connection conn = DBUtil.getConnection(DBType.MYSQLDB);){
            PlayerDAO playerDAO = new PlayerDAO(conn);

            // Create
            /*
            Player playerCreate = new Player();
            playerCreate.setNumber(42);
            playerCreate.setFirstName("froilan");
            playerCreate.setLastName("miranda");
            playerCreate.setPosition("Midfielder");
            playerCreate.setNationality("USA");
            playerCreate.setAppearances(20);
            playerCreate.setGoals(10);
            playerCreate.setAssists(15);

            playerDAO.create(playerCreate);
            /**/


            // Read
            /*
            Player playerRead = playerDAO.findById(12);
            System.out.println(playerRead);
            /**/


            // Update
            /*
            Player playerUpdate = playerDAO.findById(41);
            System.out.println(playerUpdate);
            playerUpdate.setPosition("Forward");
            System.out.println(playerUpdate);
            /**/

            // DELETE
            /**/
            playerDAO.delete(41);
            /**/
        }catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }
}
