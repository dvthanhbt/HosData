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
public class ActionDanToc {
    public ArrayList<DanToc>getAllDanToc()throws Exception{
        ArrayList<DanToc> lst = new ArrayList<DanToc>();
        String sql="SELECT * FROM HETHONG.DANTOC ORDER BY DANTOCID";
        ResultSet rs= DataUtil.executeQuery(sql);
        DanToc dt = null;
        while(rs.next()){
            dt = new DanToc(rs.getString("DanTocID"), rs.getString("TenDanToc"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListDanToc()throws Exception{
        String sql="SELECT * FROM HETHONG.DANTOC ORDER BY DANTOCID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteDanToc(String danTocID){
        String sql = "DELETE HETHONG.DANTOC WHERE DANTOCID = '" + danTocID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexDanToc(ArrayList<DanToc> lst, String danTocID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getDanTocID().equals(danTocID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getDanTocID().compareTo(danTocID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameDanToc(ArrayList<DanToc> lst, String danTocID){
        int i;
        i = getIndexDanToc(lst, danTocID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenDanToc();
    }
    
    public void saveDanToc(DanToc dt)throws Exception{
        String sql="CALL HETHONG.SAVEDANTOC(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getDanTocID());
        ps.setString(2, dt.getTenDanToc());
        ps.executeUpdate();        
    }        
}
