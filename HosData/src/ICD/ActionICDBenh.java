/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ICD;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionICDBenh {
    public ArrayList<ICDBenh>getAllICDBenh(int icdNhomID)throws Exception{
        ArrayList<ICDBenh> lst = new ArrayList<ICDBenh>();
        String sql="SELECT * FROM HETHONG.ICDBENH WHERE ICDNHOMID = " + String.valueOf(icdNhomID) + " ORDER BY ICDBENHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        ICDBenh icd = null;
        while(rs.next()){
            icd = new ICDBenh(rs.getString("ICDBenhID"), rs.getInt("ICDNhomID"), rs.getString("TenBenh"), rs.getString("English"), rs.getString("STT"));
            lst.add(icd);
        }
        return lst;
    }    
    public ResultSet getListICDBenh()throws Exception{
        String sql="SELECT ICDBenhID, TenBenh FROM HETHONG.ICDBENH ORDER BY ICDBENHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListICDBenh(int icdNhomID)throws Exception{
        String sql="SELECT * FROM HETHONG.ICDBENH WHERE ICDNHOMID = " + String.valueOf(icdNhomID) + " ORDER BY ICDBENHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getICDBenh(String icdBenhID)throws Exception{
        String sql="SELECT * FROM HETHONG.ICDBENH WHERE ICDBENHID LIKE '" + icdBenhID + "%' ORDER BY ICDBENHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public String getTenBenh(String icdBenhID) throws SQLException{
        String sql="SELECT TenBenh FROM HETHONG.ICDBENH WHERE UCASE(ICDBENHID) = '" + icdBenhID.toUpperCase().trim() + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        return rs.getString("TenBenh");        
    }
    public void deleteICDBenh(int icdBenhID){
        String sql = "DELETE HETHONG.ICDBENH WHERE ICDBENHID = " + String.valueOf(icdBenhID);
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexICDBenh(ArrayList<ICDBenh> lst, String icdBenhID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getIcdBenhID().equals(icdBenhID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getIcdBenhID().compareTo(icdBenhID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameICDBenh(ArrayList<ICDBenh> lst, String icdBenhID){
        int i;
        i = getIndexICDBenh(lst, icdBenhID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenBenh();
    }
    
    public void saveICDBenh(ICDBenh icd)throws Exception{
        String sql="CALL HETHONG.SAVEICDBENH(?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, icd.getIcdBenhID());
        ps.setInt(2, icd.getIcdNhomID());
        ps.setString(3, icd.getTenBenh());
        ps.setString(3, icd.getEnglish());
        ps.setString(3, icd.getStt());
        ps.executeUpdate();        
    }       
}
