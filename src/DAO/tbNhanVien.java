/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODAL.clssNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author thien
 */
public class tbNhanVien {
     public static int LayDSNhanVien(Vector<clssNhanVien> dsnv){
        Connection conn = DAO.Database.KetNoiCSDL();
        if(conn == null)
            return -1;
        String sql = "SELECT * FROM dangnhap_nhanvien";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                clssNhanVien nhanvien = new clssNhanVien();
                
                 nhanvien.setTaiKhoan(rs.getString("TaiKhoan"));
                 nhanvien.setTen(rs.getString("Ten"));
                 nhanvien.setSDT(rs.getInt("SDT"));
                 nhanvien.setNgayVL(rs.getDate("NgayVL"));
                dsnv.add(nhanvien);
            }
            return dsnv.size();
        } catch (SQLException ex) {
            Logger.getLogger(tbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
    }
     public static int ThemNhanVien(String taiKhoan, String matKhau, String ten, int sdt, java.util.Date ngayVL) {
    Connection conn = DAO.Database.KetNoiCSDL();
    if (conn == null)
        return -1;

    // Kiểm tra xem tài khoản đã tồn tại hay chưa
    if (KiemTraTonTai(taiKhoan)) {
        return -3; // Mã lỗi -3: Tài khoản đã tồn tại
    }
    
    String sql = "INSERT INTO dangnhap_nhanvien (TaiKhoan, MatKhau, Ten, SDT, NgayVL) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, taiKhoan);
        stm.setString(2, matKhau);
        stm.setString(3, ten);
        stm.setInt(4, sdt);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date ngayVL_SQL = new java.sql.Date(ngayVL.getTime());
        stm.setDate(5, ngayVL_SQL);
        
        int n = stm.executeUpdate();
        return n;
    } catch (SQLException ex) {
        Logger.getLogger(tbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        return -2;
    }
}
     private static boolean KiemTraTonTai(String taiKhoan) {
    Connection conn = DAO.Database.KetNoiCSDL();
    if (conn == null)
        return false;

    String sql = "SELECT COUNT(*) AS Count FROM dangnhap_nhanvien WHERE TaiKhoan=?";
    try {
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, taiKhoan);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("Count");
            return count > 0;
        }
        return false;
    } catch (SQLException ex) {
        Logger.getLogger(tbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}

  public static int SuaNhanVien(String taiKhoan, String matKhau, String ten, int sdt, java.util.Date ngayVL) {
    try (Connection conn = DAO.Database.KetNoiCSDL()) {
        if (conn == null)
            return -1;
        
        String sql = "UPDATE dangnhap_nhanvien SET MatKhau=?, Ten=?, SDT=?, NgayVL=? WHERE TaiKhoan=?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, matKhau);
            stm.setString(2, ten);
            stm.setInt(3, sdt);
            // Convert java.util.Date to java.sql.Date
            java.sql.Date ngayVL_SQL = new java.sql.Date(ngayVL.getTime());
            stm.setDate(4, ngayVL_SQL);
            stm.setString(5, taiKhoan); // Sử dụng tài khoản hiện tại
            int n = stm.executeUpdate();
            return n;
        }
    } catch (SQLException ex) {
        Logger.getLogger(tbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        return -2;
    }
}
public static int XoaNhanVien(String taiKhoan) {
    try (Connection conn = DAO.Database.KetNoiCSDL()) {
        if (conn == null)
            return -1;
        
        String sql = "DELETE FROM dangnhap_nhanvien WHERE TaiKhoan=?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, taiKhoan);
            int n = stm.executeUpdate();
            return n;
        }
    } catch (SQLException ex) {
        Logger.getLogger(tbNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        return -2;
    }
}


     
}
