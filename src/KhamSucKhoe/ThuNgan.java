/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

/**
 *
 * @author bvndc
 */
public class ThuNgan {
    private String thuNganID;
    private String hoTen;

    public String getThuNganID() {
        return thuNganID;
    }

    private void setThuNganID(String thuNganID) {
        this.thuNganID = thuNganID;
    }

    public String getHoTen() {
        return hoTen;
    }

    private void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public ThuNgan(String thuNganID, String hoTen){
        setThuNganID(thuNganID);
        setHoTen(hoTen);
    }
}
