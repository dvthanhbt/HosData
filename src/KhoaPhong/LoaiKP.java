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
public class LoaiKP {
    private String loaiKPID;
    private String tenLoaiKP;

    public String getLoaiKPID() {
        return loaiKPID;
    }
    private void setLoaiKPID(String loaiKPID) {
        this.loaiKPID = loaiKPID;
    }

    public String getTenLoaiKP() {
        return tenLoaiKP;
    }
    private void setTenLoaiKP(String tenLoaiKP) {
        this.tenLoaiKP = tenLoaiKP;
    }
    
    public LoaiKP(String loaiKPID, String tenLoaiKP){
        setLoaiKPID(loaiKPID);
        setTenLoaiKP(tenLoaiKP);
    }
}
