/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class PHIEUNHAP {
    private int mapn;
    private int manv;
    private int gianhap;
    private int soluong;
    private int masp;
    
    public PHIEUNHAP(int mapn,int manv,int gianhap,int soluong,int masp)
    {
        this.mapn=mapn;
        this.manv=manv;
        this.gianhap=gianhap;
        this.soluong=soluong;
        this.masp=masp;
    }
    
    public int getMapn()
    {
        return mapn;
    }
    public void setMapn(int mapn)
    {
        this.mapn=mapn;
    }
    
    public int getManv()
    {
        return manv;
    }
    public void setManv(int manv)
    {
        this.manv=manv;
    }
    
    public int getGianhap()
    {
        return gianhap;
    }
    public void setGianhap(int gianhap)
    {
        this.gianhap=gianhap;
    }
    
    public int getSoluong()
    {
        return soluong;
    }
    public void setSoluong(int soluong)
    {
        this.soluong=soluong;
    }
    
    public int getMasp()
    {
        return masp;
    }
    public void setMasp(int masp)
    {
        this.masp=masp;
    }
}
