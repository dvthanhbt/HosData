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
public class ActionNguyenNhanNV {
    public ArrayList<NguyenNhanNV>getAllNguyenNhanNV()throws Exception{
        ArrayList<NguyenNhanNV> lst = new ArrayList<NguyenNhanNV>();
        String sql="SELECT * FROM HETHONG.NGUYENNHANNV ORDER BY NGUYENNHANID";
        ResultSet rs= DataUtil.executeQuery(sql);
        NguyenNhanNV dt = null;
        while(rs.next()){
            dt = new NguyenNhanNV(rs.getString("NguyenNhanID"), rs.getString("TenNguyenNhan"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListNguyenNhanNV()throws Exception{
        String sql="SELECT * FROM HETHONG.NGUYENNHANNV ORDER BY NGUYENNHANID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteNguyenNhanNV(String nguyenNhanID){
        String sql = "DELETE HETHONG.NGUYENNHANNV WHERE NGUYENNHANID = '" + nguyenNhanID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexNguyenNhanNV(ArrayList<NguyenNhanNV> lst, String nguyenNhanID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getNguyenNhanID().equals(nguyenNhanID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getNguyenNhanID().compareTo(nguyenNhanID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameNguyenNhanNV(ArrayList<NguyenNhanNV> lst, String nguyenNhanID){
        int i;
        i = getIndexNguyenNhanNV(lst, nguyenNhanID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenNguyenNhan();
    }
    
    public void saveNguyenNhanNV(NguyenNhanNV dt)throws Exception{
        String sql="CALL HETHONG.SAVENGUYENNHANNV(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getNguyenNhanID());
        ps.setString(2, dt.getTenNguyenNhan());
        ps.executeUpdate();        
    }        
}
