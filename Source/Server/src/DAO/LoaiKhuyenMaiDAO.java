/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.LoaiKhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class LoaiKhuyenMaiDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<LoaiKhuyenMaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<LoaiKhuyenMaiDTO> list = new ArrayList<LoaiKhuyenMaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from loaikhuyenmai";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaLoaiKM = rs.getString("MaLoaiKM");
                    String TenLoaiKM = rs.getString("TenLoaiKM");
                    int PhanTramGiam = rs.getInt("PhanTramGiam");
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new LoaiKhuyenMaiDTO(MaLoaiKM,TenLoaiKM,PhanTramGiam,Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}
