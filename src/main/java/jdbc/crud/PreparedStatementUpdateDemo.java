package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdateDemo {
    public static void main(String ...args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        String sql = "Update player set goals = ? where id = ?";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player Id");
        int playerId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Player Goals");
        int goals = Integer.parseInt(scanner.nextLine());

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, goals);
        pstmt.setInt(2, playerId);

        int result = pstmt.executeUpdate();

        if (result == 1)
            System.out.println("Record Inserted Successfully.");
        else
            System.out.println("Error while adding the record");

        scanner.close();
        pstmt.close();
        conn.close();
    }


}
