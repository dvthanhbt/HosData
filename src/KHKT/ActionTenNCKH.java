/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

import DataDB2.DataUtil;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionTenNCKH {
    public ArrayList<TenNCKH>getAllTenNCKH()throws Exception{
        ArrayList<TenNCKH> lst = new ArrayList<TenNCKH>();
        String sql="SELECT * FROM KHKT.TENNCKH ORDER BY NCKHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        TenNCKH ar = null;
        while(rs.next()){
            ar = new TenNCKH(rs.getString("NCKHID"), 
                    rs.getString("LoaiNCID"),
                    rs.getString("HeID"),
                    rs.getString("CapID"),
                    rs.getString("TenNCKH"),
                    rs.getString("ThoiGian"),
                    rs.getString("KhaNangUD"),
                    rs.getFloat("KinhPhi"),
                    rs.getInt("Nam"),
                    rs.getDate("NgayDK"),
                    rs.getInt("DuocCN"),
                    rs.getDate("NgayCN"),
                    rs.getString("SoQD"),
                    rs.getInt("CoDeTai"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListTenNCKH()throws Exception{
        String sql="SELECT * FROM KHKT.TENNCKH ORDER BY NCKHID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getThongKeKhoa(int nam, int duocCN)throws Exception{
        String sql="CALL KHKT.TKKHOANCKH (?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, nam);
        ps.setInt(2, duocCN);
        ResultSet rs;
        rs = ps.executeQuery();
        return rs;
    }    
    public ResultSet getListNCKH(int nam, String loaiNCID, String capID, String heID, String maNV, String maKP) throws SQLException{
        String sql = "CALL KHKT.LISTNCKH (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setInt(1, nam);
        ps.setString(2, loaiNCID);
        ps.setString(3, capID);
        ps.setString(4, heID);
        ps.setString(5, maNV);
        ps.setString(6, maKP);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public TenNCKH getTenNCKH(String nckhID) throws SQLException{
        TenNCKH tenNCKH;
        String sql = "SELECT * FROM KHKT.TENNCKH WHERE NCKHID = '" + nckhID + "'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        rs.next();
        tenNCKH = new TenNCKH(rs.getString("NCKHID"), 
                rs.getString("LoaiNCID"), 
                rs.getString("HeID"), 
                rs.getString("CapID"), 
                rs.getString("TenNCKH"), 
                rs.getString("ThoiGian"), 
                rs.getString("KhaNangUD"), 
                rs.getFloat("KinhPhi"), 
                rs.getInt("Nam"), 
                rs.getDate("NgayDK"), 
                rs.getInt("DuocCN"), 
                rs.getDate("NgayCN"), 
                rs.getString("SoQD"), 
                rs.getInt("CoDeTai"));
        return tenNCKH;
    }    
    public void deleteTenNCKH(String nckhID){
        String sql = "DELETE KHKT.TENNCKH WHERE NCKHID = '" + nckhID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexTenNCKH(ArrayList<TenNCKH> lst, String nckhID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getNckhID().equals(nckhID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getNckhID().compareTo(nckhID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameTenNCKH(ArrayList<TenNCKH> lst, String nckhID){
        int i;
        i = getIndexTenNCKH(lst, nckhID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenNCKH();
    }
    
    public String saveTenNCKH(TenNCKH ar)throws Exception{
        String sql="CALL KHKT.SAVETENNCKH(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, ar.getNckhID());
        cs.setString(2, ar.getLoaiNCID());
        cs.setString(3, ar.getHeID());
        cs.setString(4, ar.getCapID());
        cs.setString(5, ar.getTenNCKH());
        cs.setString(6, ar.getThoiGian());
        cs.setString(7, ar.getKhaNangUD());
        cs.setFloat(8, ar.getKinhPhi());
        cs.setInt(9, ar.getNam());
        cs.setDate(10, (Date) ar.getNgayDK());
        cs.setInt(11, ar.getDuocCN());
        cs.registerOutParameter(1, java.sql.Types.VARCHAR); 
        cs.executeUpdate();    
        String oParam = cs.getString(1);
        return oParam;
    }     
    public void congNhanNCKH(String nckhID, int duocCN, Date ngayQD, String soQD) throws SQLException{
        String sql="CALL KHKT.CONGNHANNCKH(?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, nckhID);
        ps.setInt(2, duocCN);
        ps.setDate(3, ngayQD);
        ps.setString(4, soQD);
        ps.executeUpdate();
    }
    public void updateNop(String nckhID, int nop){
        String sql = "UPDATE KHKT.TENNCKH SET CODETAI = " + nop + " WHERE NCKHID = '" + nckhID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
}
