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
public class ActionCoQuan {
    public ArrayList<CoQuan>getAllCoQuan()throws Exception{
        ArrayList<CoQuan> lst = new ArrayList<CoQuan>();
        String sql="SELECT * FROM KHAMSUCKHOE.COQUAN ORDER BY COQUANID";
        ResultSet rs= DataUtil.executeQuery(sql);
        CoQuan ar = null;
        while(rs.next()){
            ar = new CoQuan(rs.getString("CoQuanID"), rs.getString("TenCoQuan"), rs.getString("DiaChi"), rs.getString("DienThoai"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListCoQuan()throws Exception{
        String sql="SELECT CQ.COQUANID, CQ.TENCOQUAN, DVHC.TENDVHC, CQ.DIENTHOAI FROM KHAMSUCKHOE.COQUAN CQ JOIN HETHONG.VIEWDVHC DVHC ON CQ.DIACHI = DVHC.MAXP ORDER BY COQUANID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteCoQuan(String coQuanID){
        String sql = "DELETE KHAMSUCKHOE.COQUAN WHERE COQUANID = '" + coQuanID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexCoQuan(ArrayList<CoQuan> lst, String coQuanID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getCoQuanID().equals(coQuanID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getCoQuanID().compareTo(coQuanID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameCoQuan(ArrayList<CoQuan> lst, String coQuanID){
        int i;
        i = getIndexCoQuan(lst, coQuanID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenCoQuan();
    }
    
    public void saveCoQuan(CoQuan ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVECOQUAN(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getCoQuanID());
        ps.setString(2, ar.getTenCoQuan());
        ps.setString(3, ar.getDiaChi());
        ps.setString(4, ar.getDienThoai());
        ps.execute();        
    }            
}
