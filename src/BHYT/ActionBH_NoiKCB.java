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
public class ActionBH_NoiKCB {
    public ArrayList<BH_NoiKCB>getAllBH_NoiKCB()throws Exception{
        ArrayList<BH_NoiKCB> lst=new ArrayList<BH_NoiKCB>();
        String sql="SELECT * FROM HETHONG.BH_NOIKCB ORDER BY MAKCB";
        ResultSet rs= DataUtil.executeQuery(sql);
        BH_NoiKCB kcb = null;
        while(rs.next()){
            kcb = new BH_NoiKCB(rs.getString("MaKCB"), rs.getString("MaTT"), rs.getString("TenKCB"), rs.getString("DiaChi"));
            lst.add(kcb);
        }
        return lst;
    }
    public void deleteBH_NoiKCB(String maKCB){
        String sql = "DELETE HETHONG.BH_NOIKCB WHERE MADT = '" + maKCB + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexBH_NoiKCB(ArrayList<BH_NoiKCB> lst, String maKCB){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaKCB().equals(maKCB)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaKCB().compareTo(maKCB) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameBH_NoiKCB(ArrayList<BH_NoiKCB> lst, String maKCB){
        int i;
        i = getIndexBH_NoiKCB(lst, maKCB);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenKCB();
    }
    public void saveBH_NoiKCB(BH_NoiKCB noiKCB){
        
    }            
}
