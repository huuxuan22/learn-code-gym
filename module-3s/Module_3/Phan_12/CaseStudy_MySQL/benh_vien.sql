create database benh_vien;
use benh_vien;

create table benh_nhan
(
	id_bn int auto_increment primary key,
    ma_bn varchar(50)  not null,
    ten_bn varchar(50)
);

create table benh_an
(
	id_ba int auto_increment primary key,
    id_bn int,
    ma_ba varchar(50) not null,
    ngay_xuat_vien varchar(50),
    ngay_ra_vien varchar(50),
    ly_do varchar(50),
    foreign key (id_bn) references benh_nhan(id_bn)
)

select ba.*, bn.ten_bn,bn.ma_bn
from benh_an as ba  inner join benh_nhan as bn on ba.id_bn = bn.id_bn;


delete from benh_an where id_ba = ?;
DELIMITER //
CREATE PROCEDURE insert_into_benh_vien(ma_benh_nhan varchar(50),ten_benh_nhan varchar(50),ma_ba varchar(50),ten_ba varchar(50),ngay_xuat_vien varchar(50),ngay_ra_vien varchar(50),ly_do varchar(50))
BEGIN
    insert into benh_nhan(id_bn,ma_bn,ten_bn)
    values(ma_benh_nhan,ten_benh_nhan);
    insert into benh_an(ma_ba,ten_ba,ngay_xuat_vien,ngay_ra_vien,ly_do)
    values (ma_ba,ten_ba,ngay_xuat_vien,ngay_ra_vien,ly_do);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_benh_vien(id_ba int ,id_bn int,ma_benh_nhan varchar(50),ma_ba varchar(50),ten_benh_nhan varchar(50),ngay_xuat_vien varchar(50),ngay_ra_vien varchar(50),ly_do varchar(50))
BEGIN
    update benh_nhan set ma_bn = ma_benh_nhan , ten_bn = ten_benh_nhan where id_bn = id_bn;
    update benh_an set ma_ba = ma_ba, ngay_xuat_vien = ngay_xuat_vien,ngay_ra_vien = ngay_ra_vien,ly_do = Ly_do where id_ba =id_ba;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE insert_into_benh_vien(id_bn int ,id_ba int,ma_benh_nhan varchar(50),ma_ba varchar(50),ten_benh_nhan varchar(50),ngay_xuat_vien varchar(50),ngay_ra_vien varchar(50),ly_do varchar(50))
BEGIN
    insert into benh_nhan values (id_bn,ten_benh_nhan,ma_bn);
    insert into benh_an values (id_ba,id_bn,ma_ba,ngay_xuat_vien,ngay_ra_vien,ly_do);
END //
DELIMITER ;

select * from benh_nhan;
select * from benh_an;

DELETE FROM benh_nhan WHERE ma_bn = 'BA-005';
SET SQL_SAFE_UPDATES = 0;

select max(id_bn) + 1 as idMax from benh_nhan;
select max(id_ba) + 1 as idMax from benh_an;



