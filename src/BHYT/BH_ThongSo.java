/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BHYT;

/**
 *
 * @author bvndc
 */
public class BH_ThongSo {
    private String maKCB;
    private String maTT;
    private int mucThuTraiTuyen;
    private double mucSan;
    private double mucTran;
    private String khoCapNgoai;
    private String khoDongDuoc;

    public String getMaKCB() {
        return maKCB;
    }
    private void setMaKCB(String maKCB) {
        this.maKCB = maKCB;
    }

    public String getMaTT() {
        return maTT;
    }
    private void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public int getMucThuTraiTuyen() {
        return mucThuTraiTuyen;
    }
    private void setMucThuTraiTuyen(int mucThuTraiTuyen) {
        this.mucThuTraiTuyen = mucThuTraiTuyen;
    }

    public double getMucSan() {
        return mucSan;
    }
    private void setMucSan(double mucSan) {
        this.mucSan = mucSan;
    }

    public double getMucTran() {
        return mucTran;
    }
    private void setMucTran(double mucTran) {
        this.mucTran = mucTran;
    }

    public String getKhoCapNgoai() {
        return khoCapNgoai;
    }
    private void setKhoCapNgoai(String khoCapNgoai) {
        this.khoCapNgoai = khoCapNgoai;
    }

    public String getKhoDongDuoc() {
        return khoDongDuoc;
    }
    private void setKhoDongDuoc(String khoDongDuoc) {
        this.khoDongDuoc = khoDongDuoc;
    }
    
    public BH_ThongSo(String maKCB, String maTT, int mucThuTraiTuyen, double mucSan, double mucTran, String khoCapNgoai, String khoDongDuoc){
        setMaKCB(maKCB);
        setMaTT(maTT);
        setMucThuTraiTuyen(mucThuTraiTuyen);
        setMucSan(mucSan);
        setMucTran(mucTran);
        setKhoCapNgoai(khoCapNgoai);
        setKhoDongDuoc(khoDongDuoc);
    }
}
