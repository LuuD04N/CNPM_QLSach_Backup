/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import BLL.KhuyenMaiBLL;
import BLL.LoaiKhuyenMaiBLL;
import BLL.NhanVienBLL;
import BLL.SanPhamBLL;
import BLL.TacGiaBLL;
import BLL.TaiKhoanBLL;
import BLL.VaiTroBLL;
import BLL.NhaXuatBanBLL;
import BLL.SachTheLoaiBLL;
import BLL.TheLoaiBLL;
import DTO.LoaiKhuyenMaiDTO;
import DTO.TacGiaDTO;
import DTO.NhaXuatBanDTO;
import DTO.SachTheLoaiDTO;
import DTO.SanPhamDTO;
import DTO.TheLoaiDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
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
            
            byte[] buffer = new byte[1024*1024];
            int bytesRead;
            StringBuilder resultBuilder = new StringBuilder();
            while((bytesRead= input.read(buffer)) != -1)
            {
                String message = new String(buffer,0,bytesRead);
                System.out.println(message);
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
        System.out.println(dieukien);
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
                   
                    break;
            // Xu li nha xuat ban
            case "ListNhaXuatBan":
                    NhaXuatBanBLL nxbBLL = new NhaXuatBanBLL();
                    sendMessage(String.valueOf(nxbBLL.getList()));
                    
                    break;
            case "NhaXuatBan":
                //lay doi tuong de xem thong tin nxb
                    NhaXuatBanBLL nxbBLL1 = new NhaXuatBanBLL();
                    String MaNXB = json.getString("MaNXB");
                    sendMessage(String.valueOf(nxbBLL1.getNhaXuatBan(MaNXB)));
                   
                    break;
            case "PUTNXB":
                //them doi tuong nxb
                    NhaXuatBanBLL nxbBLL2 = new NhaXuatBanBLL();
                    NhaXuatBanDTO nxbDTO = new NhaXuatBanDTO(json.getString("MaNXB"), json.getString("TenNXB"), json.getString("Diachi"), json.getString("Sodienthoai"), json.getString("Email"), 1);
                    sendMessage(String.valueOf(nxbBLL2.themNXB(nxbDTO))); 
                   
                    break;
            case "UPDATENXB":
                //sua doi tuong nxb
                    NhaXuatBanBLL nxbBLL3 = new NhaXuatBanBLL();
                    NhaXuatBanDTO nxbDTO1 = new NhaXuatBanDTO(json.getString("MaNXB"), json.getString("TenNXB"), json.getString("Diachi"), json.getString("Sodienthoai"), json.getString("Email"), 1);
                    sendMessage(String.valueOf(nxbBLL3.suaNXB(nxbDTO1))); 
                    
                    break;
            case "DELETENXB":
                //xoa doi tuong nxb
                    NhaXuatBanBLL nxbBLL4 = new NhaXuatBanBLL();
                    String MaNXB1 = json.getString("MaNXB");
                    NhaXuatBanDTO nxbDTO3 = new NhaXuatBanDTO(MaNXB1,"","","","",0);
                    sendMessage(String.valueOf(nxbBLL4.xoaNXB(nxbDTO3)));
                    
                    break;
                    
            // Xu li the loai
            case "ListTheLoai":
                    TheLoaiBLL tlBLL = new TheLoaiBLL();
                    sendMessage(String.valueOf(tlBLL.getList()));
                    
                    break;
            case "TheLoai":
                    //lay doi tuong de xem thong tin the loai
                    TheLoaiBLL tlBLL1 = new TheLoaiBLL();
                    String MaTL = json.getString("MaTL");
                    sendMessage(String.valueOf(tlBLL1.getTheLoai(MaTL)));
                    
                    break;
            case "PUTTL":
                    //them doi tuong the loai
                    TheLoaiBLL tlBLL2 = new TheLoaiBLL();
                    TheLoaiDTO tlDTO = new TheLoaiDTO(json.getString("MaTL"), json.getString("TenTL"), 1);
                    sendMessage(String.valueOf(tlBLL2.themTheLoai(tlDTO)));
                    
                    break;
            case "UPDATETL":
                    //sua doi tuong the loai
                    TheLoaiBLL tlBLL3 = new TheLoaiBLL();
                    TheLoaiDTO tlDTO1 = new TheLoaiDTO(json.getString("MaTL"), json.getString("TenTL"), 1);
                    sendMessage(String.valueOf(tlBLL3.suaTheLoai(tlDTO1)));
                    
                    break;
            case "DELETETL":
                    //xoa doi tuong the loai
                    TheLoaiBLL tlBLL4 = new TheLoaiBLL();
                    String MaTL1 = json.getString("MaTL");
                    TheLoaiDTO tlDTO3 = new TheLoaiDTO(MaTL1, "", 0);
                    sendMessage(String.valueOf(tlBLL4.xoaTheLoai(tlDTO3)));
                    break;
             case "ListSanPham":
                    //lay danh sach san pham
                    SanPhamBLL spBLL = new SanPhamBLL();
                    sendMessage(String.valueOf(spBLL.getList()));
                    break;
                    
             case "SanPham":
                    SanPhamBLL spBLL2 = new SanPhamBLL();
                    String MaSP = json.getString("MaSP");
                    sendMessage(String.valueOf(spBLL2.getSanPham(MaSP)));
                    
                    break;
             case "AnhBia":
                    SanPhamBLL spBLL3 = new SanPhamBLL();
                    String MaAB = json.getString("MaAB");
                    sendMessage(String.valueOf(spBLL3.getAnhBia(MaAB)));
                    break;
             case "SachTheLoai":
                    SachTheLoaiBLL stl1 = new SachTheLoaiBLL();
                    String MaSP3 = json.getString("MaSP");
                    sendMessage(String.valueOf(stl1.getSachTheLoai(new SachTheLoaiDTO(MaSP3,""))));
                    break;
             case "TenSachTheLoai":
                    SachTheLoaiBLL stl2 = new SachTheLoaiBLL();
                    String MaSP4 = json.getString("MaSP");
                    sendMessage(String.valueOf(stl2.getSachTenTheLoai(new SachTheLoaiDTO(MaSP4,""))));
                    break;
             case "PUTSP":
                     //them doi tuong san pham
                     SanPhamBLL spBLL1 = new SanPhamBLL();
                     byte[] anhBiaBytes = Base64.getDecoder().decode(json.getString("AnhBia"));
                     String base64String = Base64.getEncoder().encodeToString(anhBiaBytes);
                     SanPhamDTO sp = new SanPhamDTO(json.getString("MaSP"),json.getString("TenSP"),json.getInt("SoTrang"),json.getString("NgonNgu"),json.getDouble("GiaBia"),base64String,json.getInt("SoLuong"),json.getDouble("GiaNhap"),json.getString("MaTG"),json.getInt("Trangthai"));
                     sendMessage(String.valueOf(spBLL1.themSP(sp)));
                     break;
             case "PUTTLSP":
                    // them the loai cua san pham
                    SachTheLoaiBLL stl = new SachTheLoaiBLL();
                    String MaSP1 = json.getString("MaSP");
                    String MaTL2 = json.getString("MaTL");
                    sendMessage(String.valueOf(stl.themSTL(new SachTheLoaiDTO(MaSP1,MaTL2))));
                    break;
             case "UPDATESP":
                 //cap nhat the loai cua san pham va gia bia
                    SachTheLoaiBLL stl4 = new SachTheLoaiBLL();
                    String MaSP2 = json.getString("MaSP");
                    stl4.updateSachTheLoai(json);
                    SanPhamBLL sp4 = new SanPhamBLL();
                    sp4.suaSP(json);
                    sendMessage(String.valueOf(stl4.updateSachTheLoai(json)));
                    break;
             case "DELETESP":
                    SanPhamBLL stl5 = new SanPhamBLL ();
                    String MaSP5 = json.getString("MaSP");
                    
                    SanPhamDTO sp1 = new SanPhamDTO(json.getString("MaSP"),"",0,"",0,null,0,0,"",json.getInt("Trangthai"));
                    sendMessage(String.valueOf(stl5.xoaTheLoai(sp1)));
                    break;
              case "ListKhuyenMai":
                    //lay danh sach san pham
                    KhuyenMaiBLL kmBLL = new KhuyenMaiBLL();
                    sendMessage(String.valueOf(kmBLL.getList()));
                    break;
              case "ListLoaiKhuyenMai":
                    LoaiKhuyenMaiBLL lkmBLL = new LoaiKhuyenMaiBLL();
                    sendMessage(String.valueOf(lkmBLL.getList()));
                    break;
              case "PUTLKM":
                    LoaiKhuyenMaiBLL lkmBLL1 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM = json.getString("MaLoaiKM");
                    String TenLoaiKM = json.getString("TenLoaiKM");
                    int phantram = json.getInt("Phantram");
                    LoaiKhuyenMaiDTO lkmDTO = new LoaiKhuyenMaiDTO(MaloaiKM,TenLoaiKM,phantram,1);
                    sendMessage(String.valueOf(lkmBLL1.themLKM(lkmDTO)));
                    break;
              case "UPDATELKM":
                    LoaiKhuyenMaiBLL lkmBLL2 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM1 = json.getString("MaLoaiKM");
                    String TenLoaiKM1 = json.getString("TenLoaiKM");
                    int phantram1 = json.getInt("Phantram");
                    LoaiKhuyenMaiDTO lkmDTO1 = new LoaiKhuyenMaiDTO(MaloaiKM1,TenLoaiKM1,phantram1,1);
                    sendMessage(String.valueOf(lkmBLL2.suaLKM(lkmDTO1)));
                    break;
              case "DELETELKM":
                    LoaiKhuyenMaiBLL lkmBLL3 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM2 = json.getString("MaLoaiKM");
                    LoaiKhuyenMaiDTO lkmDTO2 = new LoaiKhuyenMaiDTO(MaloaiKM2,"",0,0);
                    sendMessage(String.valueOf(lkmBLL3.xoaLKM(lkmDTO2)));
        }
    }
}
