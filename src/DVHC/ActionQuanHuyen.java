/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionQuanHuyen {
    public ArrayList<QuanHuyen>getAllQuanHuyen(String maTT)throws Exception{
        ArrayList<QuanHuyen> lst=new ArrayList<QuanHuyen>();
        String sql="SELECT * FROM HETHONG.QUANHUYEN WHERE MATT = '" + maTT + "'";
        ResultSet rs= DataUtil.executeQuery(sql);
        QuanHuyen qh = null;
        while(rs.next()){
            qh = new QuanHuyen(rs.getString("MaQH"), rs.getString("MaTT"), rs.getString("TenQH"), rs.getString("TenTat"));
            lst.add(qh);
        }
        return lst;
    }
    public ResultSet getQuanHuyen(String maTT){
        String sql = "SELECT * FROM HETHONG.QUANHUYEN WHERE MATT = '" + maTT + "' ORDER BY MAQH";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteQuanHuyen(String maQH){
        String sql = "DELETE HETHONG.QUANHUYEN WHERE MAQH = '" + maQH + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexQuanHuyen(ArrayList<QuanHuyen> lst, String maQH){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaQH().equals(maQH)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaQH().compareTo(maQH) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }
    public String getNameQuanHuyen(ArrayList<QuanHuyen> lst, String maQH){
        int i;
        i = getIndexQuanHuyen(lst, maQH);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenQH();
    }    
    public void saveQuanHuyen(QuanHuyen qh) throws SQLException{
        String sql = "CALL HETHONG.SAVEQUANHUYEN (?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, qh.getMaQH());
        ps.setString(2, qh.getMaTT());
        ps.setString(3, qh.getTenQH());
        ps.setString(4, qh.getTenTat());
        ps.execute();
    }

    void saveQuanHuyen(XaPhuong xaPhuong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
