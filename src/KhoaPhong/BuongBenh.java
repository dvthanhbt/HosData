/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhoaPhong;

/**
 *
 * @author bvndc
 */
public class BuongBenh {
    private String buongID;
    private String maKP;
    private String tenBuong;
    private int hieuLuc;

    public String getBuongID() {
        return buongID;
    }
    private void setBuongID(String buongID) {
        this.buongID = buongID;
    }

    public String getMaKP() {
        return maKP;
    }
    private void setMaKP(String maKP) {
        this.maKP = maKP;
    }

    public String getTenBuong() {
        return tenBuong;
    }
    private void setTenBuong(String tenBuong) {
        this.tenBuong = tenBuong;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public BuongBenh(String buongID, String maKP, String tenBuong, int hieuLuc){
        setBuongID(buongID);
        setMaKP(maKP);
        setTenBuong(tenBuong);
        setHieuLuc(hieuLuc);
    }
}
