/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class SANPHAM {
    private int masp;
   private String tensp;
   private int mapn;
   private int giaban;
   public SANPHAM(int masp,String tensp,int mapn,int giaban)
   {
       this.masp=masp;
       this.tensp=tensp;
       this.mapn=mapn;
       this.giaban=giaban;
   }
   
   public int getMasp()
    {
        return masp;
    }
    public void setMasp(int masp)
    {
        this.masp=masp;
    }
    
    public String getTensp()
    {
        return tensp;
    }
    
    public void setTensp(String tensp)
    {
        this.tensp=tensp;
    }
    
    public int getMapn()
    {
        return mapn;
    }
    public void setMapn(int mapn)
    {
        this.mapn=mapn;
    }
    
    public int getGiaban()
    {
        return giaban;
    }
    public void setGiaban(int giaban)
    {
        this.giaban=giaban;
    }
}
