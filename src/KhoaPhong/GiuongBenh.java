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
public class GiuongBenh {
    private String giuongID;
    private String buongID;
    private String maKP;
    private String tenGiuong;
    private String maSPSD;
    private String nhapKhoaID;
    private int hieuLuc;

    public String getGiuongID() {
        return giuongID;
    }
    private void setGiuongID(String giuongID) {
        this.giuongID = giuongID;
    }

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

    public String getTenGiuong() {
        return tenGiuong;
    }
    private void setTenGiuong(String tenGiuong) {
        this.tenGiuong = tenGiuong;
    }

    public String getMaSPSD() {
        return maSPSD;
    }
    private void setMaSPSD(String maSPSD) {
        this.maSPSD = maSPSD;
    }

    public String getNhapKhoaID() {
        return nhapKhoaID;
    }
    private void setNhapKhoaID(String nhapKhoaID) {
        this.nhapKhoaID = nhapKhoaID;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public GiuongBenh(String giuongID, String buongID, String maKP, String tenGiuong, String maSPSD, String nhapKhoaID, int hieuLuc){
        setGiuongID(giuongID);
        setBuongID(buongID);
        setMaKP(maKP);
        setTenGiuong(tenGiuong);
        setMaSPSD(maSPSD);
        setNhapKhoaID(nhapKhoaID);
        setHieuLuc(hieuLuc);
    }
}
