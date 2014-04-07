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
public class ActionLoaiNV {
    public ArrayList<LoaiNV>getAllLoaiNV()throws Exception{
        ArrayList<LoaiNV> lst = new ArrayList<LoaiNV>();
        String sql="SELECT * FROM KHKT.LOAINV ORDER BY LOAINVID";
        ResultSet rs= DataUtil.executeQuery(sql);
        LoaiNV ar = null;
        while(rs.next()){
            ar = new LoaiNV(rs.getString("LoaiNVID"), rs.getString("TenLoaiNV"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListLoaiNV()throws Exception{
        String sql="SELECT * FROM KHKT.LOAINV ORDER BY LOAINVID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteLoaiNV(String loaiNVID){
        String sql = "DELETE KHKT.LOAINV WHERE LOAINVID = '" + loaiNVID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexLoaiNV(ArrayList<LoaiNV> lst, String loaiNVID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLoaiNVID().equals(loaiNVID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLoaiNVID().compareTo(loaiNVID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameLoaiNV(ArrayList<LoaiNV> lst, String loaiNVID){
        int i;
        i = getIndexLoaiNV(lst, loaiNVID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenLoaiNV();
    }
    
    public void saveLoaiNV(LoaiNV ar)throws Exception{
        String sql="CALL KHKT.SAVELOAINV(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getLoaiNVID());
        ps.setString(2, ar.getTenLoaiNV());
        ps.executeUpdate();        
    }      
}
