/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author PC
 */
public class NhanVienDAO {
    ConnectDB database = new ConnectDB();
    //lay toan bo danh sach nhan vien
    public ArrayList<NhanVienDTO> getAll()
    {
        java.sql.Connection conn;
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        try {
                conn = database.connect();
                String query = "select * from nhanvien";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaNV = rs.getString("MaNV");
                    String Hovaten = rs.getString("Hovaten");
                    Date NgaySinh = rs.getDate("NgaySinh");
                    String Gioitinh = rs.getString("Gioitinh");
                    String Sodienthoai = rs.getString("Sodienthoai");
                    String Email = rs.getString("Email");
                    String Diachi = rs.getString("Diachi");
                    String MaTK = rs.getString("MaTK");
                    String MaVT = rs.getString("MaVT");
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new NhanVienDTO(MaNV,Hovaten,NgaySinh,Gioitinh,Sodienthoai,Email,Diachi,MaTK,MaVT,Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}
