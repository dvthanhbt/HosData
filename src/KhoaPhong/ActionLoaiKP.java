/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhoaPhong;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionLoaiKP {
    public ArrayList<LoaiKP>getAllLoaiKP()throws Exception{
        ArrayList<LoaiKP> lst = new ArrayList<LoaiKP>();
        String sql="SELECT * FROM HETHONG.LOAIKP ORDER BY LOAIKPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        LoaiKP kp = null;
        while(rs.next()){
            kp = new LoaiKP(rs.getString("LoaiKPID"), rs.getString("TenLoaiKP"));
            lst.add(kp);
        }
        return lst;
    }    
    public ResultSet getLoaiKP(){
        String sql = "SELECT * FROM HETHONG.LOAIKP ORDER BY LOAIKPID";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteLoaiKP(String loaiKPID){
        String sql = "DELETE HETHONG.LOAIKP WHERE LOAIKPID = '" + loaiKPID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexLoaiKP(ArrayList<LoaiKP> lst, String loaiKPID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLoaiKPID().equals(loaiKPID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLoaiKPID().compareTo(loaiKPID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameLoaiKP(ArrayList<LoaiKP> lst, String loaiKPID){
        int i;
        i = getIndexLoaiKP(lst, loaiKPID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenLoaiKP();
    }
    
    public void saveLoaiKP(KhoaPhong kp)throws Exception{
        String sql="CALL HETHONG.SAVELOAIKP(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, kp.getLoaiKPID());
        ps.setString(2, kp.getTenKP());
        ps.executeUpdate();        
    }    
}
