create database thu_vien;
use thu_vien;

create table sach 
(
	id_sach int auto_increment primary key,
    ma_sach varchar(10),
    ten_sach varchar(50),
    tac_gia varchar(50),
    mo_ta varchar(50),
    so_luong varchar(50)
);

create table hoc_sinh 
(
	id_hs int auto_increment primary key, 
	ma_hs varchar(50),
    ho_ten varchar(50),
    lop varchar(50)
);



create table the_muon_sach
(
	id_muon_sach int auto_increment primary key,
    id_sach int,
    ma_muon_sach  varchar(50),
    id_hs int,
    trang_thai boolean,
    ngay_muon varchar(50),
    ngay_tra varchar(50),
    foreign key (id_sach) references sach(id_sach),
    foreign key (id_hs) references hoc_sinh(id_hs)
)



select s.*,tms.id_muon_sach,tms.ma_muon_sach from sach as s inner join the_muon_sach as tms on s.id_sach = tms.id_sach;
select max(id_muon_sach)+ 1 as id_ms_max from the_muon_sach;
select id_hs, ho_ten from hoc_sinh;

insert into the_muon_sach(id_muon_sach,id_sach,id_hs,ma_muon_sach,trang_thai,ngay_muon,ngay_tra) 
values (?,?,?,?,?,?,?);

select tms.ma_muon_sach,s.ten_sach,s.tac_gia,hs.ho_ten,hs.lop,tms.ngay_muon,tms.ngay_tra from the_muon_sach as tms inner join sach as s on tms.id_sach = s.id_sach
						inner join hoc_sinh as hs on hs.id_hs = tms.id_hs
