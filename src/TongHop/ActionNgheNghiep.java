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
public class ActionNgheNghiep {
    public ArrayList<NgheNghiep>getAllNgheNghiep()throws Exception{
        ArrayList<NgheNghiep> lst = new ArrayList<NgheNghiep>();
        String sql="SELECT * FROM HETHONG.NGHENGHIEP ORDER BY NGHENGHIEPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        NgheNghiep dt = null;
        while(rs.next()){
            dt = new NgheNghiep(rs.getString("NgheNghiepID"), rs.getString("TenNgheNghiep"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListNgheNghiep()throws Exception{
        String sql="SELECT * FROM HETHONG.NGHENGHIEP ORDER BY NGHENGHIEPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteNgheNghiep(String ngheNghiepID){
        String sql = "DELETE HETHONG.NGHENGHIEP WHERE NGHENGHIEPID = '" + ngheNghiepID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexNgheNghiep(ArrayList<NgheNghiep> lst, String ngheNghiepID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getNgheNghiepID().equals(ngheNghiepID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getNgheNghiepID().compareTo(ngheNghiepID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameNgheNghiep(ArrayList<NgheNghiep> lst, String ngheNghiepID){
        int i;
        i = getIndexNgheNghiep(lst, ngheNghiepID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenNgheNghiep();
    }
    
    public void saveNgheNghiep(NgheNghiep dt)throws Exception{
        String sql="CALL HETHONG.SAVENGHENGHIEP(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getNgheNghiepID());
        ps.setString(2, dt.getTenNgheNghiep());
        ps.executeUpdate();        
    }        
}
