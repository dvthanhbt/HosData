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
import java.sql.*;
import DataDB2.*;

public class ActionBenhNhan {

    public BenhNhan getBenhNhan(String maBN) throws Exception {
        BenhNhan bn = new BenhNhan();
        String sql = "SELECT * FROM CHUYENVIEN.BENHNHAN WHERE MABN = '" + maBN + "'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        while (rs.next()) {
            bn.setBenhNhan(rs.getString("MaBN"),
            rs.getString("HoTen"),
            rs.getShort("NamSinh"),
            rs.getShort("GioiTinh"),
            rs.getString("MaXP"));
        }
        return bn;
    }

    public String saveData(BenhNhan bn) throws Exception {
        String sql = "CALL CHUYENVIEN.SAVEBENHNHAN(?, ?, ?, ?, ?)";
        //PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, bn.getMaBN());
        cs.setString(2, bn.getHoTen());
        cs.setShort(3, bn.getNamSinh());
        cs.setShort(4, bn.getGioiTinh());
        cs.setString(5, bn.getMaXP());
        cs.registerOutParameter(1, java.sql.Types.VARCHAR); //Lay gia tri tra ve tu Procedure
        cs.executeUpdate();
        String oParam = cs.getString(1);
        return oParam;
    }

    public void deleteBenhNhan(String maBN) {
        String sql = "DELETE CHUYENVIEN.BENHNHAN WHERE MABN = '" + maBN + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }

}
