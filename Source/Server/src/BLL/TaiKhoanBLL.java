/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author PC
 */
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import org.json.JSONObject;
public class TaiKhoanBLL {
    public String login(String data)
    {
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject();
        String taikhoan = json.getString("taikhoan");
        String matkhau = json.getString("matkhau");
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        for(TaiKhoanDTO x : tkDAO.getAll())
        {
            
            if(x.getTenTK().equals(taikhoan) && x.getMatKhauTK().equals(matkhau))
            {
                json1.put("Trangthai","true");
                json1.put("MaTK",x.getMaTK());
                
                return json1.toString(0);
            }
        }
        json1.put("trangthai","false");
        return json1.toString(0);
    }
}
