/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChuyenVien;

import DataDB2.DataUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bvndc
 */
public class ActionLyDo {
   public ArrayList<LyDo>getAllLyDo()throws Exception{
        ArrayList<LyDo> lst=new ArrayList<LyDo>();
        String sql="SELECT * FROM CHUYENVIEN.LYDO ORDER BY LYDOID";
        ResultSet rs= DataUtil.executeQuery(sql);
        LyDo ld = null;
        while(rs.next()){
            ld = new LyDo(rs.getString("LyDoID"), rs.getString("TenLyDo"));
            lst.add(ld);
        }
        return lst;
    }
    public void deleteLyDo(String lyDoID){
        String sql = "DELETE CHUYENVIEN.LYDO WHERE LYDOID = '" + lyDoID + "'";
        Boolean executeNoneQuery = DataUtil.executeNoneQuery(sql);
    }
    public int getIndexLyDo(ArrayList<LyDo> lst, String lyDoID){
        int pos;
        pos = 0;
        int mid;
        int left = 0;
        int righ = lst.size() - 1;
        while (left <= righ){
            mid = (left + righ)/2;
            if (lst.get(mid).getLyDoID().equals(lyDoID)){
                pos = mid;
                break;
            }
            else if (lst.get(mid).getLyDoID().compareTo(lyDoID) < 0)
                left = mid + 1;
            else
                righ = mid - 1;
                
        }
        if (left > righ)
            return -1;
        else
            return pos;
    }   
    public String getNameLyDo(ArrayList<LyDo> lst, String lyDoID){
        int i;
        i = getIndexLyDo(lst, lyDoID);   
        if (i == -1)
            return "";
        else
            return lst.get(i).getTenLyDo();
    }
    public void saveLyDo(LyDo lyDo){
        
    }        
}
