/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

/**
 *
 * @author bvndc
 */
public class LyDo {
    private String lyDoID;
    private String tenLyDo;
    private String giaVPID;

    public String getLyDoID() {
        return lyDoID;
    }

    private void setLyDoID(String lyDoID) {
        this.lyDoID = lyDoID;
    }

    public String getTenLyDo() {
        return tenLyDo;
    }

    private void setTenLyDo(String tenLyDo) {
        this.tenLyDo = tenLyDo;
    }

    public String getGiaVPID() {
        return giaVPID;
    }

    private void setGiaVPID(String giaVPID) {
        this.giaVPID = giaVPID;
    }
    
    public LyDo(String lyDoID, String tenLyDo, String giaVPID){
        setLyDoID(lyDoID);
        setTenLyDo(tenLyDo);
        setGiaVPID(giaVPID);
    }
}
