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

/**
 *
 * @author PC
 */
public class TaiKhoanDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<TaiKhoanDTO> getAll()
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
                    String matkhau = rs.getString("MatKhauTK");
                    int trangthai = rs.getInt("Trangthai");
                    list.add(new TaiKhoanDTO(maTK,taikhoan,matkhau,trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    public ArrayList<TaiKhoanDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<TaiKhoanDTO> list = new ArrayList<TaiKhoanDTO>();
        try {
                conn = database.connect();
                String query = "select * from taikhoan";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaTK = rs.getString("MaTK");
                    String tenTK = rs.getString("TenTK");
                    String matKhau = rs.getString("MatkhauTK");
                    int trangthai = rs.getInt("Trangthai");
                    list.add(new TaiKhoanDTO(MaTK, tenTK, matKhau, trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}
