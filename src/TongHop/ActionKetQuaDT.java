/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TongHop;

import DataDB2.DataUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionKetQuaDT {
    public ArrayList<KetQuaDT>getAllKetQuaDT()throws Exception{
        ArrayList<KetQuaDT> lst = new ArrayList<KetQuaDT>();
        String sql="SELECT * FROM HETHONG.KETQUADT ORDER BY KETQUAID";
        ResultSet rs= DataUtil.executeQuery(sql);
        KetQuaDT dt = null;
        while(rs.next()){
            dt = new KetQuaDT(rs.getString("KetQuaID"), rs.getString("TenKetQua"));
            lst.add(dt);
        }
        return lst;
    }    
    public ResultSet getListKetQuaDT()throws Exception{
        String sql="SELECT * FROM HETHONG.KETQUADT ORDER BY KETQUAID";
        ResultSet rs= DataUtil.executeQuery(sql);
        return rs;
    }    
    
    public void deleteKetQuaDT(String ketQuaID){
        String sql = "DELETE HETHONG.KETQUADT WHERE KETQUAID = '" + ketQuaID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    
    public int getIndexKetQuaDT(ArrayList<KetQuaDT> lst, String ketQuaID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getKetQuaID().equals(ketQuaID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getKetQuaID().compareTo(ketQuaID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }  
    
    public String getNameKetQuaDT(ArrayList<KetQuaDT> lst, String ketQuaID){
        int i;
        i = getIndexKetQuaDT(lst, ketQuaID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenKetQua();
    }
    
    public void saveKetQuaDT(KetQuaDT dt)throws Exception{
        String sql="CALL HETHONG.SAVEKETQUADT(?, ?)";
        PreparedStatement ps = DataUtil.getConnect().prepareStatement(sql);
        ps.setString(1, dt.getKetQuaID());
        ps.setString(2, dt.getTenKetQua());
        ps.executeUpdate();        
    }        
}
