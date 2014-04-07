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
import java.util.*;

public class ChuyenDi {

    private String chuyenVienID;
    private String maBN;
    private Date ngayChuyen;
    private String maKP;
    private String maBS;
    private String doiTuongID;
    private String soBHYT;
    private Short traiTuyen;
    private String icdBenhID;
    private String benhVienID;
    private String phuongTienID;
    private String lyDoID;
    private Short daChuyen;
    private Short noiTru;
    private Date tuNgay;
    private Date denNgay;

    public String getChuyenVienID() {
        return chuyenVienID;
    }

    private void setChuyenVienID(String chuyenDiID) {
        this.chuyenVienID = chuyenDiID;
    }

    public String getMaBN() {
        return maBN;
    }

    private void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public Date getNgayChuyen() {
        return ngayChuyen;
    }

    private void setNgayChuyen(Date ngayChuyen) {
        this.ngayChuyen = ngayChuyen;
    }

    public String getMaKP() {
        return maKP;
    }

    private void setMaKP(String maKP) {
        this.maKP = maKP;
    }

    public String getMaBS() {
        return maBS;
    }

    private void setMaBS(String maBS) {
        this.maBS = maBS;
    }

    public String getDoiTuongID() {
        return doiTuongID;
    }

    private void setDoiTuongID(String doiTuongID) {
        this.doiTuongID = doiTuongID;
    }

    public String getSoBHYT() {
        return soBHYT;
    }

    private void setSoBHYT(String soBHYT) {
        this.soBHYT = soBHYT;
    }

    public Short getTraiTuyen() {
        return traiTuyen;
    }

    private void setTraiTuyen(Short traiTuyen) {
        this.traiTuyen = traiTuyen;
    }

    public String getIcdBenhID() {
        return icdBenhID;
    }

    private void setIcdBenhID(String icdBenhID) {
        this.icdBenhID = icdBenhID;
    }

    public String getBenhVienID() {
        return benhVienID;
    }

    private void setBenhVienID(String benhVienID) {
        this.benhVienID = benhVienID;
    }

    public String getPhuongTienID() {
        return phuongTienID;
    }

    private void setPhuongTienID(String phuongTienID) {
        this.phuongTienID = phuongTienID;
    }

    public String getLyDoID() {
        return lyDoID;
    }

    private void setLyDoID(String lyDoID) {
        this.lyDoID = lyDoID;
    }

    public Short getDaChuyen() {
        return daChuyen;
    }

    private void setDaChuyen(Short daChuyen) {
        this.daChuyen = daChuyen;
    }

    public Short getNoiTru() {
        return noiTru;
    }

    private void setNoiTru(Short noiTru) {
        this.noiTru = noiTru;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    private void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    private void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }
    public ChuyenDi(){
        setChuyenVienID(null);
        setMaBN(null);
        setNgayChuyen(null);
        setMaKP(null);
        setMaBS(null);
        setDoiTuongID(null);
        setSoBHYT(null);
        setTraiTuyen(null);
        setIcdBenhID(null);
        setBenhVienID(null);
        setPhuongTienID(null);
        setLyDoID(null);
        setDaChuyen(null);
        setNoiTru(null);
        setTuNgay(null);
        setDenNgay(null);  
    }
    public ChuyenDi(
            String chuyenDiID,
            String maBN,
            Date ngayChuyen,
            String maKP,
            String maBS,
            String doiTuongID,
            String soBHYT,
            Short traiTuyen,
            String icdBenhID,
            String benhVienID,
            String phuongTienID,
            String lyDoID,
            Short daChuyen,
            Short noiTru,
            Date tuNgay,
            Date denNgay) {
        setChuyenVienID(chuyenDiID);
        setMaBN(maBN);
        setNgayChuyen(ngayChuyen);
        setMaKP(maKP);
        setMaBS(maBS);
        setDoiTuongID(doiTuongID);
        setSoBHYT(soBHYT);
        setTraiTuyen(traiTuyen);
        setIcdBenhID(icdBenhID);
        setBenhVienID(benhVienID);
        setPhuongTienID(phuongTienID);
        setLyDoID(lyDoID);
        setDaChuyen(daChuyen);
        setNoiTru(noiTru);
        setTuNgay(tuNgay);
        setDenNgay(denNgay);
    }
    public void setChuyenDi(
            String chuyenDiID,
            String maBN,
            Date ngayChuyen,
            String maKP,
            String maBS,
            String doiTuongID,
            String soBHYT,
            Short traiTuyen,
            String icdBenhID,
            String benhVienID,
            String phuongTienID,
            String lyDoID,
            Short daChuyen,
            Short noiTru,
            Date tuNgay,
            Date denNgay) {
        setChuyenVienID(chuyenDiID);
        setMaBN(maBN);
        setNgayChuyen(ngayChuyen);
        setMaKP(maKP);
        setMaBS(maBS);
        setDoiTuongID(doiTuongID);
        setSoBHYT(soBHYT);
        setTraiTuyen(traiTuyen);
        setIcdBenhID(icdBenhID);
        setBenhVienID(benhVienID);
        setPhuongTienID(phuongTienID);
        setLyDoID(lyDoID);
        setDaChuyen(daChuyen);
        setNoiTru(noiTru);
        setTuNgay(tuNgay);
        setDenNgay(denNgay);
    }

}
