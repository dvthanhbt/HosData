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
public class ActionBH_MucHuong {
    public ArrayList<BH_MucHuong>getAllBH_MucHuong()throws Exception{
        ArrayList<BH_MucHuong> lst=new ArrayList<BH_MucHuong>();
        String sql="SELECT * FROM HETHONG.BH_MUCHUONG ORDER BY LOAI";
        ResultSet rs= DataUtil.executeQuery(sql);
        BH_MucHuong dt = null;
        while(rs.next()){
            dt = new BH_MucHuong(rs.getString("Loai"), rs.getInt("MucHuongCP"), rs.getInt("MucHuongVC"));
            lst.add(dt);
        }
        return lst;
    }
    public void deleteBH_MucHuong(String loai){
        String sql = "DELETE HETHONG.BH_MUCHUONG WHERE LOAI = '" + loai + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexBH_MucHuong(ArrayList<BH_MucHuong> lst, String loai){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLoai().equals(loai)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLoai().compareTo(loai) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public int getMucHuongCP(ArrayList<BH_MucHuong> lst, String loai){
        int i;
        i = getIndexBH_MucHuong(lst, loai);   
        if (i == -1)
            return 0;
        else
            return lst.get(i).getMucHuongCP();
    }
    public int getMucHuongVC(ArrayList<BH_MucHuong> lst, String loai){
        int i;
        i = getIndexBH_MucHuong(lst, loai);   
        if (i == -1)
            return 0;
        else
            return lst.get(i).getMucHuongVC();
    }
    public void saveBH_MucHuong(BH_MucHuong mucHuong){
        
    }           
}
