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
public class ActionBH_Huyen {
    public ArrayList<BH_Huyen>getAllBH_Huyen(String maTT)throws Exception{
        ArrayList<BH_Huyen> lst=new ArrayList<BH_Huyen>();
        String sql="SELECT * FROM HETHONG.BH_HUYEN WHERE MATT = '" + maTT + "' ORDER BY MAHUYEN";
        ResultSet rs= DataUtil.executeQuery(sql);
        BH_Huyen qh = null;
        while(rs.next()){
            qh = new BH_Huyen(rs.getString("MaHuyen"), rs.getString("MaTT"), rs.getString("TenHuyen"));
            lst.add(qh);
        }
        return lst;
    }
    public void deleteBH_Huyen(String maHuyen){
        String sql = "DELETE HETHONG.BH_HUYEN WHERE MAHUYEN = '" + maHuyen + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexBH_Huyen(ArrayList<BH_Huyen> lst, String maHuyen){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaHuyen().equals(maHuyen)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaHuyen().compareTo(maHuyen) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameBH_Huyen(ArrayList<BH_Huyen> lst, String maHuyen){
        int i;
        i = getIndexBH_Huyen(lst, maHuyen);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenHuyen();
    }
    public void saveBH_Huyen(BH_Huyen huyen){
        
    }            
}
