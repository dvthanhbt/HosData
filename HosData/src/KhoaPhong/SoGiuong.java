/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhoaPhong;

/**
 *
 * @author bvndc
 */
public class SoGiuong {
    private String maKP;
    private int nam;
    private int soGiuongKH;
    private int soGiuongTK;
    private int hieuLuc;

    public String getMaKP() {
        return maKP;
    }
    private void setMaKP(String maKP) {
        this.maKP = maKP;
    }

    public int getNam() {
        return nam;
    }
    private void setNam(int nam) {
        this.nam = nam;
    }

    public int getSoGiuongKH() {
        return soGiuongKH;
    }
    private void setSoGiuongKH(int soGiuongKH) {
        this.soGiuongKH = soGiuongKH;
    }

    public int getSoGiuongTK() {
        return soGiuongTK;
    }
    private void setSoGiuongTK(int soGiuongTK) {
        this.soGiuongTK = soGiuongTK;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public SoGiuong(String maKP, int nam, int soGiuongKH, int soGiuongTK, int hieuLuc){
        setMaKP(maKP);
        setNam(nam);
        setSoGiuongKH(soGiuongKH);
        setSoGiuongTK(soGiuongTK);
        setHieuLuc(hieuLuc);
    }
    public SoGiuong(){
        setMaKP(null);
        setNam(0);
        setSoGiuongKH(0);
        setSoGiuongTK(0);
        setHieuLuc(0);
    }
}
