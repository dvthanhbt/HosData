/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import java.sql.Date;

/**
 *
 * @author bvndc
 */
public class GiayKSK {
    private String soKSK;
    private Date ngay;
    private String hoTen;
    private int namSinh;
    private int gioiTinh;
    private String soCMND;
    private Date capNgay;
    private String diaChi;
    private String lyDoID;
    private String quocGiaID;
    private String coQuanID;
    private String ketQua;

    public String getSoKSK() {
        return soKSK;
    }

    private void setSoKSK(String soKSK) {
        this.soKSK = soKSK;
    }

    public Date getNgay() {
        return ngay;
    }

    private void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getHoTen() {
        return hoTen;
    }

    private void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    private void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    private void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    private void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Date getCapNgay() {
        return capNgay;
    }

    private void setCapNgay(Date capNgay) {
        this.capNgay = capNgay;
    }

    public String getDiaChi() {
        return diaChi;
    }

    private void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLyDoID() {
        return lyDoID;
    }

    private void setLyDoID(String lyDoID) {
        this.lyDoID = lyDoID;
    }

    public String getQuocGiaID() {
        return quocGiaID;
    }

    private void setQuocGiaID(String quocGiaID) {
        this.quocGiaID = quocGiaID;
    }

    public String getCoQuanID() {
        return coQuanID;
    }

    private void setCoQuanID(String coQuanID) {
        this.coQuanID = coQuanID;
    }

    public String getKetQua() {
        return ketQua;
    }

    private void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    
    public GiayKSK(String soKSK, Date ngay, String hoTen, int namSinh, int gioiTinh, String soCMND, Date capNgay, String diaChi, String lyDoID, String quocGiaID, String coQuanID, String ketQua){
        setSoKSK(soKSK);
        setNgay(ngay);
        setHoTen(hoTen);
        setNamSinh(namSinh);
        setGioiTinh(gioiTinh);
        setSoCMND(soCMND);
        setCapNgay(capNgay);
        setDiaChi(diaChi);
        setLyDoID(lyDoID);
        setQuocGiaID(quocGiaID);
        setCoQuanID(coQuanID);
        setKetQua(ketQua);
    }
}
