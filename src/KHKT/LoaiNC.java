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
public class LoaiNC {
    private String loaiNCID;
    private String tenLoaiNC;

    public String getLoaiNCID() {
        return loaiNCID;
    }

    private void setLoaiNCID(String loaiNCID) {
        this.loaiNCID = loaiNCID;
    }

    public String getTenLoaiNC() {
        return tenLoaiNC;
    }

    private void setTenLoaiNC(String tenLoaiNC) {
        this.tenLoaiNC = tenLoaiNC;
    }
    
    public LoaiNC(String loaiNCID, String tenLoaiNC){
        setLoaiNCID(loaiNCID);
        setTenLoaiNC(tenLoaiNC);
                
    }
}
