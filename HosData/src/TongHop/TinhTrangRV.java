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
public class TinhTrangRV {
    private String tinhTrangID;
    private String tenTinhTrang;

    public String getTinhTrangID() {
        return tinhTrangID;
    }

    private void setTinhTrangID(String tinhTrangID) {
        this.tinhTrangID = tinhTrangID;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    private void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }
    
    public TinhTrangRV(String tinhTrangID, String tenTinhTrang){
        setTinhTrangID(tinhTrangID);
        setTenTinhTrang(tenTinhTrang);
    }
}
