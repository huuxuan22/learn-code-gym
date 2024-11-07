create database Furama;
use Furama;

create table ViTri
(
	MaViTri int primary key,
    TenViTri varchar(45)
);
create table VaiTro
(
	MaVaiTro int,
    TenVaiTro varchar(50)
);

create table NguoiSuDung
(
	UserName varchar primar
)
create table TrinhDo
(
	MaTrinhDo int primary key,
    TenTrinhDo varchar(45)
);

create table BoPhan
(
	MaBoPhan int primary key,
    TenBoPhan varchar(45)
);

create table DichVuDiKem
(
	MaDichVuDiKem int primary key,
    TenDichVuDiKem varchar(45),
    Gia double,
    DonVi varchar(10),
    TrangThai varchar(45)
);

create table KieuThue
(
	MaKieuThue int primary key,
    TenKieuThue varchar(45)
);

create table LoaiKhach
(
	MaLoaiKhach int primary key,
    TenLoaiKhach varchar(45)
);

create table LoaiDichVu
(
	MaLoaiDichVu int primary key,
    TenLoaiDichVu varchar(45)
);

create table KhachHang
(
	MaKhachHang int primary key,
    MaLoaiKhach int,
    HoTen varchar(45),
    NgaySinh date,
    GioiTinh bit,
    CMND varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    foreign key(MaLoaiKhach) references LoaiKhach(MaLoaiKhach)
);

create table DichVu
(
	MaDichVu int primary key,
    TenDichVu varchar(45),
    DienTich int,
    ChiPhiThue double,
    SoNguoiToiDat int,
    MaKieuThue int,
    MaLoaiDichVu int,
    TieuChuanPhong varchar(45),
    MoTaTienNghiKhac varchar(45),
    DienTichHoBoi double,
	SoTang int,
    DichVuMienPhiDiKem text,
    foreign key (MaKieuThue) references KieuThue(MaKieuThue),
    foreign key (MaLoaiDichVu) references LoaiDichVu(MaLoaiDichVu),
    -- thêm ràng buộc cho bảng dịch vụ 
    constraint check_Dientich check (DienTich >= 0),
    constraint check_ChiPhiThue check (DienTich >= 0),
    constraint check_SoTang check (DienTich >= 0),
    constraint check_HoBoi check (DienTichHoBoi >= 0)
);

