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
public class BH_Huyen {
    private String maHuyen;
    private String maTT;
    private String tenHuyen;

    public String getMaHuyen() {
        return maHuyen;
    }

    private void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaTT() {
        return maTT;
    }

    private void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    private void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }
    
    public BH_Huyen(String maHuyen, String maTT, String tenHuyen){
        setMaHuyen(maHuyen);
        setMaTT(maTT);
        setTenHuyen(tenHuyen);
    }
    
    public BH_Huyen(){
        setMaHuyen(null);
        setMaTT(null);
        setTenHuyen(null);
    }
}
