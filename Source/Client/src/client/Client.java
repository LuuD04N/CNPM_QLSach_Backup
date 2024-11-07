/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Client.ClientListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class Client {
    private static String url;
    private static final int PORT = 8000;
    public Socket socket;
    ClientListener client;
    public Client()
    {
        configIP config = new configIP();
        url=config.ip;
         
        try {
            socket = new Socket(url,PORT);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ket noi thanh cong");
    }
    
    public void dongcong()
    {
        OutputStream output;
        try {
            output = socket.getOutputStream();
            JSONObject json = new JSONObject();
            json.put("yeucau","dongcong");
            output.write((json.toString()).getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void startClient()
    {
        try{
            
            //lien tuc doc du lieu tu server
            client = new ClientListener(socket);
            new Thread(client).start();
            //lien tuc ghi du lieu
            OutputStream output = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true)
            {
                String message = sc.nextLine();
                output.write(message.getBytes());
                output.flush();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //ham xu li yeu cau xoa doi tuong
    public String xoaDT(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        switch(yeucau){
            case "DELETETG":
                return guiXoaTG(data);
            case "DELETENXB":
                return guiXoaNXB(data);
            case "DELETETL":
                return guiXoaTL(data);
            case "DELETENV":
                return guiXoaNV(data);
        }
        return "";
    }
    
    //ham gui yeu cau xoa doi tuong tac gia qua server
    private String guiXoaTG(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaDT",json.getString("MaDT"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong nxb qua server
    private String guiXoaNXB(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNXB",json.getString("MaNXB"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }  
    
    //ham gui yeu cau xoa doi tuong nxb qua server
    private String guiXoaTL(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTL",json.getString("MaTL"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham xoa nhan vien
    private String guiXoaNV(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method", yeucau);
            json.put("MaNV", json.getString("MaNV"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        }
        catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    //ham xu li yeu cau sua doi tuong
    public String suaDT(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        switch(yeucau){
            case "UPDATETG":
                return guiSuaTG(data);
            case "UPDATENXB":
                return guiSuaNXB(data);
            case "UPDATETL":
                return guiSuaTL(data);
            case "UPDATETK":
                return guiSuaTK(data);
            case "UPDATENV":
                return guiSuaNV(data);
        }
        return "";
    }
    
    
    //ham gui yeu cau sua doi tuong tac gia toi server
    private String guiSuaTG(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTG",json.getString("MaTG"));
             json.put("Hovaten",json.getString("Hovaten"));
             json.put("ButDanh",json.getString("ButDanh"));
             json.put("GioiTinh", json.getString("GioiTinh"));
             json.put("QuocTich",json.getString("QuocTich"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong nxb toi server
    private String guiSuaNXB(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNXB",json.getString("MaNXB"));
             json.put("TenNXB",json.getString("TenNXB"));
             json.put("Diachi",json.getString("Diachi"));
             json.put("Sodienthoai",json.getString("Sodienthoai"));
             json.put("Email",json.getString("Email"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong nxb toi server
    private String guiSuaTL(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTL",json.getString("MaTL"));
             json.put("TenTL",json.getString("TenTL"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
     private String guiSuaTK(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTK",json.getString("MaTK"));
             json.put("TenTK",json.getString("TenTK"));
             json.put("MatkhauTK",json.getString("MatkhauTK"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
     
     private String guiSuaNV(String data)
     {
         JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNV",json.getString("MaNV"));
             json.put("Hovaten",json.getString("Hovaten"));
             json.put("NgaySinh", json.getString("NgaySinh"));
             json.put("GioiTinh", json.getString("GioiTinh"));
             json.put("Sodienthoai", json.getString("Sodienthoai"));
             json.put("Email", json.getString("Email"));
             json.put("DiaChi", json.getString("DiaChi"));
             json.put("MaTK",json.getString("MaTK"));
             json.put("MaVT", json.getString("MaVT"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
     }
    
//ham xu li yeu cau them doi tuong
   public String themDT(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       switch (yeucau){
            case "PUTTG":
               guiThemTG(data);
               return "thanhcong";
            case "PUTNXB":
                guiThemNXB(data);
                return "thanhcong";
            case "PUTTL":
                guiThemTL(data);
                return "thanhcong";
            case "PUTNV":
                guiThemNV(data);
                return "thanhcong";
                
       }
       return "";
   }
   
   //gui yeu cau them doi tuong tac gia toi server
   public String guiThemTG(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaTG",json.getString("MaTG"));
            json.put("Hovaten",json.getString("Hovaten"));
            json.put("ButDanh",json.getString("ButDanh"));
            json.put("GioiTinh", json.getString("GioiTinh"));
            json.put("QuocTich",json.getString("QuocTich"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
      //gui yeu cau them doi tuong nxb toi server
   public String guiThemNXB(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaNXB",json.getString("MaNXB"));
            json.put("TenNXB",json.getString("TenNXB"));
            json.put("Diachi",json.getString("Diachi"));
            json.put("Sodienthoai", json.getString("Sodienthoai"));
            json.put("Email",json.getString("Email"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
      //gui yeu cau them doi tuong the loai toi server
   public String guiThemTL(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaTL",json.getString("MaTL"));
            json.put("TenTL",json.getString("TenTL"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String guiThemNV(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaNV",json.getString("MaNV"));
            json.put("Hovaten",json.getString("Hovaten"));
            json.put("NgaySinh", json.getString("NgaySinh"));
            json.put("GioiTinh", json.getString("GioiTinh"));
            json.put("Sodienthoai", json.getString("Sodienthoai"));
            json.put("Email", json.getString("Email"));
            json.put("DiaChi", json.getString("DiaChi"));
            json.put("MaTK",json.getString("MaTK"));
            json.put("MaVT", json.getString("MaVT"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //dang nhap
   public String dangNhap(String taikhoan, String matkhau)
   {
          
      
            
            try {
                ClientListener client = new ClientListener(socket);
                Thread thread = new Thread(client);
                JSONObject json = new JSONObject();
                json.put("method","LOGIN");
                json.put("taikhoan",taikhoan);
                json.put("matkhau",matkhau);
                OutputStream output = socket.getOutputStream();
                output.write((json.toString()).getBytes());
                output.flush();
                thread.start();
                thread.join();
                return client.result;
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       return "";
   }
   
   public String getNhanVien(String MaTK)
   {
        try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method","GETNV");
            json.put("MaTK",MaTK);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String getVaiTro(String MaVT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method","GETVT");
            json.put("MaVT",MaVT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //thuc thi yeu cau lay danh sach
   public String yeucau(String yeucau)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui yeu cau lay danh sach
   public String getList(String yeucau)
   {
       switch (yeucau){
            case "ListTacGia":
                return yeucau("ListTacGia");
            case "ListNhaXuatBan":
                return yeucau("ListNhaXuatBan");
            case "ListTheLoai":
                return yeucau("ListTheLoai");
            case "ListTaiKhoan":
                return yeucau("ListTaiKhoan");
            case "ListNhanVien":
                return yeucau("ListNhanVien");
       }
       return "";
   }
   
   
   //lay mot doi tuong
   public String getDoiTuong(String doituong,String maDT)
   {
      switch(doituong){
            case "TacGia":
                return xuLiGetDoiTuong("TacGia", maDT);
            case "NhaXuatBan":
                return xuLiGetNXB("NhaXuatBan", maDT);
            case "TheLoai":
                return xuLiGetTheLoai("TheLoai", maDT);
            case "TaiKhoan":
                return xuLiGetTK("TaiKhoan", maDT);
              
      }
       return "";
       
   }
   
   //ham chuyen yeu cau lay du lieu sang server
   public String xuLiGetDoiTuong(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTG",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String xuLiGetNXB(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaNXB",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }

   public String xuLiGetTheLoai(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTL",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
      public String xuLiGetTK(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTK",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
      
      public String xuLiGetNV(String yeucau, String maDT)
      {
          try {
              ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaNV",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
          }
          catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
          return "";
      }
}
 
