/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.DataUtil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bvndc
 */
public class ActionThuPhiCQ {
    public ResultSet getThuPhiCQ()throws Exception{
        String sql="SELECT TP.NGAY, TP.COQUANID, CO.TENCOQUAN, TP.THUNGANID, TN.HOTEN AS THUNGAN, TP.SOTIEN FROM KHAMSUCKHOE.THUPHICQ TP JOIN KHAMSUCKHOE.COQUAN CQ ON TP.COQUANID = CQ.COQUANID ";
        sql += "JOIN KHAMSUCKHOE.THUNGAN TN ON TP.THUNGANID = TN.THUNGANID ORDER BY TP.NGAY";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteThuPhiCQ(String coQuanID, Date ngay, String thuNganID) throws SQLException{
        String sql = "DELETE KHAMSUCKHOE.THUPHICQ WHERE COQUANID = ? AND NGAY = ? AND THUNGANID = ?";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, coQuanID);
        ps.setDate(2, ngay);
        ps.setString(3, thuNganID);
        ps.executeUpdate();
    }
    
    public void saveThuPhiCQ(ThuPhiCQ ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVETHUPHICQ(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, ar.getCoQuanID());
        ps.setDate(2, ar.getNgay());
        ps.setString(3, ar.getThuNganID());
        ps.setFloat(4, ar.getSoTien());
        ps.execute();        
    }       
}
