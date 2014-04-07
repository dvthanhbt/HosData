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
public class CoQuan {
    private String coQuanID;
    private String tenCoQuan;
    private String diaChi;
    private String dienThoai;

    public String getCoQuanID() {
        return coQuanID;
    }

    private void setCoQuanID(String coQuanID) {
        this.coQuanID = coQuanID;
    }

    public String getTenCoQuan() {
        return tenCoQuan;
    }

    private void setTenCoQuan(String tenCoQuan) {
        this.tenCoQuan = tenCoQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    private void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    private void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public CoQuan(String coQuanID, String tenCoQuan, String diaChi, String dienThoai){
        setCoQuanID(coQuanID);
        setTenCoQuan(tenCoQuan);
        setDiaChi(diaChi);
        setDienThoai(dienThoai);
    }
}
