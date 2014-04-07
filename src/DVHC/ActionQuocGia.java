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
public class ActionQuocGia {
    public ArrayList<QuocGia>getAllQuocGia()throws Exception{
        ArrayList<QuocGia> lst=new ArrayList<QuocGia>();
        String sql="SELECT * FROM HETHONG.QUOCGIA ORDER BY QUOCGIAID";
        ResultSet rs= DataUtil.executeQuery(sql);
        QuocGia qg = null;
        while(rs.next()){
            qg = new QuocGia(rs.getString("QuocGiaID"), rs.getString("TenQuocGia"), rs.getString("English"), rs.getString("KyHieu"));
            lst.add(qg);
        }
        return lst;
    }
    public ResultSet getQuocGia(){
        String sql = "SELECT * FROM HETHONG.QUOCGIA ORDER BY QUOCGIAID";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public ResultSet getQuocGia(String value){
        String sql = "SELECT * FROM HETHONG.QUOCGIA ";
        sql += "WHERE UCASE(QUOCGIAID) LIKE '%" + value.toUpperCase() + "%' ";
        sql += "OR UCASE(TENQUOCGIA) LIKE '%" + value.toUpperCase() + "%' ";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteQuocGia(String quocGiaID){
        String sql = "DELETE HETHONG.QUOCGIA WHERE MATT = '" + quocGiaID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexQuocGia(ArrayList<QuocGia> lst, String quocGiaID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getQuocGiaID().equals(quocGiaID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getQuocGiaID().compareTo(quocGiaID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameQuocGia(ArrayList<QuocGia> lst, String quocGiaID){
        int i;
        i = getIndexQuocGia(lst, quocGiaID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenQuocGia();
    }
    public String getNameQuocGia(String quocGiaID) throws SQLException{
        String sql = "Select * From HeThong.QuocGia Where QuocGiaID = '" + quocGiaID + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        return rs.getString("TenQuocGia");
    }
    public void saveQuocGia(QuocGia quocGia) throws SQLException{
        String sql = "CALL HETHONG.SAVEQUOCGIA (?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, quocGia.getQuocGiaID());
        ps.setString(2, quocGia.getTenQuocGia());
        ps.setString(3, quocGia.getEnglish());
        ps.setString(4, quocGia.getKyHieu());
        ps.execute();
    }
}
