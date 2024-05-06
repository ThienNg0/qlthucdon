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
public class clssMonAn {
    public int STT;
    public String TenMonAn;
    public float DonGia;

    public clssMonAn() {
    }

    public clssMonAn(int STT, String TenMonAn, float DonGia) {
        this.STT = STT;
        this.TenMonAn = TenMonAn;
        this.DonGia = DonGia;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String TenMonAn) {
        this.TenMonAn = TenMonAn;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
}