create table NhanVien
(
	MaNhanVien int primary key,
    HoTen varchar(45),
    NgaySinh date,
    CMND varchar(45),
    Luong double,
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    MaViTri int,
    MaTrinhDo int,
    MaBoPhan int,
    UserName varchar(50),
    foreign key (MaViTri) references ViTri(MaViTri),
    foreign key (MaTrinhDo) references TrinhDo(MaTrinhDo),
    foreign key (MaBoPhan) references BoPhan(MaBoPhan),
    -- tạo thêm ràng buộc cho bảng nhân viên
    constraint Check_Email check (Email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'),
    constraint Check_Luong check (Luong >= 0),
    constraint check_SDT check (SDT REGEXP '0[0-9]{9}$')
);

create table HopDong 
(
	MaHopDong int primary key,
    NgayLamHopDong datetime not null,
    NgayKetThuc dateTime not null,
    TienDatCoc double,
    MaNhanVien int,
    MaKhachHang int,
    MaDichVu int,
    foreign key (MaNhanVien) references NhanVien(MaNhanVien),
    foreign key (MaKhachHang) references KhachHang(MaKhachHang),
    foreign key(MaDichVu) references DichVu(MaDichVu)
);
create table HopDongChiTiet
(
	MaHopDongChiTiet int primary key,
    MaHopDong int,
    MaDichVuDiKem int,
    SoLuong int,
    foreign key (MaHopDong) references HopDong(MaHopDong),
    foreign key(MaDichVuDiKem) references DichVuDiKem(MaDichVuDiKem)
);

-- Bảng ViTri
INSERT INTO ViTri (MaViTri, TenViTri) VALUES
(1, 'VIP'),
(2, 'Standard'),
(3, 'Deluxe'),
(4, 'Superior'),
(5, 'Family'),
(6, 'Suite'),
(7, 'Executive'),
(8, 'Penthouse'),
(9, 'Ocean View'),
(10, 'Garden View');

-- Bảng TrinhDo
INSERT INTO TrinhDo (MaTrinhDo, TenTrinhDo) VALUES
(1, 'Bachelor'),
(2, 'Master'),
(3, 'PhD'),
(4, 'Associate'),
(5, 'Diploma'),
(6, 'Certificate'),
(7, 'Specialist'),
(8, 'Professional'),
(9, 'Technical'),
(10, 'Vocational');

-- Bảng BoPhan
INSERT INTO BoPhan (MaBoPhan, TenBoPhan) VALUES
(1, 'Administration'),
(2, 'Finance'),
(3, 'Human Resources'),
(4, 'Marketing'),
(5, 'IT'),
(6, 'Customer Service'),
(7, 'Operations'),
(8, 'Sales'),
(9, 'Engineering'),
(10, 'Security');

-- Bảng DichVuDiKem
INSERT INTO DichVuDiKem (MaDichVuDiKem, TenDichVuDiKem, Gia, DonVi, TrangThai) VALUES
(1, 'WiFi', 10, 'Hour', 'Active'),
(2, 'Breakfast', 15, 'Person', 'Active'),
(3, 'Airport Transfer', 20, 'Service', 'Inactive'),
(4, 'Spa Package', 30, 'Package', 'Active'),
(5, 'Laundry Service', 8, 'Piece', 'Active'),
(6, 'Gym Access', 12, 'Day', 'Inactive'),
(7, 'Room Upgrade', 25, 'Service', 'Active'),
(8, 'Car Rental', 50, 'Day', 'Active'),
(9, 'Late Checkout', 18, 'Hour', 'Active'),
(10, 'Pool Access', 15, 'Day', 'Inactive');

-- Bảng KieuThue
INSERT INTO KieuThue (MaKieuThue, TenKieuThue) VALUES
(1, 'Hourly'),
(2, 'Daily'),
(3, 'Weekly'),
(4, 'Monthly'),
(5, 'Yearly'),
(6, 'Event');

-- Bảng LoaiKhach
INSERT INTO LoaiKhach (MaLoaiKhach, TenLoaiKhach) VALUES
(1, 'Regular'),
(2, 'VIP'),
(3, 'Corporate'),
(4, 'Government'),
(5, 'Senior'),
(6, 'Group'),
(7, 'Family'),
(8, 'Student'),
(9, 'Military'),
(10, 'Wedding');

-- Bảng LoaiDichVu
INSERT INTO LoaiDichVu (MaLoaiDichVu, TenLoaiDichVu) VALUES
(1, 'Hotel'),
(2, 'Resort'),
(3, 'Motel'),
(4, 'Inn'),
(5, 'Guesthouse'),
(6, 'Cottage'),
(7, 'B&B'),
(8, 'Hostel'),
(9, 'Villa'),
(10, 'Apartment');

-- Bảng KhachHang
INSERT INTO KhachHang (MaKhachHang, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, CMND, SDT, Email, DiaChi) VALUES
(1, 2, 'John Doe', '1990-05-15', 1, '123456789', '0123456789', 'john.doe@example.com', '123 Main St'),
(2, 1, 'Jane Smith', '1985-08-22', 0, '987654321', '0987654321', 'jane.smith@example.com', '456 Oak St'),
(3, 3, 'Bob Johnson', '1978-11-10', 1, '456789123', '0123456789', 'bob.johnson@example.com', '789 Pine St'),
(4, 4, 'Alice Williams', '1995-03-25', 0, '789123456', '0987654321', 'alice.williams@example.com', '101 Maple St'),
(5, 1, 'Charlie Brown', '1980-12-05', 1, '321654987', '0123456789', 'charlie.brown@example.com', '202 Cedar St'),
(6, 3, 'Eva Davis', '1992-07-18', 0, '654789321', '0987654321', 'eva.davis@example.com', '303 Birch St'),
(7, 2, 'Mike Miller', '1987-09-30', 1, '987321654', '0123456789', 'mike.miller@example.com', '404 Elm St'),
(8, 1, 'Lisa Taylor', '1998-01-12', 0, '147258369', '0987654321', 'lisa.taylor@example.com', '505 Walnut St'),
(9, 5, 'David Wilson', '1983-06-08', 1, '369852147', '0123456789', 'david.wilson@example.com', '606 Oak St'),
(10, 4, 'Sarah Moore', '1990-04-20', 0, '258369147', '0987654321', 'sarah.moore@example.com', '707 Pine St');

-- Bảng DichVu
INSERT INTO DichVu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDat, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac, DienTichHoBoi, SoTang, DichVuMienPhiDiKem) VALUES
(1, 'Luxury Suite', 60, 250, 2, 2, 1, '5-star', 'Ocean view, Jacuzzi', 10, 5, 'WiFi, Breakfast'),
(2, 'Beachfront Villa', 120, 450, 4, 3, 9, '5-star', 'Private beach access, Pool', 20, 2, 'WiFi, Late Checkout'),
(3, 'Standard Room', 30, 100, 1, 1, 1, '3-star', 'City view, Basic amenities', 0, 3, 'WiFi'),
(4, 'Family Cabin', 40, 150, 3, 2, 6, '4-star', 'Forest view, Fireplace', 5, 2, 'WiFi, Breakfast, Pool Access'),
(5, 'Executive Suite', 50, 200, 2, 3, 1, '4-star', 'Mountain view, Workstation', 0, 4, 'WiFi, Late Checkout'),
(6, 'Garden Cottage', 35, 120, 2, 1, 6, '3-star', 'Garden view, Kitchenette', 0, 1, 'WiFi'),
(7, 'Poolside Bungalow', 45, 180, 3, 2, 5, '4-star', 'Pool view, Terrace', 15, 2, 'WiFi, Pool Access'),
(8, 'Apartment Suite', 55, 220, 2, 3, 10, '4-star', 'City view, Living area', 0, 5, 'WiFi, Late Checkout'),
(9, 'Mountain Chalet', 65, 280, 3, 1, 6, '5-star', 'Mountain view, Fireplace', 10, 3, 'WiFi'),
(10, 'Ocean View Room', 35, 150, 2, 2, 1, '4-star', 'Ocean view, Balcony', 0, 4, 'WiFi, Breakfast');

