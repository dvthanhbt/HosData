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
public class ActionCap {
    public ArrayList<Cap>getAllCap()throws Exception{
        ArrayList<Cap> lst = new ArrayList<Cap>();
        String sql="SELECT * FROM KHKT.CAP ORDER BY CAPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        Cap ar = null;
        while(rs.next()){
            ar = new Cap(rs.getString("CapID"), rs.getString("TenCap"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListCap()throws Exception{
        String sql="SELECT * FROM KHKT.CAP ORDER BY CAPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getThongKeCap(int nam, int duocCN)throws Exception{
        String sql="CALL KHKT.TKCAPNCKH (?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, nam);
        ps.setInt(2, duocCN);
        ResultSet rs;
        rs = ps.executeQuery();
        return rs;
    }    
    
    public void deleteCap(String capID){
        String sql = "DELETE KHKT.CAP WHERE CAPID = '" + capID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexCap(ArrayList<Cap> lst, String capID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getCapID().equals(capID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getCapID().compareTo(capID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameCap(ArrayList<Cap> lst, String capID){
        int i;
        i = getIndexCap(lst, capID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenCap();
    }
    
    public void saveCap(Cap ar)throws Exception{
        String sql="CALL KHKT.SAVECAP(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getCapID());
        ps.setString(2, ar.getTenCap());
        ps.executeUpdate();        
    }        
}
