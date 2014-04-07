/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TongHop;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionPhuongTien {
    public ArrayList<PhuongTien>getAllPhuongTien()throws Exception{
        ArrayList<PhuongTien> lst = new ArrayList<PhuongTien>();
        String sql="SELECT * FROM HETHONG.PHUONGTIEN ORDER BY PHUONGTIENID";
        ResultSet rs= DataUtil.executeQuery(sql);
        PhuongTien pt = null;
        while(rs.next()){
            pt = new PhuongTien(rs.getString("PhuongTienID"), rs.getString("TenPhuongTien"));
            lst.add(pt);
        }
        return lst;
    }    
    public ResultSet getListPhuongTien()throws Exception{
        String sql="SELECT * FROM HETHONG.PHUONGTIEN ORDER BY PHUONGTIENID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deletePhuongTien(String phuongTienID){
        String sql = "DELETE HETHONG.PHUONGTIEN WHERE PHUONGTIENID = '" + phuongTienID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexPhuongTien(ArrayList<PhuongTien> lst, String phuongTienID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getPhuongTienID().equals(phuongTienID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getPhuongTienID().compareTo(phuongTienID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNamePhuongTien(ArrayList<PhuongTien> lst, String phuongTienID){
        int i;
        i = getIndexPhuongTien(lst, phuongTienID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenPhuongTien();
    }
    
    public void savePhuongTien(PhuongTien pt)throws Exception{
        String sql="CALL HETHONG.SAVEPHUONGTIEN(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, pt.getPhuongTienID());
        ps.setString(2, pt.getTenPhuongTien());
        ps.executeUpdate();        
    }            
}