-- Bảng NhanVien
INSERT INTO NhanVien (MaNhanVien, HoTen, NgaySinh, CMND, Luong, SDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan) VALUES
(1, 'Alex Johnson', '1980-02-14', '456123789', 3000, '0123456789', 'alex.johnson@example.com', '123 Main St', 2, 2, 1),
(2, 'Emily Davis', '1992-09-25', '789456123', 2500, '0987654321', 'emily.davis@example.com', '456 Oak St', 3, 3, 2),
(3, 'Michael Smith', '1985-06-12', '321789654', 3500, '0123456789', 'michael.smith@example.com', '789 Pine St', 1, 4, 3),
(4, 'Sophia Brown', '1998-04-30', '987654321', 2000, '0987654321', 'sophia.brown@example.com', '101 Maple St', 4, 5, 4),
(5, 'Christopher Wilson', '1995-11-08', '654321987', 2800, '0123456789', 'christopher.wilson@example.com', '202 Cedar St', 5, 6, 5),
(6, 'Olivia Moore', '1982-08-17', '789321654', 3200, '0987654321', 'olivia.moore@example.com', '303 Birch St', 2, 7, 6),
(7, 'William Taylor', '1990-03-22', '123789456', 2600, '0123456789', 'william.taylor@example.com', '404 Elm St', 3, 8, 7),
(8, 'Emma Miller', '1987-12-05', '456987321', 3800, '0987654321', 'emma.miller@example.com', '505 Walnut St', 1, 9, 8),
(9, 'Liam Johnson', '1994-05-18', '789147258', 2100, '0123456789', 'liam.johnson@example.com', '606 Oak St', 4, 10, 9),
(10, 'Ava Davis', '1989-01-30', '258369147', 2900, '0987654321', 'ava.davis@example.com', '707 Pine St', 5, 6, 10);
select * from Stud
-- Bảng HopDong
INSERT INTO HopDong (MaHopDong, NgayLamHopDong, NgayKetThuc, TienDatCoc, MaNhanVien, MaKhachHang, MaDichVu) VALUES
(1, '2023-01-10 08:00:00', '2023-02-10 18:00:00', 500, 1, 1, 3),
(2, '2023-02-15 10:30:00', '2023-03-15 20:30:00', 700, 2, 2, 6),
(3, '2023-03-20 12:45:00', '2023-04-20 22:45:00', 1000, 3, 3, 9),
(4, '2023-04-25 14:15:00', '2023-05-25 00:15:00', 800, 4, 4, 2),
(5, '2023-05-30 16:30:00', '2023-06-30 02:30:00', 1200, 5, 5, 5),
(6, '2023-06-05 18:45:00', '2023-07-05 04:45:00', 900, 6, 6, 8),
(7, '2023-07-10 20:00:00', '2023-08-10 06:00:00', 600, 7, 7, 10),
(8, '2023-08-15 22:15:00', '2023-09-15 10:15:00', 1100, 8, 8, 1),
(9, '2023-09-20 00:30:00', '2023-10-20 12:30:00', 950, 9, 9, 4),
(10, '2023-10-25 02:45:00', '2023-11-25 14:45:00', 850, 10, 9, 7);



