/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import BLL.NhanVienBLL;
import BLL.SanPhamBLL;
import BLL.TacGiaBLL;
import BLL.TaiKhoanBLL;
import BLL.VaiTroBLL;
import DTO.TacGiaDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class ClientHandle implements Runnable{
    private Socket mysocket;
    private String id;
    private InputStream input;
    private OutputStream output;
    private server server;
    public ClientHandle(Socket mysocket,String id,server server)
    {
        this.mysocket = mysocket;
        this.id = id;
        this.server=server;
        try{
            this.input=mysocket.getInputStream();
            this.output = mysocket.getOutputStream();
        }catch(IOException e)
        {
            e.printStackTrace();
            
        }
        // Thực hiện thử kết nối lại hoặc thông báo cho người dùng
    }

    @Override
    public void run() {
        try{
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder resultBuilder = new StringBuilder();
            while((bytesRead= input.read(buffer)) != -1)
            {
                String message = new String(buffer,0,bytesRead);
                xetDK(message);
            }
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message)
    {
        
        try{
            output.write(message.getBytes());
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    //ham de xem client yeu cau gi
    public void xetDK(String data)
    {
        JSONObject json = new JSONObject(data);
        String dieukien = json.getString("method");
        switch(dieukien)
        {
            case "LOGIN":
                    //dang nhap
                    TaiKhoanBLL tkBLL = new TaiKhoanBLL();
                    System.out.println(String.valueOf(tkBLL.login(data)));
                    sendMessage(String.valueOf(tkBLL.login(data)));
                    break;
            case "GETNV":
                    //lat 1 doi tuong nhan vien
                    NhanVienBLL nvBLL = new NhanVienBLL();
                    nvBLL.getNV(data);
                    sendMessage(String.valueOf(nvBLL.getNV(data)));
                    break;
            case "GETVT":
                    //lay vai tro de hien thi thong tin
                    VaiTroBLL vtBLL = new VaiTroBLL();
                    sendMessage(String.valueOf(vtBLL.getVaiTro(data)));
                    break;
            case "ListTacGia":
                    //lay danh sach tac gia
                    TacGiaBLL tgBLL = new TacGiaBLL();
                    sendMessage(String.valueOf(tgBLL.getList()));
                    break;
            case "ListSanPham":
                    //lay danh sach san pham
                    SanPhamBLL spBLL = new SanPhamBLL();
                    sendMessage(String.valueOf(spBLL.getList()));
                    break;
            case "TacGia":
                //lay doi tuong de xem thong tin tac gia
                    TacGiaBLL tgBLL1 = new TacGiaBLL();
                    String MaTG = json.getString("MaTG");
                    sendMessage(String.valueOf(tgBLL1.getTacGia(MaTG)));
                    break;
            case "PUTTG":
                //them doi tuong tac gia
                    TacGiaBLL tgBLL2 = new TacGiaBLL();
                    TacGiaDTO tgDTO = new TacGiaDTO(json.getString("MaTG"),json.getString("Hovaten"),json.getString("ButDanh"),json.getString("GioiTinh"),json.getString("QuocTich"),1);
                    sendMessage(String.valueOf(tgBLL2.themTG(tgDTO)));
                    break;
            case "UPDATETG":
                //sau doi tuong tacgia
                    TacGiaBLL tgBLL3 = new TacGiaBLL();
                    TacGiaDTO tgDTO1 = new TacGiaDTO(json.getString("MaTG"),json.getString("Hovaten"),json.getString("ButDanh"),json.getString("GioiTinh"),json.getString("QuocTich"),1);
                    sendMessage(String.valueOf(tgBLL3.suaTG(tgDTO1)));
                    break;
            case "DELETETG":
                //xoa doi tuong tac gia
                    TacGiaBLL tgBLL4 = new TacGiaBLL();
                    String MaTG1 = json.getString("MaDT");
                    TacGiaDTO tgDTO3 = new TacGiaDTO(MaTG1,"","","","",0);
                    sendMessage(String.valueOf(tgBLL4.xoaTG(tgDTO3)));
                    
        }
    }
}
