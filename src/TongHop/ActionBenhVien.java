/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TongHop;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionBenhVien {
    public ArrayList<BenhVien>getAllBenhVien()throws Exception{
        ArrayList<BenhVien> lst = new ArrayList<BenhVien>();
        String sql="SELECT * FROM HETHONG.BENHVIEN ORDER BY BENHVIENID";
        ResultSet rs= DataUtil.executeQuery(sql);
        BenhVien bv = null;
        while(rs.next()){
            bv = new BenhVien(rs.getString("BenhVienID"), rs.getString("TenBenhVien"), rs.getString("DiaChi"), rs.getString("DienThoai"), rs.getInt("Hang"), rs.getString("MaTT"));
            lst.add(bv);
        }
        return lst;
    }    
    public ResultSet getListBenhVien()throws Exception{
        String sql="SELECT * FROM HETHONG.BENHVIEN ORDER BY BENHVIENID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListBenhVien(String value)throws Exception{
        String sql="SELECT BENHVIENID, TENBENHVIEN, DIENTHOAI, HANG, TENTT ";
        sql += "FROM HETHONG.BENHVIEN BV JOIN HETHONG.TINHTHANH TT ON BV.MATT = TT.MATT ";
        sql += "WHERE UCASE(TENBENHVIEN) LIKE '%" + value.toUpperCase().trim() + "%' OR UCASE(TENTT) LIKE '%" + value.toUpperCase().trim() + "%'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        return rs;
    }    
    public String getTenBenhVien(String benhVienID) throws SQLException{
        String sql="SELECT TenBenhVien FROM HETHONG.BENHVIEN WHERE UCASE(BENHVIENID) = '" + benhVienID.toUpperCase().trim() + "'";
        ResultSet rs = DataUtil.executeQuery(sql);
        rs.next();
        return rs.getString("TenBenhVien");
    }
    public void deleteBenhVien(String benhVienID){
        String sql = "DELETE HETHONG.BENHVIEN WHERE BENHVIENID = '" + benhVienID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexBenhVien(ArrayList<BenhVien> lst, String benhVienID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getBenhVienID().equals(benhVienID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getBenhVienID().compareTo(benhVienID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameBenhVien(ArrayList<BenhVien> lst, String doiTuongID){
        int i;
        i = getIndexBenhVien(lst, doiTuongID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenBenhVien();
    }
    
    public void saveBenhVien(BenhVien bv)throws Exception{
        String sql="CALL HETHONG.SAVEBENHVIEN(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, bv.getBenhVienID());
        ps.setString(2, bv.getTenBenhVien());
        ps.setString(3, bv.getDiaChi());
        ps.setString(4, bv.getDienThoai());
        ps.setInt(5, bv.getHang());
        ps.setString(6, bv.getMaTT());
        ps.executeUpdate();        
    }        
}
