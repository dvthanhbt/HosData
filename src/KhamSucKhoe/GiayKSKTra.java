/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import java.sql.Date;

/**
 *
 * @author bvndc
 */
public class GiayKSKTra {
    private String soKSK;
    private Date ngay;
    private String lyDo;
    private String ketQua;

    public String getSoKSK() {
        return soKSK;
    }

    private void setSoKSK(String soKSK) {
        this.soKSK = soKSK;
    }

    public Date getNgay() {
        return ngay;
    }

    private void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getLyDo() {
        return lyDo;
    }

    private void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getKetQua() {
        return ketQua;
    }

    private void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    
    public GiayKSKTra(String soKSK, Date ngay, String lyDo, String ketQua){
        setSoKSK(soKSK);
        setNgay(ngay);
        setLyDo(lyDo);
        setKetQua(ketQua);
    }
}