-- Bảng HopDongChiTiet
INSERT INTO HopDongChiTiet (MaHopDongChiTiet, MaHopDong, MaDichVuDiKem, SoLuong) VALUES
(12, 1, 3, 2),
(2, 2, 6, 1),
(3, 3, 9, 3),
(4, 4, 2, 2),
(5, 5, 5, 1),
(6, 6, 8, 2),
(7, 7, 10, 1),
(8, 8, 1, 2),
(9, 9, 4, 3),
(10, 10, 7, 1);



-- 	BÀI TẬP CASE STUDY
-- câu 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả
-- mãn các yêu cầu bên dưới. đã làm phái trên 

-- câu 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
create index index_HoTen on NhanVien(HoTen);

explain select *
from NhanVien
where ((HoTen Like 'H%' and HoTen Like 'T%') or (HoTen Like 'K%')) and Length(HoTen) < 15;

-- câu 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”
select * 
from KhachHang
where ((year(Now()) - year(NgaySinh)) between 18 and 50) and (DiaChi = 'Đà Nẵng' or DiaChi = 'Quảng Trị');

-- câu 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond” thay thế bằng VIP
select kh.*, count(hd.MaKhachHang)
from KhachHang kh
join HopDong hd on kh.MaKhachHang = hd.MaKhachHang
where kh.MaLoaiKhach = 2
group by hd.MaKhachHang

-- câu 5: Hiển   thị  ma_khach_hang,   ho_ten,   ten_loai_khach,   ma_hop_dong,
-- ten_dich_vu,   ngay_lam_hop_dong,   ngay_ket_thuc,   tong_tien  (Với
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng *
-- Giá,   với   Số   Lượng   và   Giá   là   từ   bảng   dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những
-- khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select  hdct.MaHopDong,hdct.MaDichVuDiKem,kh.MaKhachHang,kh.HoTen,lk.TenLoaiKhach,hd.MaHopDong,dv.TenDichVu,hd.NgayLamHopDong,hd.NgayKetThuc, (dv.ChiPhithue + hdct.SoLuong*dvdk.Gia) as TongTien
from KhachHang kh 
left join HopDong hd on hd.MaKhachHang = kh.MaKhachHang 
inner join LoaiKhach lk on lk.MaLoaiKhach = kh.MaLoaiKhach 
left join DichVu dv on dv.MaDichVu = hd.MaDichVu
left join HopDongChiTiet hdct on hdct.MaHopDong = hd.MaHopDong 
left join DichVuDiKem dvdk on dvdk.MaDichVuDiKem = hdct.MaDichVuDiKem
-- sử dụng left để lấy những cái dịch vụ hay là khách hàng có được đặt hay không

-- câu 6: Hiển   thị  ma_dich_vu,   ten_dich_vu,   dien_tich,   chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng
-- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3)
select dv.MaDichVu,dv.TenDichVu,dv.DienTich,dv.ChiPhiThue,ldv.TenLoaiDichVu
from DichVu dv
inner join LoaiDichVu ldv on ldv.MaLoaiDichVu = dv.MaLoaiDichVu
where dv.MaDichVu not in (select distinct MaDichVu from HopDong where NgayLamHopDong >= '2021-01-01' and NgayLamHopDong <= '2021-03-31')

-- câu 7: Hiển   thị   thông   tin  ma_dich_vu,   ten_dich_vu,   dien_tich,
-- so_nguoi_toi_da,   chi_phi_thue,   ten_loai_dich_vu  của tất cả các loại
-- dịch vụ đã từng được khách hàng đặt phòng  trong   năm   2020  nhưng
-- chưa từng được khách hàng đặt phòng trong năm 2021
select dv.MaDichVu,dv.TenDichVu,dv.DienTich,dv.SoNguoiToiDat,dv.ChiPhiThue,ldv.TenLoaiDichVu
from  DichVu dv
inner join LoaiDichVu ldv on ldv.MaloaiDichVu = dv.MaLoaiDichVu
where dv.MaDichVu in (select MaDichVu from HopDong where year(NgayLamHopDong) = 2020 and year(NgayLamHopDong) <> 2021)


