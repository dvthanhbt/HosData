/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhoaPhong;

import DataDB2.DataUtil;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionKhoaPhong {
    public ArrayList<KhoaPhong>getAllKhoaPhong(String loaiKPID)throws Exception{
        ArrayList<KhoaPhong> lst = new ArrayList<KhoaPhong>();
        String sql="SELECT * FROM HETHONG.KHOAPHONG WHERE LOAIKPID = '" + loaiKPID + "' ORDER BY MAKP";
        ResultSet rs= DataUtil.executeQuery(sql);
        KhoaPhong kp = null;
        while(rs.next()){
            kp = new KhoaPhong(rs.getString("MaKP"), rs.getString("LoaiKPID"), rs.getString("TenKP"), rs.getString("KyHieu"), rs.getString("MaSPSD"), rs.getInt("DichVu"), rs.getInt("HieuLuc"));
            lst.add(kp);
        }
        return lst;
    }    

    public ArrayList<KhoaPhong>getAllKhoaPhong()throws Exception{
        ArrayList<KhoaPhong> lst = new ArrayList<KhoaPhong>();
        String sql="SELECT * FROM HETHONG.KHOAPHONG ORDER BY MAKP";
        ResultSet rs= DataUtil.executeQuery(sql);
        KhoaPhong kp = null;
        while(rs.next()){
            kp = new KhoaPhong(rs.getString("MaKP"), rs.getString("LoaiKPID"), rs.getString("TenKP"), rs.getString("KyHieu"), rs.getString("MaSPSD"), rs.getInt("DichVu"), rs.getInt("HieuLuc"));
            lst.add(kp);
        }
        return lst;
    }    
    public ResultSet getKhoaPhong(String loaiKPID){
        String sql = "SELECT * FROM HETHONG.KHOAPHONG WHERE LOAIKPID = '" + loaiKPID + "' ORDER BY MAKP";
        ResultSet rs = DataUtil.executeQuery(sql);
        return rs;
    }
    public void deleteKhoaPhong(String maKP){
        String sql = "DELETE HETHONG.KHOAPHONG WHERE MAKP = '" + maKP + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexKhoaPhong(ArrayList<KhoaPhong> lst, String maKP){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaKP().equals(maKP)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaKP().compareTo(maKP) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameKhoaPhong(ArrayList<KhoaPhong> lst, String maKP){
        int i;
        i = getIndexKhoaPhong(lst, maKP);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenKP();
    }
    
    public void saveKhoaPhong(KhoaPhong kp)throws Exception{
        String sql="CALL HETHONG.SAVEKHOAPHONG(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, kp.getMaKP());
        ps.setString(2, kp.getLoaiKPID());
        ps.setString(3, kp.getTenKP());
        ps.setString(4, kp.getKyHieu());
        ps.setInt(5, kp.getDichVu());
        ps.setInt(6, kp.getHieuLuc());
        ps.execute();        
    }
}
