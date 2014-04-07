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
public class ThuPhiKSK {
    private String thuPhiID;
    private String soKSK;
    private String thuNganID;
    private Date ngay;
    private Float soTien;

    public String getSoKSK() {
        return soKSK;
    }

    private void setSoKSK(String soKSK) {
        this.soKSK = soKSK;
    }

    public String getThuNganID() {
        return thuNganID;
    }

    private void setThuNganID(String thuNganID) {
        this.thuNganID = thuNganID;
    }

    public Date getNgay() {
        return ngay;
    }

    private void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Float getSoTien() {
        return soTien;
    }

    private void setSoTien(Float soTien) {
        this.soTien = soTien;
    }
    
    public ThuPhiKSK(String thuPhiID, String soKSK, String thuNganID, Date ngay, Float soTien){
        setThuPhiID(thuPhiID);
        setSoKSK(soKSK);
        setThuNganID(thuNganID);
        setNgay(ngay);
        setSoTien(soTien);
    }

    public String getThuPhiID() {
        return thuPhiID;
    }

    private void setThuPhiID(String thuPhiID) {
        this.thuPhiID = thuPhiID;
    }
}