-- câu 8: Hiển thị thông tin  ho_ten  khách hàng  có trong hệ thống, với yêu cầu
-- ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- cách 1: 
select distinct HoTen
from KhachHang

-- cách 2: 
SELECT HoTen
FROM KhachHang
GROUP BY HoTen
HAVING COUNT(*) = 1;

-- cách 3 
SELECT HoTen
FROM KhachHang k1
WHERE NOT EXISTS (
    SELECT 1
    FROM KhachHang k2
    WHERE k1.HoTen = k2.HoTen AND k1.MaKhachHang <> k2.MaKhachHang
);

-- câu 9: Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
-- tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt
-- phòng.
select count(MaKhachHang) as thang1,
	   count(MaKhachHang) as thang2,
       count(MaKhachHang) as thang3,
       count(MaKhachHang) as thang4,
       count(MaKhachHang) as thang5,
       count(MaKhachHang) as thang6,
	   count(MaKhachHang) as thang7,
       count(MaKhachHang) as thang8,
       count(MaKhachHang) as thang9,
       count(MaKhachHang) as thang10,
       count(MaKhachHang) as thang11,
       count(MaKhachHang) as thang12
from HopDong
where year(NgayLamHopDong) = 2021 
group by Month(NgayLamHopDong);

-- câu 10: Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu
-- dịch   vụ   đi   kèm.   Kết   quả   hiển   thị   bao   gồm  ma_hop_dong,
-- ngay_lam_hop_dong,   ngay_ket_thuc,   tien_dat_coc,
-- so_luong_dich_vu_di_kem  (được tính dựa trên việc sum so_luong ở
-- dich_vu_di_kem)
select hd.MaHopDong,hd.NgayLamHopDong,hd.NgayKetThuc,hd.TienDatCoc,count(hdct.MaDichVuDiKem)
from HopDong hd
inner join HopDongChiTiet hdct on hd.MaHopDong = hdct.MaHopDong
group by hdct.MaHopDong;

-- câu 11: Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
-- hàng có ten_loai_khach  là  “Diamond”  và có dia_chi ở “Vinh” hoặc
-- “Quảng Ngãi” thay thế "Dimond" bằng VIP
select dvdk.*
from DichVuDiKem dvdk
inner join HopDongChiTiet hdct on hdct.MaDichVuDiKem = dvdk.MaDichVuDiKem
inner join HopDong hd on hd.MaHopDong = hdct.MaHopDong 
inner join KhachHang kh on kh.MaKhachHang = hd.MaKhachHang 
inner join LoaiKhach lk on lk.MaLoaiKhach = kh.MaLoaiKhach
where TenLoaiKhach = 'VIP' and (DiaChi = 'Vinh' or DiaChi = 'Quảng Ngãi')

-- câu 12: Hiển thị thông tin  ma_hop_dong,  ho_ten  (nhân viên),  ho_ten  (khách
-- hàng),  so_dien_thoai  (khách   hàng),  ten_dich_vu,
-- so_luong_dich_vu_di_kem  (được tính dựa trên việc sum so_luong ở
-- dich_vu_di_kem),  tien_dat_coc  của tất cả các dịch vụ đã từng được
-- khách hàng đặt vào  3   tháng   cuối   năm   2020   nhưng   chưa   từng   được
-- khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.MaHopDong,nv.HoTen,kh.HoTen,kh.SDT,sum(hdct.MaHopDong) as so_luong_dich_vu_di_kem,hd.TienDatCoc
from NhanVien nv
inner join HopDong hd on nv.MaNhanVien = hd.MaNhanVien
inner join KhachHang kh on kh.MaKhachHang = hd.MaKhachHang
inner join HopDongChiTiet hdct on hdct.MaHopDong = hd.MaHopDong
inner join DichVu dv on dv.MaDichVu = hd.MaDichVu
where (month(hd.NgayLamHopDong) not in (10,11,12) and year(hd.NgaylamHopDong) = 2020) and 
		(month(hd.NgayLamHopDong) not in (1,2,3,4,5,6) and year(hd.NgaylamHopDong) = 2021)
