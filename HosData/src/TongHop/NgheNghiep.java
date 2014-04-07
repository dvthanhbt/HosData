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
public class NgheNghiep {
    private String ngheNghiepID;
    private String tenNgheNghiep;

    public String getNgheNghiepID() {
        return ngheNghiepID;
    }

    private void setNgheNghiepID(String ngheNghiepID) {
        this.ngheNghiepID = ngheNghiepID;
    }

    public String getTenNgheNghiep() {
        return tenNgheNghiep;
    }

    private void setTenNgheNghiep(String tenNgheNghiep) {
        this.tenNgheNghiep = tenNgheNghiep;
    }
    
    public NgheNghiep(String ngheNghiepID, String tenNgheNghiep){
        setNgheNghiepID(ngheNghiepID);
        setTenNgheNghiep(tenNgheNghiep);
    }
}
