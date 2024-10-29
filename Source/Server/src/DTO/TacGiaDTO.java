/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class TacGiaDTO {
    private String MaTG;        // Mã Tác Giả (Varchar)
    private String hoVaTen;     // Họ và tên (Nvarchar)
    private String butDanh;     // Bút danh (Nvarchar)
    private String gioiTinh;    // Giới tính (Nvarchar)
    private String quocTich;    // Quốc tịch (Nvarchar)

    // Constructor
    public TacGiaDTO(String MaTG, String hoVaTen, String butDanh, String gioiTinh, String quocTich) {
        this.MaTG = MaTG;
        this.hoVaTen = hoVaTen;
        this.butDanh = butDanh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
    }

    // Getters và Setters
    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String maTG) {
        this.MaTG = maTG;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getButDanh() {
        return butDanh;
    }

    public void setButDanh(String butDanh) {
        this.butDanh = butDanh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "TacGiaDTO{" +
               "maTG='" + MaTG + '\'' +
               ", hoVaTen='" + hoVaTen + '\'' +
               ", butDanh='" + butDanh + '\'' +
               ", gioiTinh='" + gioiTinh + '\'' +
               ", quocTich='" + quocTich + '\'' +
               '}';
    }
}

