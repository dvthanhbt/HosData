/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BHYT;

/**
 *
 * @author bvndc
 */
public class BH_DoiTuong {
    private String maDT;
    private String tenDoiTuong;
    private int nhom;

    public String getMaDT() {
        return maDT;
    }

    private void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDoiTuong() {
        return tenDoiTuong;
    }

    private void setTenDoiTuong(String tenDoiTuong) {
        this.tenDoiTuong = tenDoiTuong;
    }

    public int getNhom() {
        return nhom;
    }

    private void setNhom(int nhom) {
        this.nhom = nhom;
    }
    
    public BH_DoiTuong(String maDT, String tenDoiTuong, int nhom){
        setMaDT(maDT);
        setTenDoiTuong(tenDoiTuong);
        setNhom(nhom);
    }
}
