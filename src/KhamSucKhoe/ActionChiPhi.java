/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bvndc
 */
public class ActionChiPhi {
    public ResultSet getListChiPhi(String soKSK)throws Exception{
        String sql="SELECT CASE WHEN CP.THUPHIID IS NULL THEN '' ELSE 'X' END AS THU, CP.GIAVPID, VP.TENGIAVP, CP.SOLUONG, CP.DONGIA, CP.SOLUONG * CP.DONGIA AS THANHTIEN FROM KHAMSUCKHOE.CHIPHI CP JOIN KHAMSUCKHOE.GIAVP VP ON CP.GIAVPID = VP.GIAVPID ";
        sql += "WHERE SOKSK = '" + soKSK + "' ";
        sql += "ORDER BY CP.GIAVPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteChiPhi(String soKSK, String giaVPID){
        String sql = "DELETE KHAMSUCKHOE.CHIPHI WHERE soKSK = '" + soKSK + "' AND GIAVPID = '" + giaVPID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public void saveChiPhi(ChiPhi ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVECHIPHI(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getSoKSK());
        ps.setString(2, ar.getGiaVPID());
        ps.setInt(3, ar.getSoLuong());
        ps.setFloat(4, ar.getDonGia());
        ps.execute();        
    }            
    public ResultSet getTongChiPhi(String soKSK) throws SQLException{
        String sql = "CALL KHAMSUCKHOE.GETTONGCHIPHI(?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, soKSK);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
