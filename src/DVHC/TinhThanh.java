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
public class TinhThanh {
    private String maTT;
    private String tenTT;
    private String tenTat;
    public String getMaTT(){
        return this.maTT;
    }
    public String getTenTT(){
        return this.tenTT;
    }
    public String getTenTat(){
        return this.tenTat;
    }
    private void setMaTT(String maTT){
        this.maTT = maTT;
    }
    private void setTenTT(String tenTT){
        this.tenTT = tenTT;
    }
    private void setTenTat(String tenTat){
        this.tenTat = tenTat;
    }
    public TinhThanh(String maTT, String tenTT, String tenTat){
        setMaTT(maTT);
        setTenTT(tenTT);
        setTenTat(tenTat);
    }
}
