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
public class ActionGiayKSKTra {
    public void saveData(GiayKSKTra giayKSKTra) throws SQLException{
        String sql = "CALL KHAMSUCKHHOE.SAVEGIAYKSKTRA(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, giayKSKTra.getSoKSK());
        ps.setDate(2, giayKSKTra.getNgay());
        ps.setString(3, giayKSKTra.getLyDo());
        ps.setString(4, giayKSKTra.getKetQua());
        ps.execute();
    }
    public void deleteData(String soKSK){
        String sql = "DELETE KHAMSUCKHOE.GIAYKSKTRA WHERE SOKSK = '" + soKSK + "'";
        DataUtil.executeNoneQuery(sql);
    }
    public ResultSet getGiayKSKTra(String soKSK){
        String sql = "SELECT * FROM KHAMSUCKHOE.GIAYKSKTRA WHERE SOKSK = '" + soKSK + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public ResultSet getGiayKSKTra(Date tuNgay, Date denNgay) throws SQLException{
        String sql = "SELECT * FROM KHAMSUCKHOE.GIAYKSKTRA WHERE NGAY BETWEEN ? AND ?";
        PreparedStatement ps = DataUtil.getConnect().prepareCall(sql);
        ps.setDate(1, tuNgay);
        ps.setDate(2, denNgay);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
