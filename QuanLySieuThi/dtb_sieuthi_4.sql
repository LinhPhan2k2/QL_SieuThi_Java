create database [QL_SIEUTHI_GG]
go
USE [QL_SIEUTHI_GG]
GO
/****** Object:  Table [dbo].[CHUCVU]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHUCVU](
	[MACV] [int] IDENTITY(1,1) NOT NULL,
	[TENCV] [nvarchar](50) NULL,
 CONSTRAINT [PK_CHUCVU] PRIMARY KEY CLUSTERED 
(
	[MACV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HANGHOA]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HANGHOA](
	[MAHH] [int] IDENTITY(1,1) NOT NULL,
	[MANH] [int] NOT NULL,
	[TENHH] [nvarchar](50) NULL,
	[DVT] [nvarchar](30) NULL,
	[GIABAN] [money] NULL,
	[SLTON] [int] NULL,
 CONSTRAINT [PK_HANGHOA] PRIMARY KEY CLUSTERED 
(
	[MAHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MAHD] [int] IDENTITY(1,1) NOT NULL,
	[MANV] [int] NOT NULL,
	[MAKH] [int]  NULL,
	[NGAYBAN] [datetime] NULL,
	[TONGTIEN] [money] NULL,
	[GIAMGIA] [float] NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[MAHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON_HANGHOA]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON_HANGHOA](
	[MAHD] [int] NOT NULL,
	[MAHH] [int] NOT NULL,
	[SOLUONG] [int] NULL,
	[GIABAN] [money] NULL,
	[THANHTIEN] [money] NULL,
 CONSTRAINT [PK_HOADON_HANGHOA] PRIMARY KEY CLUSTERED 
(
	[MAHD] ASC,
	[MAHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MAKH] [int] IDENTITY(1,1) NOT NULL,
	[TENKH] [nvarchar](50) NULL,
	[DIACHI] [nvarchar](50) NULL,
	[SODT] [varchar](20) NULL,
	[DIEM] [int] NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[MAKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHACUNGCAP]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHACUNGCAP](
	[MANCC] [int] IDENTITY(1,1) NOT NULL,
	[TENNCC] [nvarchar](100) NULL,
	[DIACHI] [nvarchar](200) NULL,
	[SODT] [varchar](20) NULL,
 CONSTRAINT [PK_NHACUNGCAP] PRIMARY KEY CLUSTERED 
(
	[MANCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MANV] [int] IDENTITY(1,1) NOT NULL,
	[MACV] [int] NOT NULL,
	[TENDN] [varchar](50) NULL,
	[TENNV] [nvarchar](50) NULL,
	[GTINH] [nvarchar](50) NULL,
	[SODT] [varchar](20) NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[MANV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHOMHANG]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHOMHANG](
	[MANH] [int] IDENTITY(1,1) NOT NULL,
	[TENNH] [nvarchar](50) NULL,
 CONSTRAINT [PK_NHOMHANG] PRIMARY KEY CLUSTERED 
(
	[MANH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEUNHAP]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEUNHAP](
	[MAPN] [int] IDENTITY(1,1) NOT NULL,
	[MANCC] [int] NOT NULL,
	[NGAYNHAP] [datetime] NULL,
	[TONGNHAP] [money] NULL,
 CONSTRAINT [PK_PHIEUNHAP] PRIMARY KEY CLUSTERED 
(
	[MAPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEUNHAP_HH]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEUNHAP_HH](
	[MAHH] [int] NOT NULL,
	[MAPN] [int] NOT NULL,
	[SOLUONG] [int] NULL,
	[GIANHAP] [money] NULL,
	[THANHTIEN] [money] NULL,
 CONSTRAINT [PK_PHIEUNHAP_HH] PRIMARY KEY CLUSTERED 
(
	[MAHH] ASC,
	[MAPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAIKHOAN]    Script Date: 4/20/2023 1:20:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAIKHOAN](
	[TENDN] [varchar](50) NOT NULL,
	[MANV] [int] NULL,
	[MATKHAU] [varchar](20) NULL,
	[QUYEN] [nvarchar](50) NULL,
 CONSTRAINT [PK_TAIKHOAN] PRIMARY KEY CLUSTERED 
(
	[TENDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CHUCVU] ON 

INSERT [dbo].[CHUCVU] ([MACV], [TENCV]) VALUES (1, N'Thu ngân')
INSERT [dbo].[CHUCVU] ([MACV], [TENCV]) VALUES (2, N'Quản lý')
INSERT [dbo].[CHUCVU] ([MACV], [TENCV]) VALUES (3, N'Kế toán')
SET IDENTITY_INSERT [dbo].[CHUCVU] OFF
GO
SET IDENTITY_INSERT [dbo].[HANGHOA] ON 

INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (1, 1, N'Bánh gạo Orion tảo biển', N'Gói', 23000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (2, 1, N'Bánh xốp Nabati phô mai', N'Hộp', 38000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (3, 1, N'Bách Snack khoai tây', N'Bịch', 12000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (4, 1, N'Bánh milo ăn sáng', N'Hộp', 12000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (5, 1, N'Bánh Cest Bon sợi thịt gà phô mai', N'Gói', 35000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (6, 1, N'Kẹo Alpen trà bưởi ', N'Gói', 12000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (7, 1, N'Kẹo dẻo Haribo', N'Gói', 25000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (8, 1, N'Kẹo dẻo Chupa Chups', N'Gói', 22000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (9, 1, N'Kẹo mềm sữa Sumika', N'Gói', 10000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (10, 1, N'Kẹo bạc hà Fresh Barley', N'Bịch', 15000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (11, 2, N'Nước hoa hồng Hatomugi 500ml', N'Chai', 160000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (12, 2, N'Sửa rửa mặt Nivea hoa hồng 100ml', N'Chai', 70000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (13, 2, N'Sửa rửa mặt Simple 150ml', N'Chai', 150000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (14, 2, N'Sửa rửa mặt Senka 90ml', N'Chai', 100000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (15, 2, N'Sửa rửa mặt Hadalabo 150ml', N'Chai', 200000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (16, 2, N'Sửa rửa mặt Cetaphil', N'Chai', 120000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (17, 2, N'Nước hoa hồng Simple 90ml', N'Chai', 100000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (18, 2, N'Sửa rửa mặt Oxy giảm mụn 100ml', N'Chai', 70000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (19, 2, N'Sửa rửa mặt Bio essence giảm mụn', N'Chai', 120000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (20, 2, N'Mặt nạ Senka 25ml', N'Cái', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (21, 2, N'Mặt nạ đất sét Vedette than tre', N'Hộp', 110000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (22, 2, N'Mặt nạ sữa chua Innisfree', N'Cái', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (23, 2, N'Mặt nạ giấy Vedette nha đam  ', N'Cái', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (24, 2, N'Sửa rửa mặt nam Nivea than tre 100ml', N'Chai', 100000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (25, 3, N'Bia Tiger lon 330ml', N'Lon', 19000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (26, 3, N'Bia Tiger thùng 24 lon x 330ml', N'Thùng', 390000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (27, 3, N'Bia Heineken lon 250ml', N'Lon', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (28, 3, N'Bia Heineken thùng 24 lon x 250ml', N'Thùng', 395000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (29, 3, N'Rượu vang đỏ Passion 750ml', N'Chai', 170000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (30, 3, N'Rượu vang nho Jacobs 700ml', N'Chai', 200000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (31, 3, N'Nước táo lên men Strongbow vị dâu 330ml ', N'Chai', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (33, 3, N'Nước táo lên men Strongbow vị mật ong chai 330ml', N'Chai', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (34, 3, N'Nước yến sào Khánh Hòa có đường 190ml', N'Lon', 10000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (35, 3, N'Nước yến sào SANEST cao cấp 8 hủ x 70ml', N'Hộp', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (36, 3, N'Nước yến Brand''s không đường 42g', N'Hộp', 70000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (37, 3, N'Nước yến sào Jusstnet 120ml', N'Chai', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (38, 3, N'Nước yến Việt lon 190ml', N'Lon', 10000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (39, 3, N'Trà ô long Tea+ chai 320ml', N'Chai', 9000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (40, 3, N'Nước ngọt pepsi chai 1.5L ', N'Chai', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (42, 3, N'Nước cam ép Twister 450ml', N'Chai', 10000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (43, 3, N'Nước tăng lực monster 24x 355ml', N'Thùng', 600000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (44, 3, N'Nước uống bị sữa chua Good 6x455ml', N'Lốc', 470000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (45, 3, N'Nước uống tăng lực Sting dâu 6x320ml', N'Lon', 500000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (46, 4, N'Cải ngọt đã lạt Coop Select 12g', N'Bịch', 13000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (47, 4, N'Cải bẹ xanh đà lạt Coop Select 12g', N'Bịch ', 13000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (48, 4, N'Rau tần ô 300g', N'Gói', 20000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (49, 4, N'Rau thơm hỗn hợp 100g', N'Gói', 12000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (50, 4, N'Giá đậu xanh 300g', N'Gói', 8000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (51, 4, N'Cải thảo Coop Select kg', N'Kí', 22000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (52, 4, N'Bông cải xanh Coop kg', N'Kí ', 40000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (53, 4, N'Khoai tây đà lạt - kg', N'Kí', 26000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (54, 4, N'Trái bí đao', N'Kí', 12000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (55, 4, N'Ớt chuông xanh đà lạt', N'Kí', 45000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (56, 4, N'Rau muống', N'Kí', 20000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (57, 4, N'Dưa leo 300g', N'Phần', 8000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (58, 4, N'Khổ qua trái ', N'Kí', 17000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (59, 4, N'Khoai lang mật', N'Kí', 32000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (60, 4, N'Củ hành tây Hà Lan', N'Kí ', 42000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (61, 4, N'Hành tím Ấn Độ', N'Kí', 32000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (62, 4, N'Hạt sen tươi Senta 200g', N'Gói', 50000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (63, 4, N'Tỏi lý sơn túi lưới kg ', N'Kí', 78000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (64, 4, N'Bắp trái siêu ngọt Coop', N'Trái ', 20000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (65, 4, N'Bí đỏ non - kg', N'Kí', 22000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (66, 4, N'Khoai mì ', N'Kí', 25000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (67, 4, N'Bí ngòi xanh', N'Kí', 22000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (68, 5, N'Sữa Nan Optipro 900g', N'Lon', 450000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (69, 5, N'Sữa Dielac Grow Plus 2+ 850g', N'Lon', 400000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (70, 5, N'Sữa NuTren dinh dưỡng y học 850g ', N'Lon ', 500000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (71, 5, N'Sữa Ensure Gold Vani 400g', N'Lon', 410000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (72, 5, N'Sữa Similac dinh dưỡng 900g', N'Hộp', 630000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (73, 5, N'Sữa Optimum Gold 850g ', N'Hộp', 325000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (74, 5, N'Sữa bột Dutch Lady  900g', N'Hộp', 195000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (75, 5, N'Sữa Dielac Alpha 2 lon 900g', N'Lon', 240000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (76, 5, N'Bột ăn dặm Nescle Cerelac cà rốt 200g', N'Hộp', 70000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (77, 5, N'Dầu ăn Vio gấc trẻ em 250ml', N'Chai', 42000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (78, 5, N'Dầu ăn dinh dưỡng KIDDY chai 250ml ', N'Chai', 38000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (79, 5, N'Cháo Tươi SaiGonFood thịt bằm 240g', N'Gói', 23000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (80, 5, N'Cháo Tươi SaiGonFood bò, đậu Hà Lan 240g', N'Gói', 27000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (81, 5, N'Cháo Tươi SGFood tôm,  gói 240g', N'Gói', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (82, 5, N'Tã quần Pampers size L 54 miếng - phiên bản Pororo', N'Gói', 325000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (83, 5, N'Tã dán Huggies Dry size S - 88 miếng ', N'Bịch', 300000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (84, 5, N'Tã dán Huggies Dry size XL - 62 miếng ', N'Bịch', 320000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (85, 5, N'Tã quần Bobby size L 38 miếng', N'Gói', 195000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (86, 5, N'Tã quần Huggies XXL 38 miếng', N'Bịch ', 380000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (87, 5, N'Miếng lót Bobby NB2 - 60 miếng ', N'Gói', 115000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (88, 5, N'Sữa tắm gội cho bé Carrie 700g ', N'Chai', 185000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (89, 5, N'Sữa tắm gội baby PUREN 750ml  ', N'Chai', 190000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (90, 5, N'Phấn thơm Babi Mild Sakura 180g ', N'Chai', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (91, 5, N'Sữa tắm JohnSon''s ', N'Chai', 120000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (92, 5, N'Dầu gội JonhSon Baby 800ml', N'Chai', 192000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (93, 5, N'Sữa tắm gội Puren 750ml ', N'Chai', 180000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (94, 5, N'Sữa tắm gội Carrie Junior 700g', N'Chai ', 140000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (95, 5, N'Sữa tắm gội Purite Baby cúc 500ml', N'Chai', 170000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (96, 5, N'Bình sữa Sliver Wesser size M 250ml', N'Cái', 125000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (97, 5, N'Bình sữa Pigeon Streamline PP', N'Cái', 155000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (98, 5, N'Khăn tắm Baby Bear 4 lớp 75x95cm', N'Cái', 44000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (99, 6, N'Cánh gà công nghiệp kg - BMF', N'Kí', 95000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (100, 6, N'Cánh gà khúc giữa 500g', N'Phần', 56000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (101, 6, N'Chân gà vĩ 500g', N'Vỉ', 32000.0000, 50)
GO
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (102, 6, N'Đùi gà góc tư 500g', N'Vỉ', 36000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (103, 6, N'Đùi gà góc tư nhập khẩu', N'Kí', 76000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (104, 6, N'Thịt heo xay đặc biệt kg', N'Kí', 170000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (105, 6, N'Sườn già heo', N'Kí', 118000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (106, 6, N'Sườn non heo kg', N'Kí', 150000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (107, 6, N'Xương ống heo Deli', N'Kí', 97900.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (108, 6, N'Móng giò heo Deli ', N'Kí', 160000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (109, 6, N'Chân giò heo rút xương Deli', N'Kí', 140000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (110, 6, N'Thịt nạc heo Deli ', N'Kí', 130000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (111, 6, N'Thịt vai heo Deli', N'Kí', 140000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (112, 6, N'Tôm thẻ (70 - 90 con/kg)', N'Kí', 200000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (113, 6, N'Đầu cá bóp kg', N'Kí', 170000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (114, 6, N'Cá rô phi làm sạch kg', N'Kí', 80000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (115, 6, N'Đầu cá Hồi kg', N'Kí ', 60000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (116, 6, N'Mình cá Bóp kg', N'Kí', 400000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (117, 6, N'Mình cá Hồi', N'Kí', 320000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (118, 6, N'Ếch làm sạch', N'Kí', 180000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (119, 6, N'Cá diêu hồng kh', N'Kí', 78000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (120, 6, N'Cá bạc má kg', N'Kí', 90000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (121, 6, N'Mình cá Thu kg', N'Kí', 200000.0000, 50)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (122, 7, N'Sửa rửa tay Select dưa gang 500ml', N'Chai', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (123, 7, N'Sửa rửa tay Select bưởi 500ml', N'Chai', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (124, 7, N'Sửa rửa tay LifeBuoy 450g', N'Chai', 78000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (125, 7, N'Sửa rửa tay Aquala trà xanh', N'Chai', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (126, 7, N'Khẩu trang y tế Happy 4 lớp 50 cái', N'Hộp', 42000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (127, 7, N'Khẩu trang y tế 4D Coop Select 10 cái ', N'Hộp', 31000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (128, 7, N'Gel rửa tay hương trà xanh 30ml', N'Chai', 15000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (129, 7, N'Nước súc miệng Colgate 500ml', N'Bộ', 155000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (130, 7, N'Nước súc miệng Listerine 500ml', N'Chai', 160000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (131, 7, N'Kem đánh răng CLoseup detox trắng răng 230g', N'Hộp', 50000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (132, 7, N'Kem đánh răng PS trà xanh 230g ', N'Hộp', 35000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (133, 7, N'Kem đánh răng PS hương Parking Soda 230g', N'Hộp', 40000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (134, 7, N'Kem đánh răng Sensodyne 160g', N'Hộp', 80000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (135, 7, N'Nước súc miệng PS trà xanh 500ml ', N'Chai', 75000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (136, 7, N'Nước súc miệng muối Select 550ml', N'Chai', 13000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (137, 7, N'Nước súc miệng Listerine Mint 100ml', N'Chai', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (138, 7, N'Bộ 3 bàn chải đánh răng PS than bạc', N'Bộ', 75000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (139, 7, N'Bộ 2 bản chải đánh răng Colgate ', N'Bộ ', 99000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (140, 7, N'Bộ 2 bàn chải đánh răng PS than bạc', N'Vỉ', 58000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (141, 7, N'Bộ 3 bàng chải đánh răng PS mềm mại ', N'Vỉ', 32000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (142, 7, N'Bà chải đánh răng Jordan Clean ', N'Cái', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (143, 7, N'Bộ 5 bàn chải đánh răng PS than bạc', N'Bộ', 105000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (144, 7, N'Bàn chải đánh răng Trisa', N'Cái', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (145, 2, N'Sữa dưỡng thể Vaseline sáng da 330ml', N'Chai', 150000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (146, 2, N'Sữa tắm dưỡng da hoa hồng 650ml', N'Chai', 190000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (147, 2, N'Sữa dưỡng thể Nivea 180ml ', N'Chai', 130000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (148, 2, N'Sữa tắm On the body White Pearl 1L', N'Chai', 200000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (149, 2, N'Sữa tắm Dove ngọt ngào 500g ', N'Chai ', 110000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (150, 2, N'Sữa tắm Hazaline yến mạch 1L', N'Chai', 82000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (151, 2, N'Sữa tắm Hazeline sữa ông chúa 800g', N'Chai', 98000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (152, 2, N'Sữa rửa mặt Pon''s Beauty 100g', N'Chai', 100000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (153, 2, N'Kem dưỡng da Hadalabo 50g', N'Hộp', 165000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (154, 2, N'Kem dưỡng trắng da ban đêm Pon''s 50g', N'Hộp', 136000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (155, 2, N'Kem dưỡng da ban đem Pon''s 50g', N'Hộp', 136000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (156, 2, N'Kem nghê Thorakao 7g', N'Hộp', 35000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (157, 2, N'Kem dưỡng da Olay chống lão hóa 50g', N'Hộp', 460000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (158, 2, N'Gel chống nắng Senka 80g', N'Chai', 168000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (159, 2, N'Kem chống nắng Biore', N'Chai', 102000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (160, 2, N'Kem chống nắng Sunplay 70g', N'Chai', 180000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (161, 2, N'Kem chống nắng Nivea 50g', N'Tuýp', 160000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (162, 8, N'Nước lau sàn sunLight hương hoa hồng túi 3.6kg ', N'Bịch', 75000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (163, 8, N'Nước lau sàn Sunlight tinh dầu thảo mộc 3.4kg ', N'Bịch', 75000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (164, 8, N'Nước lau bếp Sunlight Chanh 500ml', N'Chai', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (165, 8, N'Nước lau kính Sunlight siêu sạch 520ml', N'Chai', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (166, 8, N'Nước rửa chén Sunlight hương bưởi 3.6kg', N'Chai ', 120000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (167, 8, N'Nước rửa chén Sunlight hương trà chanh 3.4kg', N'Chai', 110000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (168, 8, N'Nước rửa chén Sunlight hương hoa anh đào 3.6kg', N'Chai', 120000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (169, 8, N'Xịt côn trùng JumBo 600ml', N'Chai', 70000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (170, 8, N'Xịt muỗi Raid hương cam 300ml', N'Chai', 47000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (171, 8, N'Nước rửa chén Surt hương tắc 1.5kg ', N'Cái', 35000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (172, 8, N'Nước rửa chén Sunlight thiên nhiên 2.1kg', N'Bịch', 78000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (173, 8, N'Nồi thủy tinh Luminarc Vitro 1L', N'Cái', 890000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (174, 8, N'Lẩu inox nắp kính Titha covi 24cm', N'Cái ', 113000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (175, 8, N'Chải xào Sunhouse 26cm ', N'Cái ', 285000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (176, 8, N'Chảo xào Sunhouse 30cm', N'Cái', 320000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (177, 8, N'Chảo chống dính Natura 28cm ', N'Cái', 289000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (178, 8, N'Nồi đất Tucbeghi G503 - 1.2L ', N'Cái ', 175000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (179, 8, N'Nồi inox Zebra 20cm ', N'Cái ', 580000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (180, 8, N'Bộ nòi xửng inox 3 đáy nắm kiểng 26cm ', N'Bộ', 1000000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (181, 8, N'Nồi hầm inox 430 HT Cook - 26 cm', N'Cái ', 245000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (182, 8, N'Chảo vân đá bếp từ Tithatic - 20cm', N'Cái', 205000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (183, 8, N'Chảo hộp kim nhôm vân đá Tithatic - 24cm ', N'Cái ', 320000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (184, 8, N'Nồi hợp kim Ecoramic -22cm ', N'Cái ', 570000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (185, 1, N'Bánh quy Cosy Marie 48g', N'Hộp', 8000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (186, 1, N'Bánh Danisa Cranbery 405g', N'Hộp', 150000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (187, 1, N'Bánh que mix vị ớt cay 150g ', N'Hộp', 42000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (188, 1, N'Bánh Chocopie Lotte trà sữa 336g', N'Hộp', 68000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (189, 1, N'Bánh kem xốp Tipo phô mai 180g', N'Hộp', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (190, 1, N'Bánh AFC rau củ 100g', N'Hộp', 15000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (191, 1, N'Bánh kem pho mai Maggic 108g', N'Gói', 10000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (192, 1, N'Bánh quế Cosy vị kem lá dứa 135g ', N'Gói', 15000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (193, 1, N'Kẹo singum Humba 56g ', N'Cái', 46000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (194, 1, N'Kẹo trái cây hộp giấy 180g ', N'Hộp', 60000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (195, 1, N'Kẹo chocolate SNICKERS 50g', N'Cái', 20000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (196, 1, N'Kẹo chocolate dạng viên đá 65g ', N'Gói', 24000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (197, 1, N'Kẹo Mentor Yohurt 90g', N'Hộp', 27000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (198, 1, N'Kẹo đậu phộng Choco', N'Gói', 22000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (199, 1, N'Kẹo Alpenliebe caramen 322g', N'Gói ', 30000.0000, 100)
INSERT [dbo].[HANGHOA] ([MAHH], [MANH], [TENHH], [DVT], [GIABAN], [SLTON]) VALUES (200, 1, N'Kẹo dẻo Boom Orion vị dâu ', N'Gói ', 17000.0000, 100)
SET IDENTITY_INSERT [dbo].[HANGHOA] OFF
GO
SET IDENTITY_INSERT [dbo].[HOADON] ON 

INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (1, 3, 1, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 1186000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (2, 3, 2, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 262000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (3, 3, 3, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 152000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (4, 5, 4, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 478000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (5, 5, 5, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 1445000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (6, 5, 6, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 784000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (7, 5, 7, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 3883000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (8, 5, 8, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 840000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (9, 5, 9, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 322000.0000)
INSERT [dbo].[HOADON] ([MAHD], [MANV], [MAKH], [NGAYBAN], [TONGTIEN]) VALUES (10, 5, 10, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 854000.0000)
SET IDENTITY_INSERT [dbo].[HOADON] OFF
GO
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (1, 1, 2, 23000.0000, 46000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (1, 2, 3, 38000.0000, 380000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (1, 100, 5, 56000.0000, 280000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (1, 108, 3, 160000.0000, 480000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (2, 56, 3, 20000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (2, 67, 3, 22000.0000, 66000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (2, 78, 2, 38000.0000, 76000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (2, 199, 2, 30000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (3, 10, 3, 15000.0000, 30000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (3, 50, 2, 8000.0000, 32000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (3, 55, 2, 45000.0000, 90000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (4, 6, 3, 12000.0000, 36000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (4, 7, 6, 25000.0000, 150000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (4, 8, 2, 22000.0000, 220000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (4, 10, 2, 15000.0000, 30000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (4, 187, 1, 42000.0000, 42000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (5, 170, 2, 47000.0000, 94000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (5, 180, 1, 1000000.0000, 1000000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (5, 186, 2, 150000.0000, 300000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (5, 200, 3, 17000.0000, 51000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (6, 142, 4, 30000.0000, 120000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (6, 166, 3, 120000.0000, 360000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (6, 185, 5, 8000.0000, 40000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (6, 188, 3, 68000.0000, 204000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (6, 189, 2, 30000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (7, 9, 3, 10000.0000, 30000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (7, 50, 5, 8000.0000, 32000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (7, 140, 5, 58000.0000, 290000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (7, 179, 6, 580000.0000, 3480000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (7, 200, 3, 17000.0000, 51000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (8, 2, 10, 38000.0000, 380000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (8, 3, 10, 12000.0000, 120000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (8, 8, 10, 22000.0000, 220000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (8, 144, 2, 30000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (8, 189, 2, 30000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (9, 20, 2, 30000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (9, 22, 3, 30000.0000, 90000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (9, 23, 4, 20000.0000, 80000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (9, 27, 3, 20000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (9, 50, 4, 8000.0000, 32000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (10, 27, 3, 20000.0000, 60000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (10, 172, 2, 78000.0000, 156000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (10, 177, 2, 289000.0000, 578000.0000)
INSERT [dbo].[HOADON_HANGHOA] ([MAHD], [MAHH], [SOLUONG], [GIABAN], [THANHTIEN]) VALUES (10, 199, 2, 30000.0000, 60000.0000)
GO
SET IDENTITY_INSERT [dbo].[KHACHHANG] ON 

INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (1, N'Phan Thái Quốc', N'Bình Thuận', N'0125642365', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (2, N'Huỳnh Thị Kiều Mai ', N'TP.HCM', N'0125648562', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (3, N'Lê Minh Kha', N'TP.HCM', N'0125471364', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (4, N'Biện Thanh Nhựt', N'Tây Ninh', N'0125694521', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (5, N'Hồ Phương Thảo', N'TP.HCM', N'0152846823', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (6, N'Nguyễn Trí Phúc', N'TP.HCM', N'0158784521', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (7, N'Phan Xuân Khánh', N'Bình Thuận', N'0356216985', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (8, N'Huỳnh Như Ý ', N'TP.HCM', N'0365215658', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (9, N'Phan Gia Thịnh', N'TP.HCM', N'0356985421', NULL)
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SODT], [DIEM]) VALUES (10, N'Đỗ Thị Hồng Hiệp', N'TP.HCM', N'0254655895', NULL)
SET IDENTITY_INSERT [dbo].[KHACHHANG] OFF
GO
SET IDENTITY_INSERT [dbo].[NHACUNGCAP] ON 

INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (1, N'Công ty cổ phần thực phẩm Hữu Nghị', N'122 Định Công,  phường Định Công, quận Hoàng Mai, Hà Nội', N'02546649451')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (2, N'Công ty TNHH Phạm Nguyên', N'Số 613, Đường Trần Đại Nghĩa, Phường Tân Tạo A, quận Bình Tân, thành phố Hồ Chí Minh', N'028 3765 7979')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (3, N'Nhà phân phối mỹ phẩm Bici Cosmetic', N'285/26 Cách mạng tháng 8, Phường 12, Q.10, TPHCM – 97C, Lê Quang Định, Phường 14, Q.Bình Thạnh, TPHCM.', N'025 4584 5876')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (4, N'Nhà phân phối mỹ phẩm BO Shop', N'111B Nguyễn Lâm, Phường 3, Quận Bình Thạnh, TP Hồ Chí Minh', N'0125 256 154')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (5, N'Nhà phân phối mỹ phẩm Thế Giới Skinfood', N'100 Hoàng Hoa Thám p12 Q Tân Bình TPHCM', N' 1900 636 510')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (6, N'Công ty TNHH Nước giải khát SUNTORY PEPSICO Việt Nam', N'Tầng 5, Khách sạn Sheraton, 88 Đồng Khởi, Quận 1, TP. HCM', N'08 3821 9437')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (7, N'Cửa hàng Đà Lạt GAP Store', N'152 Đường Điện Biên Phủ, Phường 6, Quận 3, TP. HCM', N'(08) 38 202 720')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (8, N'Cửa hàng rau sạch Fresh from Farm', N'15A/53 Lê Thánh Tôn, Phường Bến Nghé, Quận 1, TP. HCM', N'0982 277 739 ')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (9, N'CÔNG TY TNHH THẾ GIỚI TUỔI THƠ SNB', N'Nhà 3, Lô 4D, Đường Trung Yên 10A, KĐT Trung Yên, P. Trung Hòa, Q. Cầu Giấy, Thành Phố Hà Nội (TP.HN)', N'0912 436 060')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (10, N'Thực Phẩm Đại Thuận - Công Ty Cổ Phần Hàng Tiêu Dùng Đại Thuận', N'Số 42 Củ Chi, P. Vĩnh Hải, TP. Nha Trang, Khánh Hòa', N'83836825')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (11, N'Thủy Hải Sản Sài Thành Foods - Công Ty Cổ Phần Sài Thành Foods', N'Lô III-22 Đường 19/5A, KCN Tân Bình, P. Tây Thạnh, Q. Tân Phú, Tp. Hồ Chí Minh (TPHCM)', N'0944 868 800')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (12, N'Gia Dụng Vietcook - Công Ty TNHH Thương Mại Và Đầu Tư Gia Phú', N'Số 61, Hẻm 72/73/40, phố Quan Nhân, Phường Nhân Chính, Quận Thanh Xuân, Hà Nội', N'0903 443 003')
INSERT [dbo].[NHACUNGCAP] ([MANCC], [TENNCC], [DIACHI], [SODT]) VALUES (13, N'Công Ty TNHH Xuất Nhập Khẩu Gia Huy', N'317 Huỳnh Tấn Phát, P. Tân Thuận Đông, Q. 7, Tp. Hồ Chí Minh', N'0909.644.600')
SET IDENTITY_INSERT [dbo].[NHACUNGCAP] OFF
GO
SET IDENTITY_INSERT [dbo].[NHANVIEN] ON 

INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (3, 1, N'linhpta', N'Phan Thị Ánh Linh', N'Nữ', N'0356112332')
INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (4, 2, N'trungnh', N'Nguyễn Hữu Trung', N'Nam', N'0359445115')
INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (5, 1, N'anhpnc', N'Phan Ngọc Châu Anh', N'Nữ', N'0165212326')
INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (6, 3, N'thuttx', N'Trần Thị Xuân Thu', N'Nữ', N'0125362546')
INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (7, 3, N'huypd', N'Phan Đan Huy', N'Nam', N'0125623654')
INSERT [dbo].[NHANVIEN] ([MANV], [MACV], [TENDN], [TENNV], [GTINH], [SODT]) VALUES (8, 3, N'linhlinh', N'Phan Khánh Linh', N'Nữ', N'82163721')
SET IDENTITY_INSERT [dbo].[NHANVIEN] OFF
GO
SET IDENTITY_INSERT [dbo].[NHOMHANG] ON 

INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (1, N'Bánh kẹo')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (2, N'Mỹ phẩm')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (3, N'Đồ uống')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (4, N'Rau củ, trái cây')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (5, N'Mẹ và bé (sữa bỉm - phụ kiện)')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (6, N'Thịt, cá, hải sản')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (7, N'Chăm sóc cá nhân')
INSERT [dbo].[NHOMHANG] ([MANH], [TENNH]) VALUES (8, N'Đồ dùng gia đình')
SET IDENTITY_INSERT [dbo].[NHOMHANG] OFF
GO
SET IDENTITY_INSERT [dbo].[PHIEUNHAP] ON 

INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (1, 1, CAST(N'2023-02-02T00:00:00.000' AS DateTime), 20538000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (2, 2, CAST(N'2023-02-15T00:00:00.000' AS DateTime), 57816000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (3, 3, CAST(N'2022-12-17T00:00:00.000' AS DateTime), 96030000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (4, 4, CAST(N'2022-11-18T00:00:00.000' AS DateTime), 86940000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (5, 5, CAST(N'2022-11-30T00:00:00.000' AS DateTime), 211068000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (6, 6, CAST(N'2023-02-05T00:00:00.000' AS DateTime), 289377000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (7, 7, CAST(N'2023-05-05T00:00:00.000' AS DateTime), 13860000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (8, 8, CAST(N'2023-05-05T00:00:00.000' AS DateTime), 38250000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (9, 9, CAST(N'2023-02-03T00:00:00.000' AS DateTime), 648252000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (10, 10, CAST(N'2023-05-03T00:00:00.000' AS DateTime), 138689100.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (11, 11, CAST(N'2023-05-20T00:00:00.000' AS DateTime), 176022000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (12, 12, CAST(N'2022-02-03T00:00:00.000' AS DateTime), 131769000.0000)
INSERT [dbo].[PHIEUNHAP] ([MAPN], [MANCC], [NGAYNHAP], [TONGNHAP]) VALUES (13, 13, CAST(N'2022-08-03T00:00:00.000' AS DateTime), 572418000.0000)
SET IDENTITY_INSERT [dbo].[PHIEUNHAP] OFF
GO
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (1, 1, 110, 20700.0000, 2277000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (2, 1, 120, 34200.0000, 4104000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (3, 1, 110, 10800.0000, 1188000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (4, 1, 110, 10800.0000, 1188000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (5, 1, 110, 31500.0000, 3465000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (6, 1, 110, 10800.0000, 1188000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (7, 1, 110, 22500.0000, 2475000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (8, 1, 110, 19800.0000, 2178000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (9, 1, 110, 9000.0000, 990000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (10, 1, 110, 13500.0000, 1485000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (11, 3, 110, 144000.0000, 15840000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (12, 3, 110, 63000.0000, 6930000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (13, 3, 110, 135000.0000, 14850000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (14, 3, 110, 90000.0000, 9900000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (15, 3, 110, 180000.0000, 19800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (16, 3, 110, 108000.0000, 11880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (17, 3, 110, 90000.0000, 9900000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (18, 3, 110, 63000.0000, 6930000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (19, 4, 110, 108000.0000, 11880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (20, 4, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (21, 4, 110, 99000.0000, 10890000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (22, 4, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (23, 4, 110, 18000.0000, 1800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (24, 4, 110, 90000.0000, 9900000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (25, 6, 110, 17100.0000, 1881000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (26, 6, 110, 351000.0000, 38610000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (27, 6, 110, 18000.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (28, 6, 110, 355500.0000, 39105000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (29, 6, 110, 153000.0000, 16830000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (30, 6, 110, 180000.0000, 19800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (31, 6, 110, 18000.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (33, 6, 110, 18000.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (34, 6, 110, 9000.0000, 990000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (35, 6, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (37, 6, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (38, 6, 110, 9000.0000, 990000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (39, 6, 110, 8100.0000, 891000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (40, 6, 110, 18000.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (42, 6, 110, 9000.0000, 990000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (43, 6, 110, 540000.0000, 59400000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (44, 6, 110, 423000.0000, 46530000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (45, 6, 110, 450000.0000, 49500000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (46, 7, 100, 11700.0000, 1170000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (47, 7, 100, 11700.0000, 1170000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (48, 7, 100, 18000.0000, 1800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (49, 7, 100, 10800.0000, 1080000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (50, 7, 100, 7200.0000, 720000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (51, 7, 100, 19800.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (52, 7, 100, 36000.0000, 3600000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (53, 7, 100, 23400.0000, 2340000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (54, 8, 100, 10800.0000, 1080000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (55, 8, 100, 40500.0000, 4050000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (56, 8, 100, 18000.0000, 1800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (57, 8, 100, 7200.0000, 720000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (58, 8, 100, 15300.0000, 1530000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (59, 8, 100, 28800.0000, 2880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (60, 8, 100, 37800.0000, 3780000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (61, 8, 100, 28800.0000, 2880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (62, 8, 100, 45000.0000, 4500000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (63, 8, 100, 70200.0000, 7020000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (64, 8, 100, 18000.0000, 1800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (65, 8, 100, 19800.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (66, 8, 100, 22500.0000, 2250000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (67, 8, 100, 19800.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (68, 9, 110, 405000.0000, 44550000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (69, 9, 110, 360000.0000, 39600000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (70, 9, 110, 450000.0000, 49500000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (71, 9, 110, 369000.0000, 40590000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (72, 9, 110, 567000.0000, 62370000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (73, 9, 110, 292500.0000, 32175000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (74, 9, 110, 175500.0000, 19305000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (75, 9, 110, 216000.0000, 23760000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (76, 9, 110, 63000.0000, 6930000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (77, 9, 110, 37800.0000, 4158000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (78, 9, 110, 34200.0000, 3762000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (79, 9, 110, 20700.0000, 2277000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (80, 9, 110, 24300.0000, 2673000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (81, 9, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (82, 9, 110, 292500.0000, 32175000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (83, 9, 110, 270000.0000, 29700000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (84, 9, 110, 288000.0000, 31680000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (85, 9, 110, 175500.0000, 19305000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (86, 9, 110, 342000.0000, 37620000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (87, 9, 110, 103500.0000, 11385000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (88, 9, 110, 166500.0000, 18315000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (89, 9, 110, 171000.0000, 18810000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (90, 9, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (91, 9, 110, 108000.0000, 11880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (92, 9, 110, 172800.0000, 19008000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (93, 9, 110, 162000.0000, 17820000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (94, 9, 110, 126000.0000, 13860000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (95, 9, 110, 153000.0000, 16830000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (96, 9, 110, 112500.0000, 12375000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (97, 9, 110, 139500.0000, 15345000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (98, 9, 110, 39600.0000, 4356000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (99, 10, 110, 85500.0000, 9405000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (100, 10, 110, 50400.0000, 5544000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (101, 10, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (102, 10, 110, 32400.0000, 3564000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (103, 10, 110, 68400.0000, 7524000.0000)
GO
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (104, 10, 110, 153000.0000, 16830000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (105, 10, 110, 106200.0000, 11682000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (106, 10, 110, 135000.0000, 14850000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (107, 10, 110, 88110.0000, 9692100.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (108, 10, 110, 144000.0000, 15840000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (109, 10, 110, 126000.0000, 13860000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (110, 10, 110, 117000.0000, 12870000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (111, 10, 110, 126000.0000, 13860000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (112, 11, 110, 180000.0000, 19800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (113, 11, 110, 153000.0000, 16830000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (114, 11, 110, 72000.0000, 7920000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (115, 11, 110, 54000.0000, 5940000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (116, 11, 110, 360000.0000, 39600000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (117, 11, 110, 288000.0000, 31680000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (118, 11, 110, 162000.0000, 17820000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (119, 11, 110, 70200.0000, 7722000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (120, 11, 110, 81000.0000, 8910000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (121, 11, 110, 180000.0000, 19800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (122, 12, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (123, 12, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (124, 12, 110, 70200.0000, 7722000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (125, 12, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (126, 12, 110, 37800.0000, 4158000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (127, 12, 110, 27900.0000, 3069000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (128, 12, 110, 13500.0000, 1485000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (129, 12, 110, 139500.0000, 15345000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (130, 12, 110, 144000.0000, 15840000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (131, 12, 110, 45000.0000, 4950000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (132, 12, 110, 31500.0000, 3465000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (133, 12, 110, 36000.0000, 3960000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (134, 12, 110, 72000.0000, 7920000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (135, 12, 110, 67500.0000, 7425000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (136, 12, 110, 11700.0000, 1287000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (137, 12, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (138, 12, 110, 67500.0000, 7425000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (139, 12, 110, 89100.0000, 9801000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (140, 12, 110, 52200.0000, 5742000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (141, 12, 110, 28800.0000, 3168000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (142, 12, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (143, 12, 110, 94500.0000, 10395000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (144, 12, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (145, 4, 110, 135000.0000, 14850000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (146, 4, 110, 171000.0000, 18810000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (147, 4, 110, 117000.0000, 12870000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (148, 5, 110, 180000.0000, 19800000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (149, 5, 110, 99000.0000, 10890000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (150, 5, 110, 73800.0000, 8118000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (151, 5, 110, 88200.0000, 9702000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (152, 5, 110, 90000.0000, 9900000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (153, 5, 110, 148500.0000, 16335000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (154, 5, 110, 122400.0000, 13464000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (155, 5, 110, 122400.0000, 13464000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (156, 5, 110, 31500.0000, 3465000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (157, 5, 110, 414000.0000, 45540000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (158, 5, 110, 151200.0000, 16632000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (159, 5, 110, 91800.0000, 10098000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (160, 5, 110, 162000.0000, 17820000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (161, 5, 110, 144000.0000, 15840000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (162, 13, 110, 67500.0000, 7425000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (163, 13, 110, 67500.0000, 7425000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (164, 13, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (165, 13, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (166, 13, 110, 108000.0000, 11880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (167, 13, 110, 99000.0000, 10890000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (168, 13, 110, 108000.0000, 11880000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (169, 13, 110, 63000.0000, 6930000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (170, 13, 110, 42300.0000, 4653000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (171, 13, 110, 31500.0000, 3465000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (172, 13, 110, 70200.0000, 7722000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (173, 13, 110, 801000.0000, 88110000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (174, 13, 110, 101700.0000, 11187000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (175, 13, 110, 256500.0000, 28215000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (176, 13, 110, 288000.0000, 31680000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (177, 13, 110, 260100.0000, 28611000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (178, 13, 110, 157500.0000, 17325000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (179, 13, 110, 522000.0000, 57420000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (180, 13, 110, 900000.0000, 99000000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (181, 13, 110, 220500.0000, 24255000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (182, 13, 110, 184500.0000, 20295000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (183, 13, 110, 288000.0000, 31680000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (184, 13, 110, 513000.0000, 56430000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (185, 2, 110, 7200.0000, 792000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (186, 2, 110, 135000.0000, 14850000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (187, 2, 110, 37800.0000, 4158000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (188, 2, 110, 61200.0000, 6732000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (189, 2, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (190, 2, 110, 13500.0000, 1485000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (191, 2, 110, 9000.0000, 990000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (192, 2, 110, 13500.0000, 1485000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (193, 2, 110, 41400.0000, 4554000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (194, 2, 110, 54000.0000, 5940000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (195, 2, 110, 18000.0000, 1980000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (196, 2, 110, 21600.0000, 2376000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (197, 2, 110, 24300.0000, 2673000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (198, 2, 110, 19800.0000, 2178000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (199, 2, 110, 27000.0000, 2970000.0000)
INSERT [dbo].[PHIEUNHAP_HH] ([MAHH], [MAPN], [SOLUONG], [GIANHAP], [THANHTIEN]) VALUES (200, 2, 110, 15300.0000, 1683000.0000)
GO
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'anhpnc', 5, N'anhpnc123', NULL)
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'huypd', 7, N'huypd123', NULL)
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'linhlinh', NULL, N'linhlinh123', NULL)
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'linhpta', 3, N'linhpta123', NULL)
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'thuttx', 6, N'thuttx123', NULL)
INSERT [dbo].[TAIKHOAN] ([TENDN], [MANV], [MATKHAU], [QUYEN]) VALUES (N'trungnh', 4, N'trungnh123', NULL)
GO
ALTER TABLE [dbo].[HANGHOA]  WITH CHECK ADD  CONSTRAINT [FK_HANGHOA_NHOM_HH_NHOMHANG] FOREIGN KEY([MANH])
REFERENCES [dbo].[NHOMHANG] ([MANH])
GO
ALTER TABLE [dbo].[HANGHOA] CHECK CONSTRAINT [FK_HANGHOA_NHOM_HH_NHOMHANG]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_HD_KH_KHACHHAN] FOREIGN KEY([MAKH])
REFERENCES [dbo].[KHACHHANG] ([MAKH])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_HD_KH_KHACHHAN]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_NV_HD_NHANVIEN] FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_NV_HD_NHANVIEN]
GO
ALTER TABLE [dbo].[HOADON_HANGHOA]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_H_HOADON_HA_HANGHOA] FOREIGN KEY([MAHH])
REFERENCES [dbo].[HANGHOA] ([MAHH])
GO
ALTER TABLE [dbo].[HOADON_HANGHOA] CHECK CONSTRAINT [FK_HOADON_H_HOADON_HA_HANGHOA]
GO
ALTER TABLE [dbo].[HOADON_HANGHOA]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_H_HOADON_HA_HOADON] FOREIGN KEY([MAHD])
REFERENCES [dbo].[HOADON] ([MAHD])
GO
ALTER TABLE [dbo].[HOADON_HANGHOA] CHECK CONSTRAINT [FK_HOADON_H_HOADON_HA_HOADON]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK_NHANVIEN_CV_NV_CHUCVU] FOREIGN KEY([MACV])
REFERENCES [dbo].[CHUCVU] ([MACV])
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_CV_NV_CHUCVU]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK_NHANVIEN_TK_NV2_TAIKHOAN] FOREIGN KEY([TENDN])
REFERENCES [dbo].[TAIKHOAN] ([TENDN])
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_TK_NV2_TAIKHOAN]
GO
ALTER TABLE [dbo].[PHIEUNHAP]  WITH CHECK ADD  CONSTRAINT [FK_PHIEUNHA_PN_NCC_NHACUNGC] FOREIGN KEY([MANCC])
REFERENCES [dbo].[NHACUNGCAP] ([MANCC])
GO
ALTER TABLE [dbo].[PHIEUNHAP] CHECK CONSTRAINT [FK_PHIEUNHA_PN_NCC_NHACUNGC]
GO
ALTER TABLE [dbo].[PHIEUNHAP_HH]  WITH CHECK ADD  CONSTRAINT [FK_PHIEUNHA_PHIEUNHAP_HANGHOA] FOREIGN KEY([MAHH])
REFERENCES [dbo].[HANGHOA] ([MAHH])
GO
ALTER TABLE [dbo].[PHIEUNHAP_HH] CHECK CONSTRAINT [FK_PHIEUNHA_PHIEUNHAP_HANGHOA]
GO
ALTER TABLE [dbo].[PHIEUNHAP_HH]  WITH CHECK ADD  CONSTRAINT [FK_PHIEUNHA_PHIEUNHAP_PHIEUNHA] FOREIGN KEY([MAPN])
REFERENCES [dbo].[PHIEUNHAP] ([MAPN])
GO
ALTER TABLE [dbo].[PHIEUNHAP_HH] CHECK CONSTRAINT [FK_PHIEUNHA_PHIEUNHAP_PHIEUNHA]
GO
ALTER TABLE [dbo].[TAIKHOAN]  WITH CHECK ADD  CONSTRAINT [FK_TAIKHOAN_TK_NV_NHANVIEN] FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TAIKHOAN] CHECK CONSTRAINT [FK_TAIKHOAN_TK_NV_NHANVIEN]
GO
