/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TongHop;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionBacSi {
    public ArrayList<BacSi>getAllBacSi()throws Exception{
        ArrayList<BacSi> lst = new ArrayList<BacSi>();
        String sql="SELECT * FROM HETHONG.BACSI WHERE HIEULUC = 1 ORDER BY MABS";
        ResultSet rs= DataUtil.executeQuery(sql);
        BacSi bs = null;
        while(rs.next()){
            bs = new BacSi(rs.getString("MaBS"), rs.getString("HoTen"), rs.getInt("HieuLuc"));
            lst.add(bs);
        }
        return lst;
    }    
    public ResultSet getListBacSi()throws Exception{
        String sql="SELECT * FROM HETHONG.BACSI WHERE HIEULUC = 1 ORDER BY MABS";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListBacSi(String value)throws Exception{
        String sql="SELECT MABS, HOTEN FROM HETHONG.BACSI WHERE (MABS = '" + value + "' OR UCASE(HOTEN) LIKE '%" + value.toUpperCase() + "%') AND HIEULUC = 1 ORDER BY MABS";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public String gethoTen(String maBS) throws SQLException{
        String sql="SELECT HoTen FROM HETHONG.BACSI WHERE UCASE(MABS) = '" + maBS.toUpperCase().trim() + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        return rs.getString("HoTen");
    }
    public void deleteBacSi(String maBS){
        String sql = "DELETE HETHONG.BACSI WHERE MABS = '" + maBS + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexBacSi(ArrayList<BacSi> lst, String maBS){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaBS().equals(maBS)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaBS().compareTo(maBS) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameBacSi(ArrayList<BacSi> lst, String maBS){
        int i;
        i = getIndexBacSi(lst, maBS);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getHoTen();
    }
    
    public void saveBacSi(BacSi bs)throws Exception{
        String sql="CALL HETHONG.SAVEBACSI(?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, bs.getMaBS());
        ps.setString(2, bs.getHoTen());
        ps.setInt(3, bs.getHieuLuc());
        ps.executeUpdate();        
    }        
}
