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
public class ThuPhiCQ {
    private String coQuanID;
    private String thuNganID;
    private Date ngay;
    private Float soTien;

    public String getCoQuanID() {
        return coQuanID;
    }

    private void setCoQuanID(String coQuanID) {
        this.coQuanID = coQuanID;
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
    
    public ThuPhiCQ(String coQuanID, String thuNganID, Date ngay, Float soTien){
        setCoQuanID(coQuanID);
        setThuNganID(thuNganID);
        setNgay(ngay);
        setSoTien(soTien);
    }
}
