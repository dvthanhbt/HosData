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
public class PhuongTien {
    private String phuongTienID;
    private String tenPhuongTien;

    public String getPhuongTienID() {
        return phuongTienID;
    }

    private void setPhuongTienID(String phuongTienID) {
        this.phuongTienID = phuongTienID;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    private void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }
    
    public PhuongTien(String phuongTienID, String tenPhuongTien){
        setPhuongTienID(phuongTienID);
        setTenPhuongTien(tenPhuongTien);
    }
}
