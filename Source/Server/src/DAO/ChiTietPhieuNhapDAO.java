/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.ChiTietPhieuNhapDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class ChiTietPhieuNhapDAO {
    ConnectDB database = new ConnectDB();
    public String themDT(ChiTietPhieuNhapDTO ctpn)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO chitietpn(Soluongnhap,DonGia,MaSP,MaPN) values(?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,ctpn.getSoLuongNhap());
            pstmt.setDouble(2,ctpn.getDonGia());
            pstmt.setString(3,ctpn.getMaSP());
            pstmt.setString(4,ctpn.getMaPN());
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
