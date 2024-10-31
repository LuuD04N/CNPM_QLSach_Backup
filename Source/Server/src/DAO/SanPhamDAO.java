/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.SanPhamDTO;
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
public class SanPhamDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<SanPhamDTO> getList()
    {
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        java.sql.Connection conn;
        conn = database.connect();
        String query="select * from sanpham";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
                String MaSP = rs.getString("MaSp");
                String tenSP = rs.getString("TenSP");
                int soTrang = rs.getInt("SoTrang");
                String ngonNgu = rs.getString("NgonNgu");
                Double giaBia = rs.getDouble("GiaBia");
                int soLuong = rs.getInt("SoLuong");
                Double giaNhap = rs.getDouble("GiaNhap");
                String maTG = rs.getString("MaTG");
                int trangThai = rs.getInt("TrangThai");
                list.add(new SanPhamDTO(MaSP,  tenSP,  soTrang,  ngonNgu,  giaBia, null, soLuong, giaNhap, maTG,trangThai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
