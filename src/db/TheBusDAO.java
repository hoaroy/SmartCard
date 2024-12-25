/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quoc An
 */
public class TheBusDAO {

    private Connection connection;

    public TheBusDAO() {
        try {
            this.connection = DriverManager.getConnection(DBConnector.CONNECT_URL, "root", "Dangquocan2002");
        } catch (SQLException ex) {
            Logger.getLogger(TheBusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addToDB(String id, String publicKey) {
        String sql = "INSERT INTO thong_tin (ID, public_key) VALUES (?, ?)";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, publicKey);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateToDBByID(String id, String newPublicKey) {
        String sql = "UPDATE thong_tin SET public_key = ? WHERE ID = ?";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newPublicKey);
            stmt.setString(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteByID(String id) {
        String sql = "DELETE FROM thong_tin WHERE ID = ?";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
