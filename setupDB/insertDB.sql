INSERT INTO TaiKhoan (MaTK, TenTK, MatkhauTK) VALUES
('TK001', 'admin', 'admin123'),
('TK002', 'user1', 'user123'),
('TK003', 'user2', 'user456');

INSERT INTO VaiTro (MaVT, TenVT) VALUES
('VT001', 'Quản lý'),
('VT002', 'Nhân viên'),
('VT003', 'Khách hàng');

INSERT INTO LoaiKhuyenMai (MaloaiKM, TenloaiKM, Phantramgiam) VALUES
('KM001', 'Giảm giá đặc biệt', 20),
('KM002', 'Khuyến mãi mùa hè', 15),
('KM003', 'Giảm giá mới', 10);

INSERT INTO NhaXuatBan (MaNXB, TenNXB, Diachi, Sodienthoai, Email, NgayThanhLap, Trangthai) VALUES
('NXB001', 'NXB Giáo Dục', '123 Đường ABC, Hà Nội', '0123456789', 'contact@nxbgiaoduc.com', '2000-05-15', 1),
('NXB002', 'NXB Văn Học', '456 Đường DEF, TP.HCM', '0987654321', 'info@nxbvanhoc.com', '2005-08-20', 1);

INSERT INTO TacGia (MaTG, Hovaten, ButDanh, GioiTinh, QuocTich) VALUES
('TG001', 'Nguyễn Văn A', 'NVA', 'Nam', 'Việt Nam'),
('TG002', 'Trần Thị B', 'TTB', 'Nữ', 'Việt Nam'),
('TG003', 'Lê Văn C', 'LVC', 'Nam', 'Việt Nam');

INSERT INTO TheLoai (MaTL, TenTL) VALUES
('TL001', 'Khoa học máy tính'),
('TL002', 'Văn học'),
('TL003', 'Kinh doanh');

INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, TrangThai, MaloaiKM) VALUES
('KM001', 'Giảm 20% cho sách khoa học', '2024-06-01', '2024-06-30', 1, 'KM001'),
('KM002', 'Giảm 15% mùa hè', '2024-07-01', '2024-08-31', 1, 'KM002');

INSERT INTO SanPham (MaSP, TenSP, SoTrang, NgonNgu, GiaBia, AnhBia, Soluong, GiaNhap, MaTG) VALUES
('SP001', 'Lập Trình Cơ Bản', 300, 'Tiếng Việt', 250000.00, NULL, 100, 200000.00, 'TG001'),
('SP002', 'Văn Học Việt Nam', 250, 'Tiếng Việt', 200000.00, NULL, 150, 150000.00, 'TG002'),
('SP003', 'Kinh Doanh Hiệu Quả', 400, 'Tiếng Việt', 300000.00, NULL, 80, 250000.00, 'TG003');

INSERT INTO NhanVien (MaNV, Hovaten, NgaySinh, GioiTinh, Sodienthoai, Email, DiaChi, MaTK, MaVT) VALUES
('NV001', 'Trần Văn D', '1985-04-20', 'Nam', '0912345678', 'vanda@company.com', '789 Đường GHI, Đà Nẵng', 'TK001', 'VT001'),
('NV002', 'Lê Thị E', '1990-09-15', 'Nữ', '0987654321', 'lethie@company.com', '321 Đường JKL, Hải Phòng', 'TK002', 'VT002');


INSERT INTO HoaDon (MaHD, Ngaylaphoadon, ThanhTien, Trangthai, MaTK) VALUES
('HD001', '2024-05-10', 500000.00, 1, 'TK001'),
('HD002', '2024-05-11', 300000.00, 1, 'TK002');

INSERT INTO PhieuNhap (MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, MaNXB) VALUES
('PN001', '2024-05-01', 2000000.00, 1, 'TK001', 'NXB001'),
('PN002', '2024-05-02', 1500000.00, 1, 'TK002', 'NXB002');

INSERT INTO SachTheLoai (MaSP, MaTL) VALUES
('SP001', 'TL001'),
('SP002', 'TL002'),
('SP003', 'TL003');

INSERT INTO ChiTietHD (MaCTHD, Soluong, DonGia, MaSP) VALUES
('HD001', 2, 250000.00, 'SP001'),
('HD002', 1, 200000.00, 'SP002');


INSERT INTO ChiTietKM (GiaTriKhuyenMai, MaKM, MaSP) VALUES
(20, 'KM001', 'SP001'),
(15, 'KM002', 'SP002');

INSERT INTO ChiTietPN (Soluongnhap, DonGia, MaSP, MaPN) VALUES
(50, 200000.00, 'SP001', 'PN001'),
(30, 150000.00, 'SP002', 'PN002'),
(20, 250000.00, 'SP003', 'PN001');
