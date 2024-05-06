/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODAL;

/**
 *
 * @author ADMIN
 */
public class clssDoUong {
    public int ID;
    public String TenDoUong;
    public float DonGia;

    public clssDoUong() {
    }

    public clssDoUong(int ID, String TenDoUong, float DonGia) {
        this.ID = ID;
        this.TenDoUong = TenDoUong;
        this.DonGia = DonGia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDoUong() {
        return TenDoUong;
    }

    public void setTenMonAn(String TenDoUong) {
        this.TenDoUong = TenDoUong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
    
}
