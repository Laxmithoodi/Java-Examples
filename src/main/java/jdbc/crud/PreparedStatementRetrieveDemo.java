package jdbc.crud;

import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementRetrieveDemo {
    public static void main(String ...args){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection(DBType.MYSQLDB);

            String sql = "Select * From player where goals > ? and position = ?;";

            //  Example of setting scroll and concurrent parameters
            // pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt = conn.prepareStatement(sql);

            /*
            pstmt.setInt(1, 5);
            pstmt.setString(2, "Midfielder");

            rs = pstmt.executeQuery();

            String format = "%-4d%-20s%-20s%-12s%-22s%-5d%-5d%-5d\n";

            while(rs.next()){
                System.out.format(format, rs.getInt("number"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("position"),
                        rs.getString("nationality"), rs.getInt("appearances"),
                        rs.getInt("goals"), rs.getInt("assists"));
            }

            rs.last();
            System.out.println("Total Players: " + rs.getRow());
            /**/

            prepareStatement(pstmt, 5, "Midfielder");
            System.out.println("------------------------------------------------------------------------------------------");
            prepareStatement(pstmt, 5, "Forward");
            /**/
        }
        catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }

    private static void prepareStatement(PreparedStatement pstmt, int goals, String position) throws SQLException {
        ResultSet rs;
        pstmt.setInt(1, goals);
        pstmt.setString(2, position);

        rs = pstmt.executeQuery();

        String format = "%-4d%-20s%-20s%-12s%-22s%-5d%-5d%-5d\n";

        while(rs.next()){
            System.out.format(format, rs.getInt("number"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("position"),
                    rs.getString("nationality"), rs.getInt("appearances"),
                    rs.getInt("goals"), rs.getInt("assists"));
        }

        rs.last();
        System.out.println("Total Players: " + rs.getRow());
    }
}
