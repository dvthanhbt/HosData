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
public class KhoaPhong {
    private String maKP;
    private String loaiKPID;
    private String tenKP;
    private String kyHieu;
    private String maSPSD;
    private int dichVu;
    private int hieuLuc;

    public String getMaKP() {
        return maKP;
    }
    private void setMaKP(String maKP) {
        this.maKP = maKP;
    }
    
    public String getLoaiKPID() {
        return loaiKPID;
    }
    private void setLoaiKPID(String loaiKPID) {
        this.loaiKPID = loaiKPID;
    }

    public String getTenKP() {
        return tenKP;
    }
    private void setTenKP(String tenKP) {
        this.tenKP = tenKP;
    }

    public String getKyHieu() {
        return kyHieu;
    }
    private void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getMaSPSD() {
        return maSPSD;
    }
    private void setMaSPSD(String maSPSD) {
        this.maSPSD = maSPSD;
    }

    public int getDichVu() {
        return dichVu;
    }
    private void setDichVu(int dichVu) {
        this.dichVu = dichVu;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public KhoaPhong(String maKP, String loaiKPID, String tenKP, String kyHieu, String maSPSD, int dichVu, int hieuLuc){
        setMaKP(maKP);
        setLoaiKPID(loaiKPID);
        setTenKP(tenKP);
        setKyHieu(kyHieu);
        setMaSPSD(maSPSD);
        setDichVu(dichVu);
        setHieuLuc(hieuLuc);
    }
}
