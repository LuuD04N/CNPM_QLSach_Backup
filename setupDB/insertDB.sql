INSERT INTO NhaXuatBan (MaNXB, TenNXB, Diachi, Sodienthoai, Email) VALUES
('NXB001', 'Nhà Xuất Bản Kim Đồng', 'Hà Nội', '0123456789', 'info@nxbkimdong.vn'),
('NXB002', 'Nhà Xuất Bản Trẻ', 'TP Hồ Chí Minh', '0987654321', 'info@nxbtre.vn'),
('NXB003', 'Nhà Xuất Bản Hội Nhà Văn', 'Đà Nẵng', '0112233445', 'info@nhavanh.vn');

INSERT INTO TacGia (MaTG, Hovaten, ButDanh, GioiTinh, QuocTich) VALUES
('TG001', 'Nguyễn Văn A', 'A.N', 'Nam', 'Việt Nam'),
('TG002', 'Trần Thị B', 'B.T', 'Nữ', 'Việt Nam'),
('TG003', 'Lê Văn C', 'C.L', 'Nam', 'Việt Nam');

INSERT INTO SanPham (MaSP, TenSP, SoTrang, NgonNgu, GiaBia, AnhBia, Soluong, GiaNhap, MaTG) VALUES
('SP001', 'Sách Giáo Khoa Toán 12', 200, 'Tiếng Việt', 150000, NULL, 50, 100000, 'TG001'),
('SP002', 'Sách Lịch Sử Việt Nam', 250, 'Tiếng Việt', 200000, NULL, 30, 150000, 'TG002'),
('SP003', 'Tiếng Anh Thông Dụng', 300, 'Tiếng Anh', 180000, NULL, 20, 120000, 'TG003');


INSERT INTO TheLoai (MaTL, TenTL) VALUES
('TL001', 'Giáo Khoa'),
('TL002', 'Học Tập'),
('TL003', 'Tiếng Anh');

INSERT INTO LoaiKhuyenMai (MaloaiKM, TenloaiKM, Phantramgiam) VALUES
('LKM001', 'Giảm Giá Theo %', 10),
('LKM002', 'Mua Nhiều Tặng Nhiều', 0),
('LKM003', 'Khuyến Mãi Dưới 50%', 15); 

INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, MaloaiKM) VALUES
('KM001', 'Giảm Giá 10%', '2024-10-01', '2024-10-31', 'LKM001'),
('KM002', 'Mua 2 Tặng 1', '2024-10-05', '2024-10-20', 'LKM002'),
('KM003', 'Giảm Giá 15% cho sách tiếng Anh', '2024-10-10', '2024-10-15', 'LKM001');


INSERT INTO TaiKhoan (MaTK, TenTK, MatkhauTK) VALUES
('TK001', 'quanly', '123456'),
('TK002', 'nhapkho', 'abcdef'),
('TK003', 'banhang', 'ghijkl');

INSERT INTO VaiTro (MaVT, TenVT) VALUES
('VT001', 'Quản Lý'),
('VT002', 'Nhập Kho'),
('VT003', 'Bán Hàng');

INSERT INTO NhanVien (MaNV, Hovaten, NgaySinh, GioiTinh, Sodienthoai, Email, DiaChi, MaTK, MaVT) VALUES
('NV001', 'Nguyễn Văn D', '1990-01-01', 'Nam', '0123456789', 'nv1@example.com', 'Hà Nội', 'TK001', 'VT001'),
('NV002', 'Trần Thị E', '1992-05-15', 'Nữ', '0987654321', 'nv2@example.com', 'TP Hồ Chí Minh', 'TK002', 'VT002'),
('NV003', 'Lê Văn F', '1995-07-20', 'Nam', '0112233445', 'nv3@example.com', 'Đà Nẵng', 'TK003', 'VT003');

INSERT INTO HoaDon (MaHD, Ngaylaphoadon, ThanhTien, Trangthai, MaTK) VALUES
('HD001', '2024-10-10', 150000, 1, 'TK001'),
('HD002', '2024-10-11', 200000, 1, 'TK002'),
('HD003', '2024-10-12', 300000, 1, 'TK003');



INSERT INTO PhieuNhap (MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, MaNXB) VALUES
('PN001', '2024-10-01', 1000000, 1, 'TK001', 'NXB001'),
('PN002', '2024-10-05', 1500000, 1, 'TK002', 'NXB002'),
('PN003', '2024-10-10', 2000000, 1, 'TK003', 'NXB003');


INSERT INTO ChiTietHD (MaHD, Soluong, DonGia, MaSP) VALUES
('HD001', 2, 150000, 'SP001'),
('HD001', 1, 200000, 'SP002'),
('HD002', 1, 200000, 'SP002'),
('HD003', 3, 180000, 'SP003');

INSERT INTO ChiTietKM (MaKM, MaSP) VALUES
('KM001', 'SP001'),
('KM001', 'SP002'),
('KM002', 'SP003');

INSERT INTO ChiTietPN (Soluongnhap, DonGia, MaSP, MaPN) VALUES
(10, 100000, 'SP001', 'PN001'),
(10, 100000, 'SP001', 'PN002'),
(5, 150000, 'SP002', 'PN002'),
(15, 120000, 'SP003', 'PN003');

INSERT INTO SachTheLoai (MaSP, MaTL) VALUES
('SP001', 'TL001'),
('SP002', 'TL001'),
('SP002', 'TL002'),
('SP003', 'TL003');
