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
public class Cap {
    private String capID;
    private String tenCap;

    public String getCapID() {
        return capID;
    }

    private void setCapID(String capID) {
        this.capID = capID;
    }

    public String getTenCap() {
        return tenCap;
    }

    private void setTenCap(String tenCap) {
        this.tenCap = tenCap;
    }
    public Cap(String capID, String tenCap){
        setCapID(capID);
        setTenCap(tenCap);
    }
}
