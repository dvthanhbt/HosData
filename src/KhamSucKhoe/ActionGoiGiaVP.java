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
public class ActionGoiGiaVP {
    public void insertData(String lyDoID, String giaVPID) throws SQLException{
        String sql = "INSERT INTO KHAMSUCKHOE.GOIGIAVP (LYDOID, GIAVPID) VALUES (?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, lyDoID);
        ps.setString(2, giaVPID);
        int executeUpdate = ps.executeUpdate();
    }
    public void deleteData(String lyDoID, String giaVPID) throws SQLException{
        String sql = "DELETE KHAMSUCKHOE.GOIGIAVP WHERE LYDOID = ? AND GIAVPID = ?";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, lyDoID);
        ps.setString(2, giaVPID);
        int executeUpdate = ps.executeUpdate();
    }
    public ResultSet getListGoiGiaVP(String lyDoID){
        String sql="SELECT CP.GIAVPID, VP.TENGIAVP, VP.DONVI, VP.GIATH FROM KHAMSUCKHOE.GOIGIAVP CP JOIN KHAMSUCKHOE.GIAVP VP ON CP.GIAVPID = VP.GIAVPID ";
        sql += "WHERE CP.LYDOID = '" + lyDoID + "' ";
        sql += "ORDER BY VP.GIAVPID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs; 
    }
}
