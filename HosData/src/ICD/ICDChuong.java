/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ICD;

/**
 *
 * @author bvndc
 */
public class ICDChuong {
    private int icdChuongID;
    private String tenChuong;

    public int getIcdChuongID() {
        return icdChuongID;
    }
    private void setIcdChuongID(int icdChuongID) {
        this.icdChuongID = icdChuongID;
    }

    public String getTenChuong() {
        return tenChuong;
    }
    private void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }
    
    public ICDChuong(int icdChuongID, String tenChuong){
        setIcdChuongID(icdChuongID);
        setTenChuong(tenChuong);
    }
    public ICDChuong(){
        setIcdChuongID(0);
        setTenChuong(null);
    }
}
