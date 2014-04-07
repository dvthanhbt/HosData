/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ICD;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionICDNhom {
    public ArrayList<ICDNhom>getAllICDNhom(int icdChuongID)throws Exception{
        ArrayList<ICDNhom> lst = new ArrayList<ICDNhom>();
        String sql="SELECT * FROM HETHONG.ICDNHOM WHERE ICDCHUONGID = " + String.valueOf(icdChuongID) + " ORDER BY ICDNHOMID";
        ResultSet rs= DataUtil.executeQuery(sql);
        ICDNhom icd = null;
        while(rs.next()){
            icd = new ICDNhom(rs.getInt("ICDNhomID"), rs.getInt("ICDChuongID"), rs.getString("TenChuong"));
            lst.add(icd);
        }
        return lst;
    }    
    public ResultSet getListICDNhom(int icdChuongID)throws Exception{
        String sql="SELECT * FROM HETHONG.ICDNHOM WHERE ICDCHUONGID = " + String.valueOf(icdChuongID) + "ORDER BY ICDNHOMID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteICDNhom(int icdNhomID){
        String sql = "DELETE HETHONG.ICDNHOM WHERE ICDNHOMID = " + String.valueOf(icdNhomID);
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexICDNhom(ArrayList<ICDNhom> lst, int icdNhomID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getIcdNhomID()== icdNhomID){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getIcdNhomID()< icdNhomID)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameICDNhom(ArrayList<ICDNhom> lst, int icdNhomID){
        int i;
        i = getIndexICDNhom(lst, icdNhomID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenNhom();
    }
    
    public void saveICDNhom(ICDNhom icd)throws Exception{
        String sql="CALL HETHONG.SAVEICDCHUONG(?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, icd.getIcdNhomID());
        ps.setInt(2, icd.getIcdChuongID());
        ps.setString(3, icd.getTenNhom());
        ps.executeUpdate();        
    }          
}
