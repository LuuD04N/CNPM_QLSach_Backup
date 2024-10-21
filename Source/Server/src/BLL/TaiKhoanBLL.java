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
    public boolean login(String data)
    {
        JSONObject json = new JSONObject(data);
        String taikhoan = json.getString("taikhoan");
        String matkhau = json.getString("matkhau");
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        for(TaiKhoanDTO x : tkDAO.getAll())
        {
            System.out.println(x);
            if(x.getTenTK().equals(taikhoan) && x.getMatKhauTK().equals(matkhau))
            {
                return true;
            }
        }
        return false;
    }
}
