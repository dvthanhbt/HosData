/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionTacGia {
    public ArrayList<TacGia>getAllTacGia()throws Exception{
        ArrayList<TacGia> lst = new ArrayList<TacGia>();
        String sql="SELECT * FROM KHKT.TACGIA ORDER BY TACGIAID";
        ResultSet rs= DataUtil.executeQuery(sql);
        TacGia ar = null;
        while(rs.next()){
            ar = new TacGia(rs.getString("NCKHID"), rs.getString("MaNV"), rs.getString("LoaiNVID"), rs.getInt("ChuNhiem"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListTacGia()throws Exception{
        String sql="SELECT * FROM KHKT.TACGIA ORDER BY TACGIAID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListTacGia(String nckhID)throws Exception{
        String sql="CALL KHKT.LISTTACGIA (?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, nckhID);
        ResultSet rs = ps.executeQuery();
        return rs;
    }    
    
    public void deleteTacGia(String nckhID, String maNV){
        String sql = "DELETE KHKT.TACGIA WHERE NCKHID = '" + nckhID + "' AND MANV = '" + maNV + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public void deleteTacGia(String nckhID){
        String sql = "DELETE KHKT.TACGIA WHERE NCKHID = '" + nckhID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }

    public void saveTacGia(TacGia ar)throws Exception{
        String sql="CALL KHKT.SAVETACGIA(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getNckhID());
        ps.setString(2, ar.getMaNV());
        ps.setString(3, ar.getLoaiNVID());
        ps.setInt(4, ar.getChuNhiem());
        ps.executeUpdate();        
    }      
}
