package jdbc.abstraction.dao;


import jdbc.abstraction.model.Player;
import jdbc.utils.DBType;
import jdbc.utils.DBUtil;

import java.sql.*;
import java.util.List;

public class PlayerDAO extends DAO<Player> {

    private static final String INSERT = "Insert into player" +
            "(number, first_name, last_name, position, nationality, appearances, goals, assists)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM player WHERE id = ?";
    private static final String UPDATE = "Update player set number = ?, first_name = ?, last_name = ?, position = ?, " +
            "nationality = ?, appearances = ?, goals = ?, assists = ? where id = ?";
    private static final String DELETE = "DELETE FROM player WHERE id = ?";

    public PlayerDAO(Connection conn) {
        super(conn);
    }

    @Override
    public Player findById(int id) {
        Player player = null;
        try(PreparedStatement pstmt = DBUtil.getConnection(DBType.MYSQLDB).prepareStatement(GET_ONE);){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                player = new Player();
                player.setId(rs.getInt("id"));
                player.setNumber(rs.getInt("number"));
                player.setFirstName(rs.getString("first_name"));
                player.setLastName(rs.getString("last_name"));
                player.setPosition(rs.getString("position"));
                player.setNationality(rs.getString("nationality"));
                player.setAppearances(rs.getInt("appearances"));
                player.setGoals(rs.getInt("goals"));
                player.setAssists(rs.getInt("assists"));

            }
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return player;
    }

    @Override
    public List<Player> findAll() {
        return null;
    }

    @Override
    public Player update(Player dto) {
        Player player = null;
        try(PreparedStatement pstmt = this.connection.prepareStatement(UPDATE);){
            pstmt.setInt(1, dto.getNumber());
            pstmt.setString(2, dto.getFirstName());
            pstmt.setString(3, dto.getLastName());
            pstmt.setString(4, dto.getPosition());
            pstmt.setString(5, dto.getNationality());
            pstmt.setInt(6, dto.getAppearances());
            pstmt.setInt(7, dto.getGoals());
            pstmt.setInt(8, dto.getAssists());
            pstmt.setInt(9, dto.getId());
            player = this.findById(dto.getId());
        }catch (SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return player;
    }

    @Override
    public Player create(Player dto) {
        try(PreparedStatement pstmt = this.connection.prepareStatement(INSERT);){
            pstmt.setInt(1, dto.getNumber());
            pstmt.setString(2, dto.getFirstName());
            pstmt.setString(3, dto.getLastName());
            pstmt.setString(4, dto.getPosition());
            pstmt.setString(5, dto.getNationality());
            pstmt.setInt(6, dto.getAppearances());
            pstmt.setInt(7, dto.getGoals());
            pstmt.setInt(8, dto.getAssists());
            pstmt.executeUpdate();

            //TODO: get newly created auto_generated id from created record and return it below
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement pstmt = this.connection.prepareStatement(DELETE);){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
            DBUtil.showErrorMessage(e);
        }
    }
}

