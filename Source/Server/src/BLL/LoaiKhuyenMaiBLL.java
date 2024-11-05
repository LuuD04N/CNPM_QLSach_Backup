/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.LoaiKhuyenMaiDAO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class LoaiKhuyenMaiBLL {
    //lay danh sach tac gia
    public String getList()
    {
        LoaiKhuyenMaiDAO lkmDAO = new LoaiKhuyenMaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
        json.put("list", lkmDAO.getList());
        return json.toString();
    }
}
