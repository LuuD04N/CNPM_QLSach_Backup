/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class KhuyenMaiDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<KhuyenMaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<KhuyenMaiDTO> list = new ArrayList<KhuyenMaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from khuyenmai";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaKM = rs.getString("MaKM");
                    String TenKM = rs.getString("TenKM");
                    Date NgayBatDau = rs.getDate("NgayBatDau");
                    Date NgayKetThuc = rs.getDate("NgayKetThuc");
                    String MaLKM = rs.getString("MaLoaiKM");
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new KhuyenMaiDTO( MaKM,  TenKM,  NgayBatDau,  NgayKetThuc,  MaLKM, Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}