group by hdct.MaHopDong, nv.HoTen, kh.HoTen, kh.SDT, dv.TenDichVu, hd.TienDatCoc;
-- câu 13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
-- Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử
-- dụng nhiều như nhau).
select dvdk.MaDichVuDiKem,dvdk.TenDichVuDiKem,dvdk.Gia,dvdk.DonVi,dvdk.TrangThai, count(dvdk.MaDichVuDiKem) as So_Lan_Su_Dung
from DichVuDiKem dvdk
inner join HopDongChiTiet hdct on hdct.MaDiChVuDiKem = dvdk.MaDichVuDiKem
where hdct.MaHopDong is not null
group by dvdk.MaDichVuDiKem,dvdk.TenDichVuDiKem,dvdk.Gia,dvdk.DonVi,dvdk.TrangThai
having rank() over (order by count(dvdk.MaDichVuDiKem) desc) = 1
order by count(dvdk.MaDichVuDiKem) desc 
limit 0, 1000;

SELECT
    dvdk.MaDichVuDiKem,
    dvdk.TenDichVuDiKem,
    dvdk.Gia,
    dvdk.DonVi,
    dvdk.TrangThai,
    COUNT(dvdk.MaDichVuDiKem) AS So_Lan_Su_Dung,
    RANK() OVER (ORDER BY COUNT(dvdk.MaDichVuDiKem) DESC) AS ranked
FROM
    DichVuDiKem dvdk
    INNER JOIN HopDongChiTiet hdct ON hdct.MaDiChVuDiKem = dvdk.MaDichVuDiKem
WHERE
    hdct.MaHopDong IS NOT NULL
GROUP BY
    dvdk.MaDichVuDiKem,
    dvdk.TenDichVuDiKem,
    dvdk.Gia,
    dvdk.DonVi,
    dvdk.TrangThai
ORDER BY
    So_Lan_Su_Dung DESC
LIMIT 0, 1000;

-- Hỏi chấm ????????????????????????

-- câu 14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
-- lần   duy   nhất.   Thông   tin   hiển   thị   bao   gồm  ma_hop_dong,
-- ten_loai_dich_vu,   ten_dich_vu_di_kem,   so_lan_su_dung  (được tính
-- dựa trên việc count các ma_dich_vu_di_kem)

select hdct.MaHopDong,ldv.TenLoaiDichVu,dvdk.TenDichVuDiKem,count(hdct.MadichVuDikem) as So_Lan_Su_Dung
from HopDongChiTiet hdct
inner join DichVuDiKem dvdk on dvdk.MaDichVuDikem = hdct.MaDichVuDiKem
inner join HopDong hd on hd.MaHopDong = hdct.MaHopDong 
inner join DichVu dv on dv.MaDichVu = hd.MaDichVu
inner join LoaiDichVu ldv on ldv.MaLoaiDichVu = dv.MaLoaiDichVu
where hdct.MaHopDong is not null
group by hdct.MaHopDong,ldv.TenLoaiDichVu,dvdk.TenDichVuDiKem
having  count(hdct.MadichVuDikem) = 1;

 
-- câu 15: Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten,
-- ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
-- tối đa 3 hợp đồng từ năm 2020 đến 2021
select nv.MaNhanVien,nv.HoTen,td.TenTrinhDo,bp.TenBoPhan,nv.SDT,nv.DiaChi,count(hd.MaNhanVien) as So_Lan_lap_hop_Dong
from NhanVien nv
inner join HopDong hd on nv.MaNhanVien = hd.MaNhanVien
inner join TrinhDo td on td.MaTrinhDo = nv.MaTrinhDo
inner join BoPhan bp on bp.MaBoPhan = nv.MaBoPhan 
where hd.NgayLamHopDong >= '2020-01-01 00:00:00' and hd.NgayLamHopDong <= '2021-12-30 23:59:59'
group by  nv.MaNhanVien,nv.HoTen,td.TenTrinhDo,bp.TenBoPhan,nv.SDT,nv.DiaChi
having So_Lan_lap_hop_Dong < 3;



-- câu 16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019
-- đến năm 2021
delete nv.* 
from NhanVien nv
inner join HopDong hd on hd.MaNhanVien = nv.MaNhanVien 
where hd.NgayLamHopDong BETWEEN '2019-01-01 00:00:00' AND '2021-12-30 23:59:59';

