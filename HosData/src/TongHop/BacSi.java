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
public class BacSi {
    private String maBS;
    private String hoTen;
    private int hieuLuc;

    public String getMaBS() {
        return maBS;
    }
    private void setMaBS(String maBS) {
        this.maBS = maBS;
    }

    public String getHoTen() {
        return hoTen;
    }
    private void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getHieuLuc() {
        return hieuLuc;
    }
    private void setHieuLuc(int hieuLuc) {
        this.hieuLuc = hieuLuc;
    }
    
    public BacSi(String maBS,String hoTen, int hieuLuc){
        setMaBS(maBS);
        setHoTen(hoTen);
        setHieuLuc(hieuLuc);
    }
    public BacSi(){
        setMaBS(null);
        setHoTen(null);
        setHieuLuc(0);
    }
}
