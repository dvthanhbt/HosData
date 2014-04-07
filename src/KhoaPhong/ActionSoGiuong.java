/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhoaPhong;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionSoGiuong {
    public ArrayList<SoGiuong>getAllSoGiuong(int nam)throws Exception{
        ArrayList<SoGiuong> lst = new ArrayList<SoGiuong>();
        String sql="SELECT * FROM HETHONG.SOGIUONG WHERE NAM = " + nam + " ORDER BY MAKP";
        ResultSet rs= DataUtil.executeQuery(sql);
        SoGiuong kp = null;
        while(rs.next()){
            kp = new SoGiuong(rs.getString("MaKP"), rs.getInt("Nam"), rs.getInt("SoGiuongKH"), rs.getInt("SoGiuongTK"), rs.getInt("HieuLuc"));
            lst.add(kp);
        }
        return lst;
    }    
    public ResultSet getSoGiuong(int nam){
        String sql = "SELECT * FROM HETHONG.SOGIUONG WHERE NAM = " + nam + " ORDER BY MAKP";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteSoGiuong(int nam, String maKP){
        String sql = "DELETE HETHONG.SOGIUONG WHERE MAKP = '" + maKP + "' AND NAM = " + nam;
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public void deleteSoGiuong(int nam){
        String sql = "DELETE HETHONG.SOGIUONG WHERE NAM = " + nam;
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }    
    
    public void saveSoGiuong(SoGiuong sg)throws Exception{
        String sql="CALL HETHONG.SAVESOGIUONG(?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, sg.getMaKP());
        ps.setInt(2, sg.getNam());
        ps.setInt(3, sg.getSoGiuongKH());
        ps.setInt(4, sg.getSoGiuongTK());
        ps.setInt(5, sg.getHieuLuc());
        ps.execute();        
    }        
}