-- câu 17: Cập nhật thông tin những khách hàng có ten_loai_khach từ  Vip
-- lên  Regular, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update KhachHang kh     
set kh.MaLoaiKhach = 1
where kh.MaLoaiKhach = 2 and (select sum(dv.ChiPhiThue)
							  from HopDong hd 
                              inner join DichVu dv on dv.MaDichVu = hd.MaDichVu
                              where hd.MaKhachHang = kh.MaKhachHang) > 10000000;

-- câu 18: Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc
-- giữa các bảng).
delete hd.*
from HopDong hd
where year(NgayLamHopDong) < 2021;

set SQL_SAFE_UPDATES = 0;

-- câu 19: Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong
-- năm 2020 lên gấp đôi
update DichVuDiKem dvdk
set Gia = Gia * 2
where (select count(hdct.MaDichVuDiKem)
		from HopDongChiTiet hdct
        where hdct.MaHopDongChiTiet and hdct.MaDichVuDiKem = dvdk.MaDichVuDiKem) > 10;


-- câu 20: Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ
-- thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
-- ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
select MaNhanVien,HoTen,SDT,Email,NgaySinh,DiaChi
from NhanVien
union
select MaKhachHang,HoTen,SDT,Email,NgaySinh,DiaChi
from KhachHang;
-- hỏi chấm ???????????


-- ============================SQL NÂNG CAO=========================

-- câu 21: Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả 
-- các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một 
-- hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”
create view v_NhanVien as 
select nv.*
from NhanVien nv
inner join HopDong hd on hd.MaNhanVien = nv.MaNhanVien
where nv.DiaChi = '123 Main St' and date(hd.NgayLamHopDong) = '2019-12-12';

select * from v_NhanVien;
-- câu 22: Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành 
-- “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn 
-- này.

update v_NhanVien
set DiaChi = 'Liên Chiểu'
where DiaChi = '123 Main St';

set SQL_SAFE_UPDATES = 0;
-- câu 23: Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của 
-- một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 
-- tham số của sp_xoa_khach_hang

DELIMITER //
create procedure sp_xoa_Khach_hang (MaKhachHangs int)
begin
	-- xóa logic
    alter table KhachHang
    add Deleted int;
    
    update KhachHang 
    set Deleted = 0
    where MaKhachHang = MaKhachHangs;
end //

 DELIMITER ;
 
 drop procedure sp_xoa_Khach_hang;
 
 call sp_xoa_Khach_hang(1);

-- câu 24: Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào 
-- bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện 
-- kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được 
-- trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên 
-- quan.

DELIMITER //

CREATE PROCEDURE sp_them_moi_hop_dong(
    IN p_MaHopDongs INT,
    IN p_NgayLamHopDong datetime,
    IN p_NgayKetThuc DATETIME,
    IN p_TienDatCoc INT,
    IN p_MaDichVus INT,
    IN p_MaNhanViens INT,
    IN p_MaKhachHangs INT
)
BEGIN
    DECLARE errorMessage VARCHAR(255);

    -- Kiểm tra xem Mã Hợp Đồng đã tồn tại chưa
     IF EXISTS (SELECT 1 FROM HopDong WHERE MaHopDong = p_MaHopDongs) THEN
        SET errorMessage = 'Hợp đồng đã tồn tại.';
      ELSE
        -- Kiểm tra và chèn dữ liệu
         IF EXISTS (SELECT 1 FROM KhachHang WHERE MaKhachHang = p_MaKhachHangs) AND
            EXISTS (SELECT 1 FROM NhanVien WHERE MaNhanVien = p_MaNhanViens) AND
            EXISTS (SELECT 1 FROM DichVu WHERE MaDichVu = p_MaDichVus) THEN
           
           -- Thực hiện INSERT
           INSERT INTO HopDong 
           VALUES (p_MaHopDongs, p_NgayLamHopDong, p_NgayKetThuc, p_TienDatCoc, p_MaNhanViens, p_MaKhachHangs, p_MaDichVus);
           SET errorMessage = 'Đã Thêm thành công';
        
           -- SELECT để trả về dữ liệu mới được chèn
         --  SELECT * FROM HopDong WHERE MaHopDong = p_MaHopDongs;
        -- ELSE
           -- SET errorMessage = 'Khách hàng, nhân viên hoặc dịch vụ không tồn tại.';
        -- END IF;
    -- END IF;

     In thông báo lỗi nếu có
    IF errorMessage IS NOT NULL THEN
        SELECT errorMessage AS ErrorMessage;
     END IF;
END //

DELIMITER ;

