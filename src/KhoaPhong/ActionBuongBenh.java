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
public class ActionBuongBenh {
    public ArrayList<BuongBenh>getAllBuongBenh(String maKP)throws Exception{
        ArrayList<BuongBenh> lst = new ArrayList<BuongBenh>();
        String sql="SELECT * FROM HETHONG.BUONGBENH WHERE MAKP = '" + maKP + "' ORDER BY BUONGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        BuongBenh kp = null;
        while(rs.next()){
            kp = new BuongBenh(rs.getString("BuongID"), rs.getString("MaKP"), rs.getString("TenBuong"), rs.getInt("HieuLuc"));
            lst.add(kp);
        }
        return lst;
    }    

    public ResultSet getBuongBenh(String maKP){
        String sql = "SELECT * FROM HETHONG.BUONGBENH WHERE MAKP = '" + maKP + "' ORDER BY BUONGID";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteBuongBenh(String buongID){
        String sql = "DELETE HETHONG.BUONGBENH WHERE BUONGID = '" + buongID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexBuongBenh(ArrayList<BuongBenh> lst, String buongID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaKP().equals(buongID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaKP().compareTo(buongID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameBuongBenh(ArrayList<BuongBenh> lst, String buongID){
        int i;
        i = getIndexBuongBenh(lst, buongID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenBuong();
    }
    
    public void saveBuongBenh(BuongBenh kp)throws Exception{
        String sql="CALL HETHONG.SAVEBUONGBENH(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, kp.getBuongID());
        ps.setString(2, kp.getMaKP());
        ps.setString(3, kp.getTenBuong());
        ps.setInt(4, kp.getHieuLuc());
        ps.execute();        
    }    
}
