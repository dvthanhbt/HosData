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
public class ActionGiuongBenh {
    public ArrayList<GiuongBenh>getAllGiuongBenh(String buongID)throws Exception{
        ArrayList<GiuongBenh> lst = new ArrayList<GiuongBenh>();
        String sql="SELECT * FROM HETHONG.GIUONGBENH WHERE BUONGID = '" + buongID + "' ORDER BY GIUONGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        GiuongBenh kp = null;
        while(rs.next()){
            kp = new GiuongBenh(rs.getString("GiuongID"), rs.getString("BuongID"), rs.getString("MaKP"), rs.getString("TenGiuong"), rs.getString("MaSPSD"), rs.getString("NhapKhoaID"), rs.getInt("HieuLuc"));
            lst.add(kp);
        }
        return lst;
    }    

    public ResultSet getGiuongBenh(String buongID){
        String sql = "SELECT * FROM HETHONG.GIUONGBENH WHERE BUONGID = '" + buongID + "' ORDER BY GIUONGID";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteGiuongBenh(String giuongID){
        String sql = "DELETE HETHONG.GIUONGBENH WHERE GIUONGID = '" + giuongID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexGiuongBenh(ArrayList<GiuongBenh> lst, String giuongID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getGiuongID().equals(giuongID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getGiuongID().compareTo(giuongID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameGiuongBenh(ArrayList<GiuongBenh> lst, String giuongID){
        int i;
        i = getIndexGiuongBenh(lst, giuongID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenGiuong();
    }
    
    public void saveGiuongBenh(GiuongBenh kp)throws Exception{
        String sql="CALL HETHONG.SAVEGIUONGBENH(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, kp.getGiuongID());
        ps.setString(2, kp.getBuongID());
        ps.setString(3, kp.getMaKP());
        ps.setString(4, kp.getTenGiuong());
        ps.setString(5, kp.getMaSPSD());
        ps.setString(6, kp.getNhapKhoaID());
        ps.setInt(7, kp.getHieuLuc());
        ps.execute();        
    }        
}
