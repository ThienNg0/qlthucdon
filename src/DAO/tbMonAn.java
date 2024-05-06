/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODAL.clssMonAn;
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
public class tbMonAn {
    public static int LayDSMonAn(Vector<clssMonAn> dsmn){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "SELECT * FROM monan ";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                clssMonAn monan = new clssMonAn();
                monan.setSTT(rs.getInt("id"));
                monan.setTenMonAn(rs.getString("tenmonan"));
                monan.setDonGia(rs.getFloat("dongia"));
                dsmn.add(monan);
            }
            return dsmn.size();
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    public static int ThemMonAn(String tenmonan, float dongia){
        Connection conn = DAO.Database.KetNoiCSDL();
    if(conn == null)
        return -1;
    String sql = "INSERT INTO monan (TenMonAn, DonGia) VALUES (?, ?)";
    try {
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, tenmonan);
        stm.setFloat(2, dongia);
        int n = stm.executeUpdate();
        return n;
    } catch (SQLException ex) {
        Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
        return -2;
    }
    }
    
    public static int SuaMonAn(int stt, String tenmonan, float dongia){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "update monan "
                + " set TenMonAn=?, DonGia=? "
                + " where ID=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenmonan);
            stm.setFloat(2, dongia);
            stm.setInt(3, stt);
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
    
    public static int XoaMonAn(int stt){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "delete from monan "
                + " where ID=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, stt);
            int n = stm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(tbMonAn.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
}
