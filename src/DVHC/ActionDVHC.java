/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

/**
 *
 * @author bvndc
 */
import java.sql.*;
import DataDB2.*;

public class ActionDVHC {
    public ResultSet getAllDVHC(String value)throws Exception{
        String sql="SELECT * FROM HETHONG.VIEWDVHC WHERE UCASE(TENTAT) = '" + value.toUpperCase().trim() + "' OR UCASE(TENDVHC) LIKE '%" + value.toUpperCase() + "%'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public String getTenDVHC(String maXP) throws SQLException{
        String sql="SELECT TenDVHC FROM HETHONG.VIEWDVHC WHERE UCASE(MAXP) = '" + maXP.toUpperCase().trim() + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        return rs.getString("TenDVHC");
    }
}
