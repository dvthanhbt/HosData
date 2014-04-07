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
public class NguyenNhanNV {
    private String nguyenNhanID;
    private String tenNguyenNhan;

    public String getNguyenNhanID() {
        return nguyenNhanID;
    }

    private void setNguyenNhanID(String nguyenNhanID) {
        this.nguyenNhanID = nguyenNhanID;
    }

    public String getTenNguyenNhan() {
        return tenNguyenNhan;
    }

    private void setTenNguyenNhan(String tenNguyenNhan) {
        this.tenNguyenNhan = tenNguyenNhan;
    }
    
    public NguyenNhanNV(String nguyenNhanID, String tenNguyenNhan){
        setNguyenNhanID(nguyenNhanID);
        setTenNguyenNhan(tenNguyenNhan);
    }
}
