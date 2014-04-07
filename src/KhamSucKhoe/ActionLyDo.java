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
public class ActionLyDo {
    public ArrayList<LyDo>getAllLyDo()throws Exception{
        ArrayList<LyDo> lst = new ArrayList<LyDo>();
        String sql="SELECT * FROM KHAMSUCKHOE.LYDO ORDER BY LYDOID";
        ResultSet rs= DataUtil.executeQuery(sql);
        LyDo ar = null;
        while(rs.next()){
            ar = new LyDo(rs.getString("LyDoID"), rs.getString("TenLyDo"), rs.getString("GiaVPID"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListLyDo()throws Exception{
        String sql="SELECT * FROM KHAMSUCKHOE.LYDO ORDER BY LYDOID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteLyDo(String lyDoID){
        String sql = "DELETE KHAMSUCKHOE.LYDO WHERE LYDOID = '" + lyDoID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexLyDo(ArrayList<LyDo> lst, String lyDoID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLyDoID().equals(lyDoID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLyDoID().compareTo(lyDoID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameLyDo(ArrayList<LyDo> lst, String lyDoID){
        int i;
        i = getIndexLyDo(lst, lyDoID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenLyDo();
    }
    
    public void saveLyDo(LyDo ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVELYDO(?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getLyDoID());
        ps.setString(2, ar.getTenLyDo());
        ps.setString(3, ar.getGiaVPID());
        ps.executeUpdate();        
    }         
}
