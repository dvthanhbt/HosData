/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChuyenVien;

/**
 *
 * @author bvndc
 */
//import java.util.ArrayList;
import java.sql.*;
import DataDB2.*;
//import java.util.*;

public class ActionChuyenDi {
    public ResultSet getListChuyenDi(java.sql.Date tuNgay, java.sql.Date denNgay)throws Exception{
        String sql="CALL CHUYENVIEN.LISTCHUYENDI(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setDate(1, (java.sql.Date) tuNgay);
        ps.setDate(2, (java.sql.Date) denNgay);
        ResultSet rs;
        rs = ps.executeQuery();
        return rs;
    }
    public ResultSet getTKChuyenDi(Date tuNgay, Date denNgay, int noiNgoai, int noiDung) throws SQLException{
        String sql="CALL CHUYENVIEN.TKCHUYENDI(?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setDate(1, tuNgay);
        cs.setDate(2, (java.sql.Date) denNgay);
        cs.setInt(3, noiNgoai);
        cs.setInt(4,noiDung);
        ResultSet rs = cs.executeQuery();
        return rs;
    }
    public ResultSet getTKCungTuyen(Date tuNgay, Date denNgay) throws SQLException{
        String sql="CALL CHUYENVIEN.TKCUNGTUYEN(?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setDate(1, tuNgay);
        cs.setDate(2, (java.sql.Date) denNgay);
        ResultSet rs = cs.executeQuery();
        return rs;
    }
    public ResultSet getTKTuyenDuoi(Date tuNgay, Date denNgay) throws SQLException{
        String sql="CALL CHUYENVIEN.TKTUYENDUOI(?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setDate(1, tuNgay);
        cs.setDate(2, (java.sql.Date) denNgay);
        ResultSet rs = cs.executeQuery();
        return rs;
    }
    public ResultSet getTKTuyenTren(Date tuNgay, Date denNgay) throws SQLException{
        String sql="CALL CHUYENVIEN.TKTUYENTREN(?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setDate(1, tuNgay);
        cs.setDate(2, (java.sql.Date) denNgay);
        ResultSet rs = cs.executeQuery();
        return rs;
    }
    public String saveData(ChuyenDi cd)throws Exception{
        String sql="CALL CHUYENVIEN.SAVECHUYENDI(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, cd.getChuyenVienID());
        cs.setDate(2, (java.sql.Date) cd.getNgayChuyen());
        cs.setString(3, cd.getMaBN());
        cs.setString(4, cd.getMaKP());
        cs.setString(5, cd.getMaBS());
        cs.setString(6, cd.getDoiTuongID());
        cs.setString(7, cd.getSoBHYT());
        cs.setShort(8, cd.getTraiTuyen());
        cs.setString(9, cd.getIcdBenhID());
        cs.setString(10, cd.getBenhVienID());
        cs.setString(11, cd.getPhuongTienID());
        cs.setString(12, cd.getLyDoID());
        cs.setShort(13, cd.getDaChuyen());
        cs.setShort(14, cd.getNoiTru());
        cs.setDate(15, (java.sql.Date) cd.getTuNgay());
        cs.setDate(16, (java.sql.Date) cd.getDenNgay());
        cs.registerOutParameter(1, java.sql.Types.VARCHAR); //Lay gia tri tra ve tu Procedure
        cs.executeUpdate();  
        String oParam = cs.getString(1);
        return oParam;
    }
    public void deleteChuyenDi(String chuyenVienID){
        String sql = "DELETE CHUYENVIEN.CHUYENDI WHERE CHUYENVIENID = '" + chuyenVienID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public void updateChuyenDi(String chuyenVienID, int daChuyen){
        String sql = "UPDATE CHUYENVIEN.CHUYENDI SET DACHUYEN = " + daChuyen + " WHERE CHUYENVIENID = '" + chuyenVienID + "'";
        DataUtil.executeNoneQuery(sql);
    }
    public ChuyenDi getChuyenDi(String chuyenVienID)throws Exception{
        ChuyenDi cd = new ChuyenDi();
        String sql = "SELECT * FROM CHUYENVIEN.CHUYENDI WHERE CHUYENVIENID = '" + chuyenVienID + "'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        while (rs.next()){
            cd.setChuyenDi(rs.getString("ChuyenVienID"),
            rs.getString("MaBN"),
            rs.getDate("NgayChuyen"),
            rs.getString("MaKP"),
            rs.getString("MaBS"),
            rs.getString("DoiTuongID"),
            rs.getString("SoBHYT"),
            rs.getShort("TraiTuyen"),
            rs.getString("ICDBenhID"),
            rs.getString("BenhVienID"),
            rs.getString("PhuongTienID"),
            rs.getString("LyDoID"),
            rs.getShort("DaChuyen"),
            rs.getShort("NoiTru"),
            rs.getDate("TuNgay"),
            rs.getDate("DenNgay"));
        }
        return cd;
    }

}
