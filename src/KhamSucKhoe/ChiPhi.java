/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

/**
 *
 * @author bvndc
 */
public class ChiPhi {
    private String soKSK;
    private String giaVPID;
    private int soLuong;
    private Float donGia;

    public String getSoKSK() {
        return soKSK;
    }

    private void setSoKSK(String soKSK) {
        this.soKSK = soKSK;
    }

    public String getGiaVPID() {
        return giaVPID;
    }

    private void setGiaVPID(String giaVPID) {
        this.giaVPID = giaVPID;
    }

    public int getSoLuong() {
        return soLuong;
    }

    private void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    private void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    
    public ChiPhi(String soKSK, String giaVPID, int soLuong, Float donGia){
        setSoKSK(soKSK);
        setGiaVPID(giaVPID);
        setSoLuong(soLuong);
        setDonGia(donGia);
    }
}
