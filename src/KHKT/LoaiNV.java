/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

/**
 *
 * @author bvndc
 */
public class LoaiNV {
    private String loaiNVID;
    private String tenLoaiNV;

    public String getLoaiNVID() {
        return loaiNVID;
    }

    private void setLoaiNVID(String loaiNVID) {
        this.loaiNVID = loaiNVID;
    }

    public String getTenLoaiNV() {
        return tenLoaiNV;
    }

    private void setTenLoaiNV(String tenLoaiNV) {
        this.tenLoaiNV = tenLoaiNV;
    }
    
    public LoaiNV(String loaiNVID, String tenLoaiNV){
        setLoaiNVID(loaiNVID);
        setTenLoaiNV(tenLoaiNV);
    }
}
