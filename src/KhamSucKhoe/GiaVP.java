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
public class GiaVP {
    private String giaVPID;
    private String tenGiaVP;
    private String donVi;
    private Float giaTH;
    private Float giaBH;
    private Float giaDV;
    private int bhyt;
    private int hide;
    public String getGiaVPID() {
        return giaVPID;
    }

    private void setGiaVPID(String giaVPID) {
        this.giaVPID = giaVPID;
    }

    public String getTenGiaVP() {
        return tenGiaVP;
    }

    private void setTenGiaVP(String tenGiaVP) {
        this.tenGiaVP = tenGiaVP;
    }

    public String getDonVi() {
        return donVi;
    }

    private void setDonVi(String donVi) {
        this.donVi = donVi;
    }
    
    public GiaVP(String giaVPID, String tenGiaVP, String donVi, Float giaTH, Float giaBH, Float giaDV, int bhyt, int hide){
        setGiaVPID(giaVPID);
        setTenGiaVP(tenGiaVP);
        setDonVi(donVi);
        setGiaTH(giaTH);
        setGiaBH(giaBH);
        setGiaDV(giaDV);
        setBhyt(bhyt);
        setHide(hide);
    }

    public Float getGiaTH() {
        return giaTH;
    }

    private void setGiaTH(Float giaTH) {
        this.giaTH = giaTH;
    }

    public Float getGiaBH() {
        return giaBH;
    }

    private void setGiaBH(Float giaBH) {
        this.giaBH = giaBH;
    }

    public Float getGiaDV() {
        return giaDV;
    }

    private void setGiaDV(Float giaDV) {
        this.giaDV = giaDV;
    }

    public int getBhyt() {
        return bhyt;
    }

    private void setBhyt(int bhyt) {
        this.bhyt = bhyt;
    }

    public int getHide() {
        return hide;
    }

    private void setHide(int hide) {
        this.hide = hide;
    }
}
