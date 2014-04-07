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
public class ICDNhom {
    private int icdNhomID;
    private int icdChuongID;
    private String tenNhom;

    public int getIcdNhomID() {
        return icdNhomID;
    }
    private void setIcdNhomID(int icdNhomID) {
        this.icdNhomID = icdNhomID;
    }

    public int getIcdChuongID() {
        return icdChuongID;
    }
    private void setIcdChuongID(int icdChuongID) {
        this.icdChuongID = icdChuongID;
    }

    public String getTenNhom() {
        return tenNhom;
    }
    private void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }
    
    public ICDNhom(int icdNhomID, int icdChuongID, String tenNhom){
        setIcdNhomID(icdNhomID);
        setIcdChuongID(icdChuongID);
        setTenNhom(tenNhom);
    }
    public ICDNhom(){
        setIcdNhomID(0);
        setIcdChuongID(0);
        setTenNhom(null);
    }
}
