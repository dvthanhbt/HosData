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
public class BenhVien {
    private String benhVienID;
    private String tenBenhVien;
    private String diaChi;
    private String dienThoai;
    private int hang;
    private String maTT;

    public String getBenhVienID() {
        return benhVienID;
    }
    private void setBenhVienID(String benhVienID) {
        this.benhVienID = benhVienID;
    }

    public String getTenBenhVien() {
        return tenBenhVien;
    }
    private void setTenBenhVien(String tenBenhVien) {
        this.tenBenhVien = tenBenhVien;
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

    public int getHang() {
        return hang;
    }
    private void setHang(int hang) {
        this.hang = hang;
    }

    public String getMaTT() {
        return maTT;
    }
    private void setMaTT(String maTT) {
        this.maTT = maTT;
    }
    
    public BenhVien(String benhVienID, String tenBenhVien, String diaChi, String dienThoai, int hang, String maTT){
        setBenhVienID(benhVienID);
        setTenBenhVien(tenBenhVien);
        setDiaChi(diaChi);
        setDienThoai(dienThoai);
        setHang(hang);
        setMaTT(maTT);
    }
    public BenhVien(){
        setBenhVienID(null);
        setTenBenhVien(null);
        setDiaChi(null);
        setDienThoai(null);
        setHang(1);
        setMaTT(null);
    }
}
