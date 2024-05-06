/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

import java.util.Date;

/**
 *
 * @author thien
 */
public class clssNhanVien {
     private String taiKhoan;
    private String matKhau;
    private String ten;
    private int sdt;
    private Date ngayVL;

    // Constructors
    public clssNhanVien() {
    }

    public clssNhanVien(String taiKhoan, String matKhau, String ten, int sdt, Date ngayVL) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ten = ten;
        this.sdt = sdt;
        this.ngayVL = ngayVL;
    }

    // Getters and Setters
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setSDT(int sdt) {
    this.sdt = sdt;
}


    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public Date getNgayVL() {
        return ngayVL;
    }
    public int getSDT() {
    return this.sdt;
}


    public void setNgayVL(Date ngayVL) {
        this.ngayVL = ngayVL;
    }

    // toString method for debugging or printing

    
   
   
}
