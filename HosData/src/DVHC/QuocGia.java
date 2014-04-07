/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

/**
 *
 * @author bvndc
 */
public class QuocGia {
    private String quocGiaID;
    private String tenQuocGia;
    private String english;
    private String kyHieu;

    public String getQuocGiaID() {
        return quocGiaID;
    }
    private void setQuocGiaID(String quocGiaID) {
        this.quocGiaID = quocGiaID;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }
    private void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getEnglish() {
        return english;
    }
    private void setEnglish(String english) {
        this.english = english;
    }

    public String getKyHieu() {
        return kyHieu;
    }
    private void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }
    
    public QuocGia(String quocGiaID, String tenQuocGia, String english, String kyHieu){
        setQuocGiaID(quocGiaID);
        setTenQuocGia(tenQuocGia);
        setEnglish(english);
        setKyHieu(kyHieu);
    }
}
