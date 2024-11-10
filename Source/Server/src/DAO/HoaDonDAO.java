package DAO;

import ConnectDB.ConnectDB;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class HoaDonDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<HoaDonDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        try {
            conn = database.connect();
            String query = "select * from hoadon";
            Statement stm = null;
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) 
            {
                String MaHD = rs.getString("MaHD");
                Date NgayLapHD = rs.getDate("Ngaylaphoadon");
                Double ThanhTien = rs.getDouble("ThanhTien");
                int TrangThai = rs.getInt("Trangthai");
                String MaTK = rs.getString("MaTK");
                list.add(new HoaDonDTO(MaHD, NgayLapHD, ThanhTien, TrangThai, MaTK));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
