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
public class ActionTinhTrangRV {
    public ArrayList<TinhTrangRV>getAllTinhTrangRV()throws Exception{
        ArrayList<TinhTrangRV> lst = new ArrayList<TinhTrangRV>();
        String sql="SELECT * FROM HETHONG.TINHTRANGRV ORDER BY TINHTRANGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        TinhTrangRV dt = null;
        while(rs.next()){
            dt = new TinhTrangRV(rs.getString("TinhTrangID"), rs.getString("TenTinhTrang"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListTinhTrangRV()throws Exception{
        String sql="SELECT * FROM HETHONG.TINHTRANGRV ORDER BY TINHTRANGID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteTinhTrangRV(String tinhTrangID){
        String sql = "DELETE HETHONG.TINHTRANGRV WHERE TINHTRANGID = '" + tinhTrangID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexTinhTrangRV(ArrayList<TinhTrangRV> lst, String tinhTrangID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getTinhTrangID().equals(tinhTrangID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getTinhTrangID().compareTo(tinhTrangID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameTinhTrangRV(ArrayList<TinhTrangRV> lst, String tinhTrangID){
        int i;
        i = getIndexTinhTrangRV(lst, tinhTrangID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenTinhTrang();
    }
    
    public void saveTinhTrangRV(TinhTrangRV dt)throws Exception{
        String sql="CALL HETHONG.SAVETINHTRANGRV(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getTinhTrangID());
        ps.setString(2, dt.getTenTinhTrang());
        ps.executeUpdate();        
    }        
}
