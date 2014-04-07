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
public class TacGia {
    public String nckhID;
    public String maNV;
    public String loaiNVID;
    public int chuNhiem;

    public String getNckhID() {
        return nckhID;
    }

    private void setNckhID(String nckhID) {
        this.nckhID = nckhID;
    }

    public String getMaNV() {
        return maNV;
    }

    private void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiNVID() {
        return loaiNVID;
    }

    private void setLoaiNVID(String loaiNVID) {
        this.loaiNVID = loaiNVID;
    }

    public int getChuNhiem() {
        return chuNhiem;
    }

    private void setChuNhiem(int chuNhiem) {
        this.chuNhiem = chuNhiem;
    }
    
    public TacGia(String nckhID, String maNV, String loaiNVID, int chuNhiem){
        setNckhID(nckhID);
        setMaNV(maNV);
        setLoaiNVID(loaiNVID);
        setChuNhiem(chuNhiem);
    }
}
