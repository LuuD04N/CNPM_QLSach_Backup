/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import ConnectDB.ConnectDB;
import DAO.SanPhamDAO;
import DAO.TacGiaDAO;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    //lay danh sach tac gia
    public String getList()
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai","true");
        json.put("list", spDAO.getList());
        return json.toString();
    }
    
    //ham them san pham
    public String themTG(SanPhamDTO sp)
    {
        SanPhamDAO spDAO = new SanPhamDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua",spDAO.themDT(sp));
        return json.toString();
    }
}
