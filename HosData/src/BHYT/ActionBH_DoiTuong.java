/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BHYT;

import DataDB2.DataUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionBH_DoiTuong {
    public ArrayList<BH_DoiTuong>getAllBH_DoiTuong()throws Exception{
        ArrayList<BH_DoiTuong> lst=new ArrayList<BH_DoiTuong>();
        String sql="SELECT * FROM HETHONG.BH_DOITUONG ORDER BY MADT";
        ResultSet rs= DataUtil.executeQuery(sql);
        BH_DoiTuong dt = null;
        while(rs.next()){
            dt = new BH_DoiTuong(rs.getString("MaDT"), rs.getString("TenDoiTuong"), rs.getInt("Nhom"));
            lst.add(dt);
        }
        return lst;
    }
    public void deleteBH_DoiTuong(String maDT){
        String sql = "DELETE HETHONG.BH_DOITUONG WHERE MADT = '" + maDT + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexBH_DoiTuong(ArrayList<BH_DoiTuong> lst, String maDT){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaDT().equals(maDT)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaDT().compareTo(maDT) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameBH_DoiTuong(ArrayList<BH_DoiTuong> lst, String maDT){
        int i;
        i = getIndexBH_DoiTuong(lst, maDT);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenDoiTuong();
    }
    public void saveBH_DoiTuong(BH_DoiTuong doiTuong){
        
    }        
}
