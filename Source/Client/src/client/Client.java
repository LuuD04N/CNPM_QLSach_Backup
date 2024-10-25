/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

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
}
