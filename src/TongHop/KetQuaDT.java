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
public class KetQuaDT {
    private String ketQuaID;
    private String tenKetQua;

    public String getKetQuaID() {
        return ketQuaID;
    }

    private void setKetQuaID(String ketQuaID) {
        this.ketQuaID = ketQuaID;
    }

    public String getTenKetQua() {
        return tenKetQua;
    }

    private void setTenKetQua(String tenKetQua) {
        this.tenKetQua = tenKetQua;
    }
    
    public KetQuaDT(String ketQuaID, String tenKetQua){
        setKetQuaID(ketQuaID);
        setTenKetQua(tenKetQua);
    }
}
