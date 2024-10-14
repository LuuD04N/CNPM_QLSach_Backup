/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class TAIKHOAN {
    private int manv;
    private String tentk;
    private String matkhau;
    public TAIKHOAN()
    {
        manv=0;
        tentk="";
        matkhau="";
    }
    
    public TAIKHOAN(int manv,String tentk,String matkhau)
    {
        this.manv=manv;
        this.tentk=tentk;
        this.matkhau=matkhau;
    }
    
    public int getManv()
    {
        return manv;
    }
    
    public void setManv(int manv)
    {
        this.manv=manv;
    }
    
    public String getTentk()
    {
        return tentk;
    }
    
    public void setTentk(String tentk)
    {
        this.tentk=tentk;
    }
    
    public String getMatkhau()
    {
        return matkhau;
    }
    
    public void setMatkhau(String matkhau)
    {
        this.matkhau=matkhau;
    }
}
