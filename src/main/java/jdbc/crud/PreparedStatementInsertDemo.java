package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsertDemo {
    public static void main(String ...args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        int id;
        int number;
        String first_name;
        String last_name;
        String position;
        String nationality;
        int appearances;
        int goals;
        int assists;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player Number");
        number = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Player First Name");
        first_name = scanner.nextLine();

        System.out.println("Enter Player Last Name");
        last_name = scanner.nextLine();

        System.out.println("Enter Player Position");
        position = scanner.nextLine();

        System.out.println("Enter Player Nationality");
        nationality = scanner.nextLine();

        System.out.println("Enter Player Appearances");
        appearances = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Player Goals");
        goals = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Player Assists");
        assists = Integer.parseInt(scanner.nextLine());

        String sql = "Insert into player " +
                "(number, first_name, last_name, position, nationality, appearances, goals, assists) " +
                "values(?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, number);
        pstmt.setString(2, first_name);
        pstmt.setString(3, last_name);
        pstmt.setString(4, position);
        pstmt.setString(5, nationality);
        pstmt.setInt(6, appearances);
        pstmt.setInt(7, goals);
        pstmt.setInt(8, assists);


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
