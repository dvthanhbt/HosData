/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionTinhThanh {
    public ArrayList<TinhThanh>getAllTinhThanh()throws Exception{
        ArrayList<TinhThanh> lst=new ArrayList<TinhThanh>();
        String sql="SELECT * FROM HETHONG.TINHTHANH ORDER BY MATT";
        ResultSet rs= DataUtil.executeQuery(sql);
        TinhThanh tt = null;
        while(rs.next()){
            tt = new TinhThanh(rs.getString("MaTT"), rs.getString("TenTT"), rs.getString("TenTat"));
            lst.add(tt);
        }
        return lst;
    }
    public ResultSet getListTinhThanh(){
        String sql = "SELECT * FROM HETHONG.TINHTHANH ORDER BY MATT";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;        
    }
    public void deleteTinhThanh(String maTT){
        String sql = "DELETE HETHONG.TINHTHANH WHERE MATT = '" + maTT + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexTinhThanh(ArrayList<TinhThanh> lst, String maTT){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaTT().equals(maTT)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaTT().compareTo(maTT) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameTinhThanh(ArrayList<TinhThanh> lst, String maTT){
        int i;
        i = getIndexTinhThanh(lst, maTT);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenTT();
    }
    public void saveTinhThanh(TinhThanh tinhThanh) throws SQLException{
        String sql = "CALL HETHONG.SAVETINHTHANH(?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, tinhThanh.getMaTT());
        ps.setString(2, tinhThanh.getTenTT());
        ps.setString(3, tinhThanh.getTenTat());
        ps.execute();
    }    
}