call sp_them_moi_hop_dong (12,'2003-12-2','2004-12-2',42323,1,2,4);
select * from HopDong where MaHopDong = 11;
select * from HopDong ;
drop procedure sp_them_moi_hop_dong;

-- thật sự hỏi chấm ?????????


-- câu 25: Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng 
-- hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng 
-- hop_dong ra giao diện console của database
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc 
-- ghi ở console
DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong
AFTER DELETE ON HopDong
FOR EACH ROW
BEGIN
    DECLARE total INT;
    DECLARE message_text VARCHAR(255);
    
    SELECT COUNT(*) INTO total FROM HopDong;
    SET message_text = CONCAT('Tổng số bản ghi còn lại là: ', total);
    
    SIGNAL SQLSTATE '45000' 
    SET MESSAGE_TEXT = message_text;
    select message_text;
END;
//
DELIMITER ;
drop trigger tr_xoa_hop_dong;
set SQL_SAFE_UPDATES = 0;
delete from HopDongChiTiet where MaHopDong = 2;
delete   from HopDong where MaHopDong = 2;
select * from HopDong; 
select * from HopDongChiTiet;
-- câu 26: Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc 
-- hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng
-- ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu 
-- không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn 
-- ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc 
-- ghi ở console.

	DELIMITER //
	create trigger tr_cap_nhat_hop_dong
	before update on HopDong
	for each row
	begin 
		declare message_text varchar(100);
		if old.NgayKetThuc < date_add(old.NgayLamHopDong,interval 2 day) then 
			signal sqlstate '45000'
			set message_text = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất 2 ngày. ';
            else 
			set message_text = 'Cập Nhật thành công';
		end if;
	end //
	DELIMITER ;

select * from HopDong ;

drop trigger tr_cap_nhat_hop_dong;
-- câu 27: Tạo Function thực hiện yêu cầu sau:
-- a. Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng 
-- với tổng tiền là > 2.000.000 VNĐ.
-- b. Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời 
-- gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp 
-- đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các 
-- khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không 
-- xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được 
-- truyền vào như là 1 tham số của function này.
-- câu 27 b
select Max(NgayKetThuc - NgayLamHopDong) as 'thoi_gian_lam_viec'
from HopDong hd

DELIMITER //
create function func_tinh_thoi_gian_hop_dong(ma_hop_dong varchar(50))
returns int
DETERMINISTIC
begin 
	declare day_max int;
    select Max(NgayKetThuc - NgayLamHopDong) into day_max
    from HopDong hd
    where hd.MaHopDong = ma_hop_dong;
    
    return day_max;
end 
//
DELIMITER ; 
select * from HopDong ;
drop function func_tinh_thoi_gian_hop_dong;
select func_tinh_thoi_gian_hop_dong(1);

-- câu 27 a
DELIMITER ;
drop function func_dem_dich_vu;
select func_dem_dich_vu(); 
DELIMITER //

CREATE FUNCTION func_dem_dich_vu()
RETURNS INT
DETERMINISTIC
BEGIN

    DECLARE count INT;

    SELECT COUNT(*) into count
    FROM (
        select d.MaDichVu, count(*) as "so_luong" , d.ChiPhiThue
	from dichvu d
	join hopdong h on d.MaDichVu = h.MaDichVu
	group by d.MaDichVu
	having (so_luong * d.ChiPhiThue) > 100
    ) AS subquery;

    RETURN count;
END //

DELIMITER ;
select func_dem_dich_vu();

-- câu 28: Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ 
-- được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 
-- dến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các 
-- bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ 
-- liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những 
-- bản liên quan khác.
DELIMITER //
create procedure sp_xoa_dich_vu_va_hd_room ()
begin
	declare ma_hop_dong varchar(40);
    select hd.MaHopDong 
    from HopDong hd 
    inner join DichVu dv on dv.MaDichVu = hd.MaDichVu
    inner join LoaiDichVu ldv on ldv.MaLoaiDichVu = dv.MaLoaiDichVu
    where  	(NgayLamHopDong > '2015-01-01' and NgayKetThuc < '2019-12-30') and
			ldv.TenLoaiDichVu = 'Room';
            
	delete from HopDongChiTiet where MaHopDong = ma_hop_dong;
    delete from HopDong where MaHopDong = ma_hop_dong;
end
//
DELIMITER ;

drop procedure sp_xoa_dich_vu_va_hd_room;

