/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.NhanVienGUI;

import Client.Client;
import Customize.TimKiem;
import DTO.NhanVienDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class panelNhanVien extends javax.swing.JInternalFrame {

    /**
     * Creates new form panelNhanVien
     */
    private String MaDT = "0";
    private static Client client1;
    private static TimKiem timkiem = new TimKiem();
    
    public panelNhanVien(Client client) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1 = client;
        setUp();
        timkiem.setPlaceholder(timKiemField, "Tìm kiếm theo mã hoặc tên...");
        timkiem.setUpSearchListener(timKiemField, this::timKiem);
        
        SwingUtilities.invokeLater(() -> {
        jTableNV.requestFocusInWindow();
        // hoặc có thể focus vào panel chính
        // this.requestFocusInWindow();
    });
    }

    //ham lay danh sách
    private ArrayList<NhanVienDTO> getList(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListNhanVien": 
                
                    ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    System.out.println(json);;
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject nvObject = jsonArray.getJSONObject(i);
                        String MaNV = nvObject.getString("maNV");
                        String HoVaTen = nvObject.getString("hoVaTen");
                        String NgaySinh = nvObject.getString("ngaySinh");
                        String GioiTinh = nvObject.getString("gioiTinh");
                        String SoDienThoai = nvObject.getString("soDienThoai");
                        String Email = nvObject.getString("email");
                        String DiaChi = nvObject.getString("diaChi");
                        String MaTK = nvObject.getString("maTK");
                        String MaVT = nvObject.getString("maVT");
                        int Trangthai = nvObject.getInt("trangThai");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");       
            try {
                Date ngaySinh = formatter.parse(NgaySinh);
                // Thêm vào ArrayList
                //xem lai trang thai
                list.add(new NhanVienDTO(MaNV,  HoVaTen,  ngaySinh,  GioiTinh,  SoDienThoai, Email, DiaChi, MaTK, MaVT, Trangthai));
            } catch (ParseException ex) {
                Logger.getLogger(panelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    return list;
                   
        }    
        return new ArrayList<>();
    }
    
    //ham thiet lap bang danh sach
    public void setUp()
    {
        DefaultTableModel model = (DefaultTableModel) jTableNV.getModel();
        model.setRowCount(0);
        for(NhanVienDTO nhanvien : getList("ListNhanVien"))
        {
            System.out.println(nhanvien.getTrangThai());
            //them tung doi tuong vao bang
            if(nhanvien.getTrangThai()==1)
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngaySinh = formatter.format(nhanvien.getNgaySinh());
                System.out.println(nhanvien.getHoVaTen());
                model.addRow(new Object[] {nhanvien.getMaNV(),nhanvien.getHoVaTen(),ngaySinh,nhanvien.getGioiTinh(),nhanvien.getDiaChi(),nhanvien.getEmail()});
            }
        }
    }
    
    private void timKiem()
    {
        String searchText = timkiem.KhongLayDau(timKiemField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) jTableNV.getModel();
        model.setRowCount(0); 
        

        ArrayList<NhanVienDTO> allWorker = getList("ListNhanVien");

        for (NhanVienDTO nv : allWorker) {
            if (nv.getTrangThai() == 1) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngaySinh = formatter.format(nv.getNgaySinh());
                String maNV = timkiem.KhongLayDau(nv.getMaNV().toLowerCase());
                String tenNV = timkiem.KhongLayDau(nv.getHoVaTen().toLowerCase());
                

                if (maNV.contains(searchText) || tenNV.contains(searchText)) {
                    model.addRow(new Object[]{nv.getMaNV(), nv.getHoVaTen(), ngaySinh,nv.getGioiTinh(), nv.getDiaChi(), nv.getSoDienThoai(), nv.getEmail()});
                }
            }
        }

        if (model.getRowCount() == 0 && !searchText.isEmpty()) {
            // xu li thong bao khi khong tim thay
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ThemButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SuaButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        XoaButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ChiTietButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        timKiemField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNV = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ThemButton.setBackground(new java.awt.Color(255, 255, 255));
        ThemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemButtonMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconthem.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm");

        javax.swing.GroupLayout ThemButtonLayout = new javax.swing.GroupLayout(ThemButton);
        ThemButton.setLayout(ThemButtonLayout);
        ThemButtonLayout.setHorizontalGroup(
            ThemButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThemButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ThemButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        ThemButtonLayout.setVerticalGroup(
            ThemButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThemButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        SuaButton.setBackground(new java.awt.Color(255, 255, 255));
        SuaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuaButtonMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconsua.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sửa");

        javax.swing.GroupLayout SuaButtonLayout = new javax.swing.GroupLayout(SuaButton);
        SuaButton.setLayout(SuaButtonLayout);
        SuaButtonLayout.setHorizontalGroup(
            SuaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuaButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(SuaButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        SuaButtonLayout.setVerticalGroup(
            SuaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuaButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        XoaButton.setBackground(new java.awt.Color(255, 255, 255));
        XoaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XoaButtonMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconxoa.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Xóa");

        javax.swing.GroupLayout XoaButtonLayout = new javax.swing.GroupLayout(XoaButton);
        XoaButton.setLayout(XoaButtonLayout);
        XoaButtonLayout.setHorizontalGroup(
            XoaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XoaButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(XoaButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        XoaButtonLayout.setVerticalGroup(
            XoaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XoaButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        ChiTietButton.setBackground(new java.awt.Color(255, 255, 255));
        ChiTietButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChiTietButtonMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconCT.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chi tiết");

        javax.swing.GroupLayout ChiTietButtonLayout = new javax.swing.GroupLayout(ChiTietButton);
        ChiTietButton.setLayout(ChiTietButtonLayout);
        ChiTietButtonLayout.setHorizontalGroup(
            ChiTietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiTietButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ChiTietButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ChiTietButtonLayout.setVerticalGroup(
            ChiTietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiTietButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ThemButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SuaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(XoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ChiTietButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(XoaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ThemButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SuaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ChiTietButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        timKiemField.setText("Tìm kiếm....");
        timKiemField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timKiemField.setRequestFocusEnabled(false);
        timKiemField.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NV01", "ng van a", "1/1/1", "nam", "12 ng trãi"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNV.setFocusable(false);
        jTableNV.setGridColor(new java.awt.Color(0, 0, 0));
        jTableNV.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableNV.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemButtonMouseClicked
        // TODO add your handling code here:
        themNhanVien tnv = new themNhanVien(client1, this);
        tnv.setDefaultCloseOperation(tnv.DISPOSE_ON_CLOSE);
        tnv.setVisible(true);
    }//GEN-LAST:event_ThemButtonMouseClicked

    private void SuaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuaButtonMouseClicked
        // TODO add your handling code here:
        //neu nhu chua chon doi tuong thi khong co 
        if(MaDT.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        suaNhanVien snv = new suaNhanVien(MaDT, client1, this);
        snv.setDefaultCloseOperation(snv.DISPOSE_ON_CLOSE);
        snv.setVisible(true);
    }//GEN-LAST:event_SuaButtonMouseClicked

    private void ChiTietButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChiTietButtonMouseClicked
        // TODO add your handling code here:
        if(MaDT.equals("0"))
        {
            
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
        thongTinNhanVien ttnv = new thongTinNhanVien(MaDT, client1);
        ttnv.setDefaultCloseOperation(ttnv.DISPOSE_ON_CLOSE);
        ttnv.setVisible(true);
        }
    }//GEN-LAST:event_ChiTietButtonMouseClicked

    private void jTableNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNVMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableNV.getModel();
        int index = jTableNV.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        MaDT = value;
    }//GEN-LAST:event_jTableNVMouseClicked

    private void XoaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XoaButtonMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(MaDT.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JSONObject json = new JSONObject();
        json.put("method","DELETENV");
        json.put("MaNV",MaDT);
        JSONObject json1 = new JSONObject(client1.xoaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            setUp();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_XoaButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChiTietButton;
    private javax.swing.JPanel SuaButton;
    private javax.swing.JPanel ThemButton;
    private javax.swing.JPanel XoaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNV;
    private javax.swing.JTextField timKiemField;
    // End of variables declaration//GEN-END:variables
}
