/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.TaiKhoanDTO;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class TaiKhoanDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<TaiKhoanDTO> getList()
    {
        ArrayList<TaiKhoanDTO> list = new ArrayList<TaiKhoanDTO>();
        java.sql.Connection conn;
        try {
                conn = database.connect();
                String query = "select * from taikhoan";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String maTK = rs.getString("MaTK");
                    String taikhoan = rs.getString("TenTK");
                    String matkhau = rs.getString("MatkhauTK");
                    int trangthai = rs.getInt("Trangthai");
                    list.add(new TaiKhoanDTO(maTK,taikhoan,matkhau,trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    public String themTK(TaiKhoanDTO tk)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO taikhoan(MaTK,TenTK,MatkhauTK,Trangthai) values(?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,tk.getMaTK());
            pstmt.setString(2,tk.getTenTK());
            pstmt.setString(3,tk.getMatKhauTK());
            pstmt.setInt(4,1);
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    //ham cap nhat doi tuong len csdl
    public String suaTK(TaiKhoanDTO tk)
    {
        java.sql.Connection conn;
        String query = "UPDATE taikhoan SET MaTK=?,TenTK=?,MatKhauTK=? WHERE MaTK=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,tk.getMaTK());
            pstmt.setString(2,tk.getTenTK());
            pstmt.setString(3,tk.getMatKhauTK());
//            pstmt.setString(4,tk.getQuocTich());
//            pstmt.setString(5,tk.getMaTG());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
    
    public String xoaTK(TaiKhoanDTO tg)
    {
        java.sql.Connection conn;
        String query = "UPDATE tacgia SET Trangthai=? WHERE MaTK=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,tg.getTrangThai());
            pstmt.setString(2,tg.getMaTK());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
}

    
