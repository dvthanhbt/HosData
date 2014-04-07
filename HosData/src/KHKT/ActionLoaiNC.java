/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionLoaiNC {
    public ArrayList<LoaiNC>getAllLoaiNC()throws Exception{
        ArrayList<LoaiNC> lst = new ArrayList<LoaiNC>();
        String sql="SELECT * FROM KHKT.LOAINC ORDER BY LOAINCID";
        ResultSet rs= DataUtil.executeQuery(sql);
        LoaiNC ar = null;
        while(rs.next()){
            ar = new LoaiNC(rs.getString("LoaiNCID"), rs.getString("TenLoaiNC"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListLoaiNC()throws Exception{
        String sql="SELECT * FROM KHKT.LOAINC ORDER BY LOAINCID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getThongKeLoai(int nam, int duocCN)throws Exception{
        String sql="CALL KHKT.TKLOAINCKH (?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, nam);
        ps.setInt(2, duocCN);
        ResultSet rs;
        rs = ps.executeQuery();
        return rs;
    }    
    
    public void deleteLoaiNC(String loaiNCID){
        String sql = "DELETE KHKT.LOAINC WHERE LOAINCID = '" + loaiNCID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexLoaiNC(ArrayList<LoaiNC> lst, String loaiNCID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLoaiNCID().equals(loaiNCID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLoaiNCID().compareTo(loaiNCID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameLoaiNC(ArrayList<LoaiNC> lst, String loaiNCID){
        int i;
        i = getIndexLoaiNC(lst, loaiNCID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenLoaiNC();
    }
    
    public void saveLoaiNC(LoaiNC ar)throws Exception{
        String sql="CALL KHKT.SAVELOAINC(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getLoaiNCID());
        ps.setString(2, ar.getTenLoaiNC());
        ps.executeUpdate();        
    }      
}
