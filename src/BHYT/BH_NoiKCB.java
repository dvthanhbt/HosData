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
public class BH_NoiKCB {
    private String maKCB;
    private String maTT;
    private String tenKCB;
    private String diaChi;

    public String getMaKCB() {
        return maKCB;
    }
    private void setMaKCB(String maKCB) {
        this.maKCB = maKCB;
    }

    public String getMaTT() {
        return maTT;
    }
    private void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTenKCB() {
        return tenKCB;
    }
    private void setTenKCB(String tenKCB) {
        this.tenKCB = tenKCB;
    }

    public String getDiaChi() {
        return diaChi;
    }
    private void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public BH_NoiKCB(String maKCB, String maTT, String tenKCB, String diaChi){
        setMaKCB(maKCB);
        setMaTT(maTT);
        setTenKCB(tenKCB);
        setDiaChi(diaChi);
    }
    public BH_NoiKCB(){
        setMaKCB(null);
        setMaTT(null);
        setTenKCB(null);
        setDiaChi(null);
    }
    public void setNoiKCB(String maKCB, String maTT, String tenKCB, String diaChi){
        setMaKCB(maKCB);
        setMaTT(maTT);
        setTenKCB(tenKCB);
        setDiaChi(diaChi);
    }
}
