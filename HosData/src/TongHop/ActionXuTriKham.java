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
public class ActionXuTriKham {
    public ArrayList<XuTriKham>getAllXuTriKham()throws Exception{
        ArrayList<XuTriKham> lst = new ArrayList<XuTriKham>();
        String sql="SELECT * FROM HETHONG.XUTRIKHAM ORDER BY XUTRIID";
        ResultSet rs= DataUtil.executeQuery(sql);
        XuTriKham dt = null;
        while(rs.next()){
            dt = new XuTriKham(rs.getString("XuTriID"), rs.getString("TenXuTri"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListXuTriKham()throws Exception{
        String sql="SELECT * FROM HETHONG.XUTRIKHAM ORDER BY XUTRIID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteXuTriKham(String xuTriID){
        String sql = "DELETE HETHONG.XUTRIKHAM WHERE XUTRIID = '" + xuTriID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexXuTriKham(ArrayList<XuTriKham> lst, String xuTriID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getXuTriID().equals(xuTriID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getXuTriID().compareTo(xuTriID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameXuTriKham(ArrayList<XuTriKham> lst, String xuTriID){
        int i;
        i = getIndexXuTriKham(lst, xuTriID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenXuTri();
    }
    
    public void saveXuTriKham(XuTriKham dt)throws Exception{
        String sql="CALL HETHONG.SAVEXUTRIKHAM(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getXuTriID());
        ps.setString(2, dt.getTenXuTri());
        ps.executeUpdate();        
    }        
}
