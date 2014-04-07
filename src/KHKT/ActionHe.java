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
public class ActionHe {
    public ArrayList<He>getAllHe()throws Exception{
        ArrayList<He> lst = new ArrayList<He>();
        String sql="SELECT * FROM KHKT.HE ORDER BY HEID";
        ResultSet rs= DataUtil.executeQuery(sql);
        He ar = null;
        while(rs.next()){
            ar = new He(rs.getString("HeID"), rs.getString("TenHe"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListHe()throws Exception{
        String sql="SELECT * FROM KHKT.HE ORDER BY HEID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteHe(String heID){
        String sql = "DELETE KHKT.HE WHERE HEID = '" + heID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexHe(ArrayList<He> lst, String heID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getHeID().equals(heID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getHeID().compareTo(heID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameHe(ArrayList<He> lst, String heID){
        int i;
        i = getIndexHe(lst, heID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenHe();
    }
    
    public void saveHe(He ar)throws Exception{
        String sql="CALL KHKT.SAVEHE(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getHeID());
        ps.setString(2, ar.getTenHe());
        ps.executeUpdate();        
    }      
}
