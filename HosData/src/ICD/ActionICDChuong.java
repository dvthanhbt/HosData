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
public class ActionICDChuong {
    public ArrayList<ICDChuong>getAllICDChuong()throws Exception{
        ArrayList<ICDChuong> lst = new ArrayList<ICDChuong>();
        String sql="SELECT * FROM HETHONG.BACSI ORDER BY MABS";
        ResultSet rs= DataUtil.executeQuery(sql);
        ICDChuong icd = null;
        while(rs.next()){
            icd = new ICDChuong(rs.getInt("ICDChuongID"), rs.getString("TenChuong"));
            lst.add(icd);
        }
        return lst;
    }    
    public ResultSet getListICDChuong()throws Exception{
        String sql="SELECT * FROM HETHONG.ICDCHUONG ORDER BY ICDCHUONG";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteICDChuong(int icdChuongID){
        String sql = "DELETE HETHONG.ICDCHUONG WHERE ICDCHUONG = " + String.valueOf(icdChuongID) ;
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexICDChuong(ArrayList<ICDChuong> lst, int icdChuongID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getIcdChuongID() == icdChuongID){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getIcdChuongID() < icdChuongID)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameICDChuong(ArrayList<ICDChuong> lst, int icdChuongID){
        int i;
        i = getIndexICDChuong(lst, icdChuongID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenChuong();
    }
    
    public void saveICDChuong(ICDChuong icd)throws Exception{
        String sql="CALL HETHONG.SAVEICDCHUONG(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, icd.getIcdChuongID());
        ps.setString(2, icd.getTenChuong());
        ps.executeUpdate();        
    }        
}
