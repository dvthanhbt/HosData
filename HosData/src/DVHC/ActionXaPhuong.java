/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DVHC;

import DataDB2.DataUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionXaPhuong {
    public ArrayList<XaPhuong>getAllXaPhuong(String maQH)throws Exception{
        ArrayList<XaPhuong> lst=new ArrayList<XaPhuong>();
        String sql="SELECT * FROM HETHONG.XAPHUONG WHERE MAQH = '" + maQH + "'";
        ResultSet rs;
        rs = DataUtil.executeQuery(sql);
        XaPhuong xp = null;
        while(rs.next()){
            xp = new XaPhuong(rs.getString("MaXP"), rs.getString("MaQH"), rs.getString("TenXP"), rs.getString("TenTat"));
            lst.add(xp);
        }        
        return lst;
    }
    public void deleteXaPhuong(String maXP){
        String sql = "DELETE HETHONG.XAPHUONG WHERE MAXP = '" + maXP + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }

    public int getIndexXaPhuong(ArrayList<XaPhuong> lst, String maXP){
       int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getMaXP().equals(maXP)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getMaXP().compareTo(maXP) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }
    public String getNameXaPhuong(ArrayList<XaPhuong> lst, String maXP){
        int i;
        i = getIndexXaPhuong(lst, maXP);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenXP();
    }    
}
