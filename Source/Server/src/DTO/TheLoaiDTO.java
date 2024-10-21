/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class TheLoaiDTO {
    private String maTL;     // Mã Thể Loại (Varchar)
    private String tenTL;    // Tên Thể Loại (Nvarchar)

    // Constructor
    public TheLoaiDTO(String maTL, String tenTL) {
        this.maTL = maTL;
        this.tenTL = tenTL;
    }

    // Getters và Setters
    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "TheLoaiDTO{" +
               "maTL='" + maTL + '\'' +
               ", tenTL='" + tenTL + '\'' +
               '}';
    }
}

