/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODAL.clssDoUong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class tbDoUong {
    public static int LayDSDoUong(Vector<clssDoUong> dsdu){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "select * from douong ";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                clssDoUong douong = new clssDoUong();
                douong.setID(rs.getInt("id"));
                douong.setTenMonAn(rs.getString("tendouong"));
                douong.setDonGia(rs.getFloat("dongia"));
                dsdu.add(douong);
            }
            return dsdu.size();
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    public static int ThemDoUong(String tendouong, float dongia){
        Connection conn = DAO.Database.KetNoiCSDL();
    if(conn == null)
        return -1;
    String sql = "INSERT INTO douong (TenDoUong, DonGia) VALUES (?, ?)";
    try {
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, tendouong);
        stm.setFloat(2, dongia);
        int n = stm.executeUpdate();
        return n;
    } catch (SQLException ex) {
        Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
        return -2;
    }
    }
    
    public static int SuaDoUong(int id, String tendouong, float dongia){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "update douong "
                + " set TenDoUong=?, DonGia=? "
                + " where ID=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tendouong);
            stm.setFloat(2, dongia);
            stm.setInt(3, id);
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    public static int XoaDoUong(int id){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "delete from douong "
                + " where ID=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
}
