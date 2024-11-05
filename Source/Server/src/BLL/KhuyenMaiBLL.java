/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.KhuyenMaiDAO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class KhuyenMaiBLL {
       //lay danh sach tac gia
    public String getList()
    {
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
//        JSONArray jsonArray = new JSONArray(tgDAO.getList());
        json.put("list", kmDAO.getList());
        return json.toString();
    }
    
    
}
