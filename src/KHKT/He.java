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
public class He {
    private String heID;
    private String tenHe;

    public String getHeID() {
        return heID;
    }

    private void setHeID(String heID) {
        this.heID = heID;
    }

    public String getTenHe() {
        return tenHe;
    }

    private void setTenHe(String tenHe) {
        this.tenHe = tenHe;
    }
    public He(String heID, String tenHe){
        setHeID(heID);
        setTenHe(tenHe);
    }
}
