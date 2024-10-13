create database QLSach

create table NhaXuatBan(
	MaNXB varchar(10),
	TenNXB Nvarchar(100),
	Diachi nvarchar(100),
	Sodienthoai varchar(10),
	Email varchar(100),
	NgayThanhLap date,
	Trangthai int
	Primary key (MaNXB)
)

create table SanPham(
	MaSP Varchar(10),
	TenSP Nvarchar(100),
	SoTrang int,
	NgonNgu Nvarchar(50),
	GiaBia Double PRECISION,
	AnhBia VARBINARY(MAX),
	Soluong Int,
	GiaNhap double PRECISION,
	MaTG Varchar(10)
	Primary key (MaSP)
)

create table TacGia(
	MaTG Varchar(10),
	Hovaten Nvarchar(100),
	ButDanh Nvarchar(50),
	GioiTinh Nvarchar(10),
	QuocTich Nvarchar(50)
	primary key (MaTG)
)

create table TheLoai(
	MaTL Varchar(10),
	TenTL Nvarchar(100)
	primary key (MaTL)
)

create table KhuyenMai(
	MaKM Varchar(10),
	TenKM Nvarchar(50),
	NgayBatDau Date,
	NgayKetThuc Date,
	TrangThai int,
	MaloaiKM varchar(10)
	primary key (MaKM)
)

create table LoaiKhuyenMai(
	MaloaiKM varchar(10),
	TenloaiKM Nvarchar(50),
	Phantramgiam int,

	primary key (MaloaiKM)
)

create table NhanVien(
	MaNV Varchar(10),
	Hovaten Nvarchar(50),
	NgaySinh Date,
	GioiTinh Nvarchar(10),
	Sodienthoai Varchar(10),
	Email Nvarchar(100),
	DiaChi Nvarchar(100),
	MaTK Varchar(10),
	MaVT Varchar(10)

	primary key (MaNV)
)

create table HoaDon(
	MaHD Varchar(10),
	Ngaylaphoadon Date,
	ThanhTien DOUBLE PRECISION,
	Trangthai INT,
	MaTK Varchar(10)

	primary key(MaHD)
)

create table TaiKhoan(
	MaTK Varchar(10),
	TenTK Nvarchar(50),
	MatkhauTK Nvarchar(10)

	primary key(MaTK)
)

create table PhieuNhap(
	MaPN Varchar(10),
	NgayNhap Date,
	Thanhtien DOUBLE PRECISION,
	Trangthai INT,
	MaTK Varchar(10),
	MaNXB Varchar(10)

	primary key(MaPN)
)

create table VaiTro(
	MaVT Varchar(10),
	TenVT Nvarchar(50)

	primary key(MaVT)
)

create table ChiTietHD(
	MaCTHD Varchar(10),
	Soluong Int,
	DonGia DOUBLE PRECISION,
	MaSP Varchar(10)
)

create table ChiTietKM(
	GiaTriKhuyenMai Int,
	MaKM Varchar(10),
	MaSP Varchar(10)

)

create table ChiTietPN(
	Soluongnhap Int,
	DonGia DOUBLE PRECISION,
	MaSP Varchar(10),
	MaPN Varchar(10)

)

create table SachTheLoai(
	MaSP Varchar(10),
	MaTL Varchar(10)
)

ALTER TABLE SanPham
ADD FOREIGN KEY (MaTG) REFERENCES TacGia(MaTG);

ALTER TABLE khuyenMai
ADD FOREIGN KEY (MaloaiKM) REFERENCES LoaiKhuyenMai(MaloaiKM);

ALTER TABLE NhanVien
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE NhanVien
ADD FOREIGN KEY (MaVT) REFERENCES VaiTro(MaVT);

ALTER TABLE HoaDon
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE PhieuNhap
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE PhieuNhap
ADD FOREIGN KEY (MaNXB) REFERENCES NhaXuatBan(MaNXB);

ALTER TABLE ChiTietHD
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietHD
ADD FOREIGN KEY (MaCTHD) REFERENCES HoaDon(MaHD);

ALTER TABLE ChiTietKM
ADD FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM);

ALTER TABLE ChiTietKM
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietPN
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietPN
ADD FOREIGN KEY (MaPN) REFERENCES PhieuNhap(MaPN);

ALTER TABLE SachTheLoai
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE SachTheLoai
ADD FOREIGN KEY (MaTL) REFERENCES TheLoai(MaTL);