/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.DataUtil;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bvndc
 */
public class ActionGiayKSK {
    public void deleteGiayKSK(String soKSK){
        String sql = "DELETE KHAMSUCKHOE.GIAYKSK WHERE SOKSK = '" + soKSK + "'";
        DataUtil.executeNoneQuery(sql);
    }
    public String saveGiayKSK(GiayKSK giayKSK) throws SQLException{
        String sql = "CALL KHAMSUCKHOE.SAVEGIAYKSK (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, giayKSK.getSoKSK());
        cs.setDate(2, giayKSK.getNgay());
        cs.setString(3, giayKSK.getHoTen());
        cs.setInt(4, giayKSK.getNamSinh());
        cs.setInt(5, giayKSK.getGioiTinh());
        cs.setString(6, giayKSK.getSoCMND());
        cs.setDate(7, giayKSK.getCapNgay());
        cs.setString(8, giayKSK.getDiaChi());
        cs.setString(9, giayKSK.getLyDoID());
        cs.setString(10, giayKSK.getQuocGiaID());
        cs.setString(11, giayKSK.getCoQuanID());
        cs.setString(12, giayKSK.getKetQua());
        cs.registerOutParameter(1, java.sql.Types.CHAR);
        cs.executeUpdate();
        String oParam = cs.getString(1);
        return oParam;
    }
    public ResultSet getGiayKSK(Date tuNgay, Date denNgay) throws SQLException{
        String sql = "CALL KHAMSUCKHOE.LISTGIAYKSK(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setDate(1, tuNgay);
        ps.setDate(2, denNgay);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet getGiayKSK(String soKSK){
        String sql = "Select * From KhamSucKhoe.GiayKSK Where SoKSK = '" + soKSK + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public GiayKSK getGiayKSK1(String soKSK) throws SQLException{
        String sql = "Select * From KhamSucKhoe.GiayKSK Where SoKSK = '" + soKSK + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        GiayKSK giayKSK = new GiayKSK(rs.getString("SoKSK"), rs.getDate("Ngay"), rs.getString("HoTen"), rs.getInt("NamSinh"), rs.getInt("GioiTInh"), rs.getString("SoCMND"), rs.getDate("CapNgay"), rs.getString("DiaChi"), rs.getString("LyDoID"), rs.getString("QuocGiaID"), rs.getString("CoQuanID"), rs.getString("KetQua"));
        return giayKSK;
    }
}
