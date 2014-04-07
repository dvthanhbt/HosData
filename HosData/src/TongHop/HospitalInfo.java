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
public class HospitalInfo {
    private String hospitalInfo;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhone;
    private String hospitalFax;
    private String hospitalMail;
    private String hospitalWebSite;
    private String hospitalTaxCode;
    private String hospitalParent;
    private String hospitalProvince;

    public String getHospitalInfo() {
        return hospitalInfo;
    }

    private void setHospitalInfo(String hospitalInfo) {
        this.hospitalInfo = hospitalInfo;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    private void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    private void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    private void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    public String getHospitalFax() {
        return hospitalFax;
    }

    private void setHospitalFax(String hospitalFax) {
        this.hospitalFax = hospitalFax;
    }

    public String getHospitalMail() {
        return hospitalMail;
    }

    private void setHospitalMail(String hospitalMail) {
        this.hospitalMail = hospitalMail;
    }

    public String getHospitalWebSite() {
        return hospitalWebSite;
    }

    private void setHospitalWebSite(String hospitalWebSite) {
        this.hospitalWebSite = hospitalWebSite;
    }

    public String getHospitalTaxCode() {
        return hospitalTaxCode;
    }

    private void setHospitalTaxCode(String hospitalTaxCode) {
        this.hospitalTaxCode = hospitalTaxCode;
    }

    public String getHospitalParent() {
        return hospitalParent;
    }

    private void setHospitalParent(String hospitalParent) {
        this.hospitalParent = hospitalParent;
    }

    public String getHospitalProvince() {
        return hospitalProvince;
    }

    private void setHospitalProvince(String hospitalProvince) {
        this.hospitalProvince = hospitalProvince;
    }
    
    public HospitalInfo(String hospitalInfo,
                        String hospitalName,
                        String hospitalAddress,
                        String hospitalPhone,
                        String hospitalFax,
                        String hospitalMail,
                        String hospitalWebSite,
                        String hospitalTaxCode,
                        String hospitalParent,
                        String hospitalProvince){
        setHospitalInfo(hospitalInfo);
        setHospitalName(hospitalName);
        setHospitalAddress(hospitalAddress);
        setHospitalPhone(hospitalPhone);
        setHospitalFax(hospitalFax);
        setHospitalMail(hospitalMail);
        setHospitalWebSite(hospitalWebSite);
        setHospitalTaxCode(hospitalTaxCode);
        setHospitalParent(hospitalParent);
        setHospitalProvince(hospitalProvince);
    }
}
