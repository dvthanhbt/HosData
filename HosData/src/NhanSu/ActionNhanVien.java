/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NhanSu;

import DataDB2.DataUtil;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionNhanVien {
    public ArrayList<NhanVien>getAllNhanVien()throws Exception{
        ArrayList<NhanVien> lst = new ArrayList<NhanVien>();
        String sql="SELECT * FROM NHANSU.NHANVIEN ORDER BY MANV";
        ResultSet rs= DataUtil.executeQuery(sql);
        NhanVien ar = null;
        while(rs.next()){
            ar = new NhanVien(rs.getString("MaNV"), 
                    rs.getString("HoTen"),
                    rs.getDate("NgaySinh"),
                    rs.getInt("GioiTinh"),
                    rs.getString("QueQuan"),
                    rs.getString("ThuongTru"),
                    rs.getString("NhomMau"),
                    rs.getString("DienThoai"),
                    rs.getString("MaKP"),
                    rs.getInt("HieuLuc"));
            lst.add(ar);
        }
        return lst;
    }    
    public ResultSet getListNhanVien()throws Exception{
        String sql="SELECT NV.MANV, NV.HOTEN, NV.NGAYSINH, KP.TENKP FROM NHANSU.NHANVIEN NV JOIN HETHONG.KHOAPHONG KP ON NV.MAKP = KP.MAKP ORDER BY MANV";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    public ResultSet getListNhanVien(String value)throws Exception{
        String sql="SELECT NV.MANV, NV.HOTEN, NV.NGAYSINH, KP.TENKP ";
        sql += "FROM NHANSU.NHANVIEN NV JOIN HETHONG.KHOAPHONG KP ON NV.MAKP = KP.MAKP ";
        sql += "WHERE UCASE(NV.HOTEN) LIKE '%" + value.toUpperCase() + "%' ";
        sql += "ORDER BY NV.MANV";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteNhanVien(String maNV){
        String sql = "DELETE NHANSU.NHANVIEN WHERE MANV = '" + maNV + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexNhanVien(ArrayList<NhanVien> lst, String maNV){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaNV().equals(maNV)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaNV().compareTo(maNV) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameNhanVien(ArrayList<NhanVien> lst, String maNV){
        int i;
        i = getIndexNhanVien(lst, maNV);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getHoTen();
    }
    
    public String saveNhanVien(NhanVien ar)throws Exception{
        String sql="CALL NHANSU.SAVENHANVIEN(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        CallableStatement cs = DataUtil.getConnect().prepareCall(sql);
        cs.setString(1, ar.getMaNV());
        cs.setString(2, ar.getHoTen());
        cs.setDate(3, (Date) ar.getNgaySinh());
        cs.setInt(4, ar.getGioiTinh());
        cs.setString(5, ar.getQueQuan());
        cs.setString(6, ar.getThuongTru());
        cs.setString(7, ar.getNhomMau());
        cs.setString(8, ar.getDienThoai());
        cs.setString(9, ar.getMaKP());
        cs.setInt(10, ar.getHieuLuc());
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.executeUpdate();
        String oParam = cs.getString(1);
        return oParam;
    }            
}
