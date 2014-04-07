/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

import java.sql.Date;

/**
 *
 * @author bvndc
 */
public class TenNCKH {
    public String nckhID;
    public String loaiNCID;
    public String heID;
    public String capID;
    public String tenNCKH;
    public String thoiGian;
    public String khaNangUD;
    public Float kinhPhi;
    public int nam;
    public Date ngayDK;
    public int duocCN;
    public Date ngayCN;
    public String soQD;
    public int coDeTai;

    public String getNckhID() {
        return nckhID;
    }
    private void setNckhID(String nckhID) {
        this.nckhID = nckhID;
    }

    public String getLoaiNCID() {
        return loaiNCID;
    }
    private void setLoaiNCID(String loaiNCID) {
        this.loaiNCID = loaiNCID;
    }

    public String getHeID() {
        return heID;
    }
    private void setHeID(String heID) {
        this.heID = heID;
    }

    public String getCapID() {
        return capID;
    }
    private void setCapID(String capID) {
        this.capID = capID;
    }

    public String getTenNCKH() {
        return tenNCKH;
    }
    private void setTenNCKH(String tenNCKH) {
        this.tenNCKH = tenNCKH;
    }

    public String getThoiGian() {
        return thoiGian;
    }
    private void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getKhaNangUD() {
        return khaNangUD;
    }
    private void setKhaNangUD(String khaNangUD) {
        this.khaNangUD = khaNangUD;
    }

    public Float getKinhPhi() {
        return kinhPhi;
    }
    private void setKinhPhi(Float kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public int getNam() {
        return nam;
    }
    private void setNam(int nam) {
        this.nam = nam;
    }

    public Date getNgayDK() {
        return ngayDK;
    }
    private void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public int getDuocCN() {
        return duocCN;
    }
    private void setDuocCN(int duocCN) {
        this.duocCN = duocCN;
    }

    public Date getNgayCN() {
        return ngayCN;
    }
    private void setNgayCN(Date ngayCN) {
        this.ngayCN = ngayCN;
    }

    public String getSoQD() {
        return soQD;
    }
    private void setSoQD(String soQD) {
        this.soQD = soQD;
    }

    public int getCoDeTai() {
        return coDeTai;
    }
    private void setCoDeTai(int coDeTai) {
        this.coDeTai = coDeTai;
    }
    
    public TenNCKH(String nckhID, String loaiNCID, String heID, String capID, String tenNCKH, String thoiGian, String khaNangUD, Float kinhPhi, int nam, Date ngayDK, int duocCN, Date ngayCN, String soQD, int coDeTai){
        setNckhID(nckhID);
        setLoaiNCID(loaiNCID);
        setHeID(heID);
        setCapID(capID);
        setTenNCKH(tenNCKH);
        setThoiGian(thoiGian);
        setKhaNangUD(khaNangUD);
        setKinhPhi(kinhPhi);
        setNam(nam);
        setNgayDK(ngayDK);
        setDuocCN(duocCN);
        setNgayCN(ngayCN);
        setSoQD(soQD);
        setCoDeTai(coDeTai);
    }
}
