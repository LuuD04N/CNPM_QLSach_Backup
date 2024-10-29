/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class NhanVienBLL {
    //lay nhan vien bang ma tai khoan
    public String getNV(String data)
    {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        NhanVienDAO nhanvien = new NhanVienDAO();
        for(NhanVienDTO x : nhanvien.getAll())
        {
            
            
            if(x.getMaTK().equals(json.getString("MaTK")))
            {
                json1.put("Trangthai","true");
                json1.put("MaNV",x.getMaNV());
                json1.put("Hovaten",x.getHoVaTen());
                json1.put("NgaySinh",x.getNgaySinh());
                json1.put("Gioitinh", x.getGioiTinh());
                json1.put("Sodienthoai", x.getSoDienThoai());
                json1.put("Email", x.getEmail());
                json1.put("Diachi",x.getDiaChi());
                json1.put("MaTK", x.getMaTK());
                json1.put("MaVT", x.getMaVT());
                return json1.toString();
            }
        }
        json1.put("Trangthai","false");
        return json1.toString();
    }
}
