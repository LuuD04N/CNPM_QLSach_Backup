/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SachTheLoaiDAO;
import DAO.TheLoaiDAO;
import DTO.SachTheLoaiDTO;
import DTO.TheLoaiDTO;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class SachTheLoaiBLL {
    public String themSTL(SachTheLoaiDTO stl)
    {
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("ketqua", stlDAO.themSTL(stl));
        return json.toString();
    }
    
    //ham lay ma the loai
    public String getSachTheLoai(SachTheLoaiDTO stl)
    {
        SachTheLoaiDAO stlDAO = new SachTheLoaiDAO();
        JSONObject json = new JSONObject();
        for(SachTheLoaiDTO tl : stlDAO.getAll())
        {   
            if(stl.getMaSP().equals(tl.getMaSP()))
            {
                json.put("Trangthai", "true");
                json.put("ketqua",getTenTL(tl.getMaTL()));
            }
        }
        return json.toString();
    }
    
    //ham xu li lay ten ma the loai cua san pham
    public ArrayList<TheLoaiDTO> getTenTL(String MaTL)
    {
        ArrayList<TheLoaiDTO> list = new ArrayList<TheLoaiDTO>();
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        for(TheLoaiDTO tl : tlDAO.getList())
        {
            if(MaTL.equals(tl.getMaTL()))
            {
                list.add(tl);
            }
        }
        return list;
    }
}
