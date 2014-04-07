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
public class BH_MucHuong {
    private String loai;
    private int mucHuongCP;
    private int mucHuongVC;

    public String getLoai() {
        return loai;
    }

    private void setLoai(String loai) {
        this.loai = loai;
    }

    public int getMucHuongCP() {
        return mucHuongCP;
    }

    private void setMucHuongCP(int mucHuongCP) {
        this.mucHuongCP = mucHuongCP;
    }

    public int getMucHuongVC() {
        return mucHuongVC;
    }

    private void setMucHuongVC(int mucHuongVC) {
        this.mucHuongVC = mucHuongVC;
    }
    
    public BH_MucHuong(String loai, int mucHuongCP, int mucHuongVC){
        setLoai(loai);
        setMucHuongCP(mucHuongCP);
        setMucHuongVC(mucHuongVC);
    }
}
