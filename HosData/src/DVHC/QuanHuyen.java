/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

/**
 *
 * @author bvndc
 */
public class QuanHuyen {
    private String maQH;
    private String maTT;
    private String tenQH;
    private String tenTat;
    public String getMaQH() {
        return maQH;
    }
    public String getMaTT() {
        return maTT;
    }
    public String getTenQH() {
        return tenQH;
    }
    public String getTenTat() {
        return tenTat;
    }
    private void setMaQH(String maQH) {
        this.maQH = maQH;
    }
    private void setMaTT(String maTT) {
        this.maTT = maTT;
    }
    private void setTenQH(String tenQH) {
        this.tenQH = tenQH;
    }
    private void setTenTat(String tenTat) {
        this.tenTat = tenTat;
    }
    public QuanHuyen (String maQH, String maTT, String tenQH, String tenTat){
        setMaQH(maQH);
        setMaTT(maTT);
        setTenQH(tenQH);
        setTenTat(tenTat);
    }    
}
