/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChuyenVien;

/**
 *
 * @author bvndc
 */
public class BenhNhan {
    private String maBN;
    private String hoTen;
    private Short namSinh;
    private Short gioiTinh;
    private String maXP;

    /**
     * @return the maBN
     */
    public String getMaBN() {
        return maBN;
    }

    /**
     * @param maBN the maBN to set
     */
    private void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    private void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the namSinh
     */
    public Short getNamSinh() {
        return namSinh;
    }

    /**
     * @param namSinh the namSinh to set
     */
    private void setNamSinh(Short namSinh) {
        this.namSinh = namSinh;
    }

    /**
     * @return the gioiTinh
     */
    public Short getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    private void setGioiTinh(Short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the maXP
     */
    public String getMaXP() {
        return maXP;
    }

    /**
     * @param maXP the maXP to set
     */
    private void setMaXP(String maXP) {
        this.maXP = maXP;
    }
    public BenhNhan (){
        setMaBN(null);
        setHoTen(null);
        setNamSinh(null);
        setGioiTinh(null);
        setMaXP(null);
    }
    
    public BenhNhan (String maBN, String hoTen, Short namSinh, Short gioiTinh, String maXP){
        setMaBN(maBN);
        setHoTen(hoTen);
        setNamSinh(namSinh);
        setGioiTinh(gioiTinh);
        setMaXP(maXP);
    }
    public void setBenhNhan (String maBN, String hoTen, Short namSinh, Short gioiTinh, String maXP){
        setMaBN(maBN);
        setHoTen(hoTen);
        setNamSinh(namSinh);
        setGioiTinh(gioiTinh);
        setMaXP(maXP);
    }
}
