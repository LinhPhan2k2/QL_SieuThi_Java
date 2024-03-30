


go
--1 Cập nhật số lượng tồn hàng hóa sau khi thêm 1 hàng hóa vào hóa đơn
CREATE TRIGGER capNhatSoLuongKhiThemHH ON HOADON_HANGHOA AFTER INSERT AS 
BEGIN
	UPDATE HANGHOA
	SET SLTON = SLTON - (
		SELECT SOLUONG
		FROM inserted
		WHERE MAHH = HANGHOA.MAHH
	)
	FROM HANGHOA
	JOIN inserted ON HANGHOA.MAHH = inserted.MAHH
END
go
--2 Cập nhật số lượng tồn hàng hóa sau khi thêm hàng hóa sau khi hủy hàng hóa
create TRIGGER capNhatSoLuongKhiHuyHangHoa ON HOADON_HANGHOA FOR DELETE AS 
BEGIN
	UPDATE HANGHOA
	SET SLTON = SLTON + (SELECT TOP 1 SOLUONG FROM deleted WHERE MAHH = HANGHOA.MAHH )
	FROM HANGHOA 
	JOIN deleted ON HANGHOA.MAHH = deleted.MAHH
END
go

--3 Cập nhật số lượng tồn hàng hóa sau khi cập nhật số lượng hàng hóa trong lúc lập hóa đơn
CREATE TRIGGER capNhatSoLuongKhiCapNhatSL on HOADON_HANGHOA after update AS
BEGIN
   UPDATE HANGHOA SET SLTON=SLTON - (SELECT TOP 1 SOLUONG FROM inserted WHERE MAHH = HANGHOA.MAHH )+(SELECT TOP 1 SOLUONG FROM deleted WHERE MAHH = HANGHOA.MAHH)
   FROM HANGHOA 
   JOIN deleted ON HANGHOA.MAHH = deleted.MAHH
end




drop trigger Tinh_ThanhTien_HoaDon
-- tính thành tiền hóa đơn
    CREATE trigger Tinh_ThanhTien_HoaDon
    on HOADON_HANGHOA
    for insert, update
    as
    begin
    	update 
    		HOADON_HANGHOA
    	set 
    		THANHTIEN = I.SOLUONG * HH.GIABAN,
			GIABAN = HH.GIABAN
    	from 
    		inserted I,
    		HANGHOA HH, 
    		HOADON_HANGHOA CTHD
    	where 
    		(HH.MAHH = I.MAHH)
    		and (HH.MAHH = CTHD.MAHH)
    end





drop trigger capNhatSoLuongKhiThemHH
drop trigger capNhatSoLuongKhiHuyHangHoa
drop trigger capNhatSoLuongKhiCapNhatSL


insert into HOADON_HANGHOA values(1,7,3,13000,null)
select * from HANGHOA
select * from HOADON_HANGHOA

select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH 
from HANGHOA, NHOMHANG 
where HANGHOA.MANH=NHOMHANG.MANH
and TENHH like N'Kẹo %'

select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH 
from HANGHOA, NHOMHANG 
where HANGHOA.MANH=NHOMHANG.MANH
and NHOMHANG.MANH=1

select tennh from NHOMHANG

------------------------------Trigger Linh-----------------------------------------------
--1.Tính tổng tiền nhập hàng
CREATE trigger Tinh_TongTien_PhieuNhap
    on PHIEUNHAP_HH
    for insert, update
    as
    begin
    	update 
    		PHIEUNHAP
    	set 
			TONGNHAP =(I.SOLUONG * I.GIANHAP) + TONGNHAP*1.0	
    	from 
    		inserted I,
			PHIEUNHAP PH,
    		PHIEUNHAP_HH CTPN
    	where 
    		(PH.MAPN = I.MAPN) 
    end
--2.tính thành tiền nhập hàng
CREATE trigger Tinh_ThanhTien_PhieuNhap
    on PHIEUNHAP_HH
    for insert, update
    as
    begin
    	update 
    		PHIEUNHAP_HH
    	set 
    		THANHTIEN = I.SOLUONG * I.GIANHAP
    	from 
    		inserted I,
			HANGHOA HH,
    		PHIEUNHAP_HH CTPN
    	where 
    		(HH.MAHH = I.MAHH)
    		and (HH.MAHH = CTPN.MAHH)
    end
---------------------------------------------
--------ràng buộc đăng kí tài khoản nhân viên--------------------------
alter table nhanvien
add constraint UNI_TENDN Unique(TENDN)

----------------trigger cập nhật manv bảng tài khoản khi thêm 1 nhân viên--------------------
CREATE trigger cap_nhat_tendn
    on NHANVIEN
    for insert, update
    as
    begin
    	update 
    		TAIKHOAN
    	set 
    		MANV = I.MANV 
    	from 
    		inserted I,
    		NHANVIEN NV, 
    		TAIKHOAN TK
    	where 
    		(NV.MANV = I.MANV)
    		and (NV.TENDN = TK.TENDN)
    end

-----------------------------trigger xóa nhân viên xóa luôn bảng tài khoản---------------------------
----------------------------chỉnh cascase cho 2 mqh 1-1-----------------------------------------

/*drop trigger xoa_nv_tk
CREATE trigger xoa_nv_tk
    on NHANVIEN
    for delete
    as
    begin
    	delete 
    		TAIKHOAN
    	from 
    		deleted d,
    		TAIKHOAN TK,
			NHANVIEN NV
    	where 
    		(TK.MANV = d.MANV) and NV.TENDN = TK.TENDN
    		
    end

CREATE TRIGGER `food_before_delete`     
  AFTER DELETE ON `food`     
  FOR EACH ROW     
BEGIN
  DELETE FROM apple
  WHERE apple.iduser=NEW.iduser;

  DELETE FROM orange
  WHERE orange.iduser=NEW.iduser; 
END*/



	select * from TAIKHOAN
	select * from NHANVIEN
	---------------------Trigger cập nhật số lượng sp khi nhập hàng--------------
	CREATE TRIGGER trg_DatHang ON PHIEUNHAP_HH AFTER INSERT AS 
BEGIN
	UPDATE HANGHOA
	SET SLTON = SLTON + (
		SELECT SOLUONG
		FROM inserted
		WHERE MAHH = HANGHOA.MAHH
	)
	FROM HANGHOA
	JOIN inserted ON HANGHOA.MAHH = inserted.MAHH
END
GO