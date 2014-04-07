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
public class XaPhuong {
    private String maXP;
    private String maQH;
    private String tenXP;
    private String tenTat;
    public String getMaXP() {
        return maXP;
    }
    public String getMaQH() {
        return maQH;
    }
    public String getTenXP() {
        return tenXP;
    }
    public String getTenTat() {
        return tenTat;
    }
    private void setMaXP(String maXP) {
        this.maXP = maXP;
    }
    private void setMaQH(String maQH) {
        this.maQH = maQH;
    }
    private void setTenXP(String tenXP) {
        this.tenXP = tenXP;
    }
    private void setTenTat(String tenTat) {
        this.tenTat = tenTat;
    }

    /**
     *
     * @param maXP
     * @param maQH
     * @param tenXP
     * @param tenTat
     */
    public XaPhuong (String maXP, String maQH, String tenXP, String tenTat){
        setMaXP(maXP);
        setMaQH(maQH);
        setTenXP(tenXP);
        setTenTat(tenTat);
    }    
}
