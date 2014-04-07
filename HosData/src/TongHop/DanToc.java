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
public class DanToc {
    private String danTocID;
    private String tenDanToc;

    public String getDanTocID() {
        return danTocID;
    }

    private void setDanTocID(String danTocID) {
        this.danTocID = danTocID;
    }

    public String getTenDanToc() {
        return tenDanToc;
    }

    private void setTenDanToc(String tenDanToc) {
        this.tenDanToc = tenDanToc;
    }
    
    public DanToc(String danTocID, String tenDanToc){
        setDanTocID(danTocID);
        setTenDanToc(tenDanToc);
    }
}
