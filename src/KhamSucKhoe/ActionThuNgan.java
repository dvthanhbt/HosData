/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionThuNgan {
    public ArrayList<ThuNgan>getAllThuNgan()throws Exception{
        ArrayList<ThuNgan> lst = new ArrayList<ThuNgan>();
        String sql="SELECT * FROM KHAMSUCKHOE.THUNGAN ORDER BY THUNGANID";
        ResultSet rs= DataUtil.executeQuery(sql);
        ThuNgan ar = null;
        while(rs.next()){
            ar = new ThuNgan(rs.getString("ThuNganID"), rs.getString("HoTen"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListThuNgan()throws Exception{
        String sql="SELECT * FROM KHAMSUCKHOE.THUNGAN ORDER BY THUNGANID";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteThuNgan(String thuNganID){
        String sql = "DELETE KHAMSUCKHOE.THUNGAN WHERE THUNGANID = '" + thuNganID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexThuNgan(ArrayList<ThuNgan> lst, String thuNganID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getThuNganID().equals(thuNganID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getThuNganID().compareTo(thuNganID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameThuNgan(ArrayList<ThuNgan> lst, String thuNganID){
        int i;
        i = getIndexThuNgan(lst, thuNganID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getHoTen();
    }
    
    public void saveThuNgan(ThuNgan ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVETHUNGAN(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getThuNganID());
        ps.setString(2, ar.getHoTen());
        ps.execute();        
    }       
}
