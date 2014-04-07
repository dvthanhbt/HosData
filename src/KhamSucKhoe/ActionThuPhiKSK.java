/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.DataUtil;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bvndc
 */
public class ActionThuPhiKSK {
    public ResultSet getThuPhiCQ()throws Exception{
        String sql="SELECT TP.SOKSK, TP.NGAY, KSK.HOTEN, KSK.NAMSINH, DVHC.TENDVHC, TN.HOTEN AS THUNGAN, TP.SOTIEN FROM KHAMSUCKHOE.THUPHIKSK TP JOIN KHAMSUCKHOE.GIAYKSK KSK ON TP.SOKSK = KSK.SOKSK ";
        sql += "JOIN KHAMSUCKHOE.THUNGAN TN ON TP.THUNGANID = TN.THUNGANID ";
        sql += "JOIN HETHONG.VIEWDVHC DVHC ON KSK.DIACHI = DVHC.MAXP";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteThuPhiCQ(String soKSK) throws SQLException{
        String sql = "DELETE KHAMSUCKHOE.THUPHIKSK WHERE SOKSK = '" + soKSK + "'";
        DataUtil.executeNoneQuery(sql);
    }
    
    public String saveThuPhiCQ(ThuPhiKSK ar)throws Exception{
        String sql="CALL KHAMSUCKHOE.SAVETHUPHIKSK(?, ?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, ar.getThuPhiID());
        cs.setString(2, ar.getSoKSK());
        cs.setDate(3, ar.getNgay());
        cs.setString(4, ar.getThuNganID());
        cs.setFloat(5, ar.getSoTien());
        cs.registerOutParameter(1, java.sql.Types.CHAR);
        cs.executeUpdate();
        String oParam = cs.getString(1);
        return oParam;   
    }           
}
