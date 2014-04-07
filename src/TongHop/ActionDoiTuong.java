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
public class ActionDoiTuong {
    public ArrayList<DoiTuong>getAllDoiTuong()throws Exception{
        ArrayList<DoiTuong> lst = new ArrayList<DoiTuong>();
        String sql="SELECT * FROM HETHONG.DOITUONG ORDER BY DOITUONGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        DoiTuong dt = null;
        while(rs.next()){
            dt = new DoiTuong(rs.getString("DoiTuongID"), rs.getString("TenDoiTuong"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListDoiTuong()throws Exception{
        String sql="SELECT * FROM HETHONG.DOITUONG ORDER BY DOITUONGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteDoiTuong(String doiTuongID){
        String sql = "DELETE HETHONG.DOITUONG WHERE DOITUONGID = '" + doiTuongID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexDoiTuong(ArrayList<DoiTuong> lst, String doiTuongID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getDoiTuongID().equals(doiTuongID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getDoiTuongID().compareTo(doiTuongID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameDoiTuong(ArrayList<DoiTuong> lst, String doiTuongID){
        int i;
        i = getIndexDoiTuong(lst, doiTuongID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenDoiTuong();
    }
    
    public void saveDoiTuong(DoiTuong dt)throws Exception{
        String sql="CALL HETHONG.SAVEDOITUONG(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getDoiTuongID());
        ps.setString(2, dt.getTenDoiTuong());
        ps.executeUpdate();        
    }    
}
