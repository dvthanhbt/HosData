/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TongHop;

/**
 *
 * @author bvndc
 */
public class XuTriKham {
    private String xuTriID;
    private String tenXuTri;

    public String getXuTriID() {
        return xuTriID;
    }

    private void setXuTriID(String xuTriID) {
        this.xuTriID = xuTriID;
    }

    public String getTenXuTri() {
        return tenXuTri;
    }

    private void setTenXuTri(String tenXuTri) {
        this.tenXuTri = tenXuTri;
    }
    
    public XuTriKham(String xuTriID, String tenXuTri){
        setXuTriID(xuTriID);
        setTenXuTri(tenXuTri);
    }
}
