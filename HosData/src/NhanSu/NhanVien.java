/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NhanSu;

import java.util.Date;

/**
 *
 * @author bvndc
 */
public class NhanVien {
    public String maNV;
    public String hoTen;
    public Date ngaySinh;
    public int gioiTinh;
    public String queQuan;
    public String thuongTru;
    public String nhomMau;
    public String dienThoai;
    public String maKP;
    public int hieuLuc;

    public String getMaNV() {
        return maNV;
    }
    private void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }
    private void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
    private void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }
    private void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }
    private void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getThuongTru() {
        return thuongTru;
    }
    private void setThuongTru(String thuongTru) {
        this.thuongTru = thuongTru;
    }

    public String getNhomMau() {
        return nhomMau;
    }
    private void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public String getDienThoai() {
        return dienThoai;
    }
    private void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getMaKP() {
        return maKP;
    }
    private void setMaKP(String maKP) {
        this.maKP = maKP;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public NhanVien (String maNV, String hoTen, Date ngaySinh, int gioiTinh, String queQuan, String thuongTru, String nhomMau, String dienThoai, String maKP, int hieuLuc){
        setMaNV(maNV);
        setHoTen(hoTen);
        setNgaySinh(ngaySinh);
        setGioiTinh(gioiTinh);
        setQueQuan(queQuan);
        setThuongTru(thuongTru);
        setNhomMau(nhomMau);
        setDienThoai(dienThoai);
        setMaKP(maKP);
        setHieuLuc(hieuLuc);
    }
}
