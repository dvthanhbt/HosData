/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ICD;

/**
 *
 * @author bvndc
 */
public class ICDBenh {
    private String icdBenhID;
    private int icdNhomID;
    private String tenBenh;
    private String english;
    private String stt;

    public String getIcdBenhID() {
        return icdBenhID;
    }
    private void setIcdBenhID(String icdBenhID) {
        this.icdBenhID = icdBenhID;
    }

    public int getIcdNhomID() {
        return icdNhomID;
    }
    private void setIcdNhomID(int icdNhomID) {
        this.icdNhomID = icdNhomID;
    }

    public String getTenBenh() {
        return tenBenh;
    }
    private void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public String getEnglish() {
        return english;
    }
    private void setEnglish(String english) {
        this.english = english;
    }

    public String getStt() {
        return stt;
    }
    private void setStt(String stt) {
        this.stt = stt;
    }
    
    public ICDBenh(String icdBenhID, int icdNhomID, String tenBenh, String english, String stt){
        setIcdBenhID(icdBenhID);
        setIcdNhomID(icdNhomID);
        setTenBenh(tenBenh);
        setEnglish(english);
        setStt(stt);
    }
    public ICDBenh(){
        setIcdBenhID(null);
        setIcdNhomID(0);
        setTenBenh(null);
        setEnglish(null);
        setStt(null);
    }
}
