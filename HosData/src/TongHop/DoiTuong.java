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
public class DoiTuong {
    private String doiTuongID;
    private String tenDoiTuong;

    public String getDoiTuongID() {
        return doiTuongID;
    }

    private void setDoiTuongID(String doiTuongID) {
        this.doiTuongID = doiTuongID;
    }

    public String getTenDoiTuong() {
        return tenDoiTuong;
    }

    private void setTenDoiTuong(String tenDoiTuong) {
        this.tenDoiTuong = tenDoiTuong;
    }
    
    public DoiTuong(String doiTuongID, String tenDoiTuong){
        setDoiTuongID(doiTuongID);
        setTenDoiTuong(tenDoiTuong);
    }
    public DoiTuong(){
        setDoiTuongID(null);
        setTenDoiTuong(null);
    }
}
