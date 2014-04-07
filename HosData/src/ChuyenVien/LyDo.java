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
public class LyDo {
    private String lyDoID;
    private String tenLyDo;
    public String getLyDoID(){
        return this.lyDoID;
    }
    public String getTenLyDo(){
        return this.tenLyDo;
    }
    
    private void setLyDoID(String lyDoID){
        this.lyDoID = lyDoID;
    }
    private void setTenLyDo(String tenLyDo){
        this.tenLyDo = tenLyDo;
    }
    
    /**
     *
     * @param lyDoID
     * @param tenLyDo
     */
    public LyDo(String lyDoID, String tenLyDo){
        setLyDoID(lyDoID);
        setTenLyDo(tenLyDo);
    }
}
