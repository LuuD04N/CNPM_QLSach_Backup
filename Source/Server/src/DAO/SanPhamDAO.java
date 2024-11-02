/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.SanPhamDTO;
import DTO.TacGiaDTO;
import java.sql.PreparedStatement;
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
    
    public String themDT(SanPhamDTO sp)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO sanpham(MaSP,TenSP,SoTrang,NgonNgu,GiaBia,AnhBia,SoLuong,GiaNhap,MaTG,Trangthai) values(?,?,?,?,?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,sp.getMaSP());
            pstmt.setString(2,sp.getTenSP());
            pstmt.setInt(3,sp.getSoTrang());
            pstmt.setString(4,sp.getNgonNgu());
            pstmt.setDouble(5,sp.getGiaBia());
            pstmt.setBytes(6,sp.getAnhBia());
            pstmt.setInt(7,sp.getSoLuong());
            pstmt.setDouble(8,sp.getGiaNhap());
            pstmt.setString(9,sp.getMaTG());
            pstmt.setDouble(10,sp.getTrangThai());
            
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
