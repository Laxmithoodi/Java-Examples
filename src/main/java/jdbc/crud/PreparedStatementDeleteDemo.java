package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDeleteDemo {
    public static void main(String ...args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        String sql = "Delete from player where id = ?";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player Id to Remove");
        int playerId = Integer.parseInt(scanner.nextLine());

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, playerId);

        int result = pstmt.executeUpdate();

        if (result == 1)
            System.out.println("Record Removed Successfully.");
        else
            System.out.println("Error while Remove the record");

        scanner.close();
        pstmt.close();
        conn.close();
    }
}
