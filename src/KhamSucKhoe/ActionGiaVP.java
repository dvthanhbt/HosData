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
public class ActionGiaVP {
    public ArrayList<GiaVP>getAllGiaVP()throws Exception{
        ArrayList<GiaVP> lst = new ArrayList<GiaVP>();
        String sql="SELECT * FROM KHAMSUCKHOE.GIAVP ORDER BY GIAVPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        GiaVP ar = null;
        while(rs.next()){
            ar = new GiaVP(rs.getString("GiaVPID"),
                    rs.getString("TenGiaVP"),
                    rs.getString("DonVi"),
                    rs.getFloat("GiaTH"),
                    rs.getFloat("GiaBH"),
                    rs.getFloat("GiaDV"),
                    rs.getInt("BHYT"),
                    rs.getInt("Hide"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListGiaVP()throws Exception{
        String sql="SELECT GIAVPID, TENGIAVP, DONVI, GIATH FROM KHAMSUCKHOE.GIAVP WHERE HIDE = 0 ORDER BY GIAVPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListGiaVP(String value)throws Exception{
        String sql="SELECT * FROM KHAMSUCKHOE.GIAVP WHERE HIDE = 0 AND GIAVPID LIKE '%" + value + "%' OR UCASE(TENGIAVP) LIKE '%" + value.toUpperCase() + "%'";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteGiaVP(String giaVPID){
        String sql = "DELETE KHAMSUCKHOE.GIAVP WHERE GIAVPID = '" + giaVPID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexGiaVP(ArrayList<GiaVP> lst, String giaVPID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getGiaVPID().equals(giaVPID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getGiaVPID().compareTo(giaVPID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameGiaVP(ArrayList<GiaVP> lst, String giaVPID){
        int i;
        i = getIndexGiaVP(lst, giaVPID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenGiaVP();
    }
    
    public void saveGiaVP(GiaVP ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVEGIAVP(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getGiaVPID());
        ps.setString(2, ar.getTenGiaVP());
        ps.setString(3, ar.getDonVi());
        ps.setFloat(4, ar.getGiaTH());
        ps.setFloat(5, ar.getGiaBH());
        ps.setFloat(6, ar.getGiaDV());
        ps.setInt(7, ar.getBhyt());
        ps.setInt(8, ar.getHide());
        ps.execute();        
    }          
}
