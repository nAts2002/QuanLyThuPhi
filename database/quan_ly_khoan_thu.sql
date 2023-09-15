-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 25, 2023 lúc 07:27 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_khoan_thu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chu_ho`
--

CREATE TABLE `chu_ho` (
  `MaHo` int(11) NOT NULL,
  `IDChuHo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chu_ho`
--

INSERT INTO `chu_ho` (`MaHo`, `IDChuHo`) VALUES
(1, 1),
(2, 3),
(3, 6),
(4, 4),
(5, 8),
(6, 9),
(7, 10),
(8, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ho_khau`
--

CREATE TABLE `ho_khau` (
  `MaHo` int(11) NOT NULL,
  `SoThanhVien` int(11) NOT NULL,
  `DiaChi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maKhuVuc` varchar(100) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `ho_khau`
--

INSERT INTO `ho_khau` (`MaHo`, `SoThanhVien`, `DiaChi`, `maKhuVuc`) VALUES
(1, 2, 'Ha Noi', ''),
(2, 1, 'VN', 'VN'),
(3, 1, 'alo', 'null'),
(4, 2, 'VN', '123456'),
(5, 1, 'skfhsdjk', '123456'),
(6, 1, 'VN', NULL),
(7, 1, 'VN', NULL),
(8, 1, 'VN', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khai_tu`
--

CREATE TABLE `khai_tu` (
  `id` int(11) NOT NULL,
  `soGiayKhaiTu` int(11) NOT NULL,
  `idNguoiKhai` int(11) NOT NULL,
  `idNguoiChet` int(11) NOT NULL,
  `ngayKhai` date NOT NULL,
  `ngayChet` date NOT NULL,
  `lyDoChet` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khai_tu`
--

INSERT INTO `khai_tu` (`id`, `soGiayKhaiTu`, `idNguoiKhai`, `idNguoiChet`, `ngayKhai`, `ngayChet`, `lyDoChet`) VALUES
(4, 321312465, 1, 2, '2023-02-25', '2023-02-25', 'bệnh nặng'),
(5, 12345646, 3, 9, '2023-02-25', '2023-02-25', 'bệnh'),
(6, 324564, 3, 10, '2023-02-25', '2023-02-16', 'bệnh nặng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoan_thu`
--

CREATE TABLE `khoan_thu` (
  `MaKhoanThu` int(11) NOT NULL,
  `TenKhoanThu` varchar(100) NOT NULL,
  `SoTien` double DEFAULT NULL,
  `LoaiKhoanThu` int(11) NOT NULL,
  `hanNop` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khoan_thu`
--

INSERT INTO `khoan_thu` (`MaKhoanThu`, `TenKhoanThu`, `SoTien`, `LoaiKhoanThu`, `hanNop`) VALUES
(1, 'Vệ sinh', 6000, 1, '2023-02-28'),
(2, 'Nước', 50000, 1, '2023-02-28'),
(3, 'Điện', 100000, 1, '2023-02-28'),
(4, 'Ủng hộ ngày thương binh-liệt sỹ 27/07', 0, 0, '2023-03-11'),
(5, 'Ủng hộ ngày tết thiếu nhi', 0, 0, '2023-02-28'),
(6, 'Ủng hộ vì người nghèo', 0, 0, '2023-02-28'),
(7, 'Ủng hộ MU vô địch', 0, 0, '2023-02-28');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_khau`
--

CREATE TABLE `nhan_khau` (
  `ID` int(11) NOT NULL,
  `CMND` varchar(20) DEFAULT NULL,
  `Ten` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tuoi` date NOT NULL,
  `SDT` varchar(15) DEFAULT NULL,
  `gioiTinh` varchar(100) NOT NULL,
  `noiSinh` varchar(100) NOT NULL,
  `nguyenQuan` varchar(100) NOT NULL,
  `danToc` varchar(100) NOT NULL,
  `quocTich` varchar(100) NOT NULL,
  `soHoChieu` varchar(100) NOT NULL,
  `noiThuongTru` varchar(100) NOT NULL,
  `diaChiHienTai` varchar(100) NOT NULL,
  `tonGiao` varchar(100) NOT NULL,
  `ghiChu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nhan_khau`
--

INSERT INTO `nhan_khau` (`ID`, `CMND`, `Ten`, `tuoi`, `SDT`, `gioiTinh`, `noiSinh`, `nguyenQuan`, `danToc`, `quocTich`, `soHoChieu`, `noiThuongTru`, `diaChiHienTai`, `tonGiao`, `ghiChu`) VALUES
(1, '1', 'Nguyễn Văn A', '1983-02-01', '', 'Nam', 'Ha Noi', 'Ha Noi', 'Kinh', 'VN', '2312346', 'Ha Noi', 'HN', 'Không', ''),
(2, '2', 'Nguyễn Văn B', '2023-02-01', '123456', '2123546', 'sjdfksjdkl', 'sjfdskj', 'kjljdsfds', 'sfsdhfkj', '132564', 'dsjlksj', 'sfdkjsfjs', 'sjfsdkfj', ''),
(3, '2', 'Phạm Thị A', '1990-09-09', '2', 'Nữ', 'afds', 'fadfa', 'afds', 'VN', '1235467', 'afds', 'sdfgdf', 'dfsfds', ''),
(4, '4', 'Phạm Văn B', '2010-02-11', '123456', 'Nam', 'mnjg', 'yiouio', 'Kinh', 'VN', '123456', 'zcbvb', 'tyui', 'ưetyu', ''),
(5, '5', 'Phạm Thị C', '2012-02-16', '123456', 'Nữ', 'ádfs', 'fghfher', 'fsdsfasf', '546789', '123456', 'ádfsdf', 'ẻgdfg', 'ẻgregre', ''),
(6, '6', 'Trần Văn D', '1234-05-06', '3254', 'fghf', 'fghgfh', 'fghgfh', 'fghfh', 'fhfghg', '231134', 'fghfh', 'fghfghfg', 'fghfg', 'fghhgf'),
(7, '7', 'Phạm văn C', '2023-02-01', '13216546', 'Nam', 'skfjkls', 'jsdfklsjf', 'sàdshkjdfs', 'fdahkj', '1234564', 'sjfsdklfjsl', 'ádfjklsfjs', 'sdkfjlskl', ''),
(8, '8', 'jlfgdf', '2023-02-02', '123156', 'Nam', 'sfsdf', 'ádfs', 'jasdfkl', 'skfhskj', '123456', 'ádfdsasdfs', 'sadfsdf', 'ádfsd', ''),
(9, '9', 'kjhkj', '2023-02-15', '123456', 'nam', 'kjhjkhk', 'jkhkjhkl', 'jhkhjk', '4564656', '124665', '65465', 'jbjkhjk', 'jkhjk', ''),
(10, '12312564', 'kjlhkjh', '2023-02-16', '2165465', 'nam', 'kjhkjk', 'khjkhk', 'hjgjhg', '321246', '1456456', 'kjhkj', 'nbmbjh', 'hiuyuiyi', 'Đã mất');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nop_tien`
--

CREATE TABLE `nop_tien` (
  `IDNopTien` int(11) NOT NULL,
  `MaKhoanThu` int(11) NOT NULL,
  `NgayThu` date DEFAULT NULL,
  `soTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nop_tien`
--

INSERT INTO `nop_tien` (`IDNopTien`, `MaKhoanThu`, `NgayThu`, `soTien`) VALUES
(1, 1, '2023-02-25', 6000),
(1, 2, '2023-02-08', 50000),
(4, 1, '2023-02-23', 6000),
(5, 7, '2023-02-25', 100000),
(6, 6, '2023-02-25', 100000),
(7, 3, '2023-02-25', 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quan_he`
--

CREATE TABLE `quan_he` (
  `MaHo` int(11) NOT NULL,
  `IDThanhVien` int(11) NOT NULL,
  `QuanHe` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `quan_he`
--

INSERT INTO `quan_he` (`MaHo`, `IDThanhVien`, `QuanHe`) VALUES
(1, 2, 'con'),
(4, 5, 'em gái');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tam_tru`
--

CREATE TABLE `tam_tru` (
  `id` int(11) NOT NULL,
  `idNhanKhau` int(100) NOT NULL,
  `maGiayTamTru` varchar(100) NOT NULL,
  `noiTamTru` varchar(100) NOT NULL,
  `tuNgay` date NOT NULL,
  `denNgay` date NOT NULL,
  `lyDo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tam_tru`
--

INSERT INTO `tam_tru` (`id`, `idNhanKhau`, `maGiayTamTru`, `noiTamTru`, `tuNgay`, `denNgay`, `lyDo`) VALUES
(2, 3, '#abc', 'HN', '2023-03-01', '2023-03-31', 'jhkdsu'),
(3, 1, '465465', 'hn', '2023-02-09', '2023-02-10', 'saklfsd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tam_vang`
--

CREATE TABLE `tam_vang` (
  `id_tam_vang` int(11) NOT NULL,
  `idNhanKhau` int(11) NOT NULL,
  `maGiayTamVang` varchar(100) NOT NULL,
  `tuNgay` date NOT NULL,
  `denNgay` date NOT NULL,
  `lydo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tam_vang`
--

INSERT INTO `tam_vang` (`id_tam_vang`, `idNhanKhau`, `maGiayTamVang`, `tuNgay`, `denNgay`, `lydo`) VALUES
(6, 3, '546456', '2023-02-07', '2023-02-22', 'di'),
(7, 1, '123456', '2023-02-01', '2023-02-03', 'đi chơi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `passwd` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`ID`, `username`, `passwd`) VALUES
(1, 'admin', '1'),
(2, 'hung', '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chu_ho`
--
ALTER TABLE `chu_ho`
  ADD PRIMARY KEY (`MaHo`,`IDChuHo`),
  ADD KEY `chu_ho_2` (`IDChuHo`);

--
-- Chỉ mục cho bảng `ho_khau`
--
ALTER TABLE `ho_khau`
  ADD PRIMARY KEY (`MaHo`);

--
-- Chỉ mục cho bảng `khai_tu`
--
ALTER TABLE `khai_tu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idNguoiChet` (`idNguoiChet`),
  ADD KEY `idNguoiKhai` (`idNguoiKhai`);

--
-- Chỉ mục cho bảng `khoan_thu`
--
ALTER TABLE `khoan_thu`
  ADD PRIMARY KEY (`MaKhoanThu`);

--
-- Chỉ mục cho bảng `nhan_khau`
--
ALTER TABLE `nhan_khau`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `nop_tien`
--
ALTER TABLE `nop_tien`
  ADD PRIMARY KEY (`IDNopTien`,`MaKhoanThu`),
  ADD KEY `nop_tien_2` (`MaKhoanThu`);

--
-- Chỉ mục cho bảng `quan_he`
--
ALTER TABLE `quan_he`
  ADD PRIMARY KEY (`MaHo`,`IDThanhVien`),
  ADD KEY `quan_he_2` (`IDThanhVien`);

--
-- Chỉ mục cho bảng `tam_tru`
--
ALTER TABLE `tam_tru`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idNhanKhau` (`idNhanKhau`);

--
-- Chỉ mục cho bảng `tam_vang`
--
ALTER TABLE `tam_vang`
  ADD PRIMARY KEY (`id_tam_vang`),
  ADD KEY `idNhanKhau` (`idNhanKhau`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ho_khau`
--
ALTER TABLE `ho_khau`
  MODIFY `MaHo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `khai_tu`
--
ALTER TABLE `khai_tu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `khoan_thu`
--
ALTER TABLE `khoan_thu`
  MODIFY `MaKhoanThu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `nhan_khau`
--
ALTER TABLE `nhan_khau`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `tam_tru`
--
ALTER TABLE `tam_tru`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `tam_vang`
--
ALTER TABLE `tam_vang`
  MODIFY `id_tam_vang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chu_ho`
--
ALTER TABLE `chu_ho`
  ADD CONSTRAINT `chu_ho_1` FOREIGN KEY (`MaHo`) REFERENCES `ho_khau` (`MaHo`),
  ADD CONSTRAINT `chu_ho_2` FOREIGN KEY (`IDChuHo`) REFERENCES `nhan_khau` (`ID`);

--
-- Các ràng buộc cho bảng `khai_tu`
--
ALTER TABLE `khai_tu`
  ADD CONSTRAINT `khai_tu_ibfk_1` FOREIGN KEY (`idNguoiChet`) REFERENCES `nhan_khau` (`ID`),
  ADD CONSTRAINT `khai_tu_ibfk_2` FOREIGN KEY (`idNguoiKhai`) REFERENCES `nhan_khau` (`ID`);

--
-- Các ràng buộc cho bảng `nop_tien`
--
ALTER TABLE `nop_tien`
  ADD CONSTRAINT `nop_tien_1` FOREIGN KEY (`IDNopTien`) REFERENCES `nhan_khau` (`ID`),
  ADD CONSTRAINT `nop_tien_2` FOREIGN KEY (`MaKhoanThu`) REFERENCES `khoan_thu` (`MaKhoanThu`);

--
-- Các ràng buộc cho bảng `quan_he`
--
ALTER TABLE `quan_he`
  ADD CONSTRAINT `quan_he_1` FOREIGN KEY (`MaHo`) REFERENCES `ho_khau` (`MaHo`),
  ADD CONSTRAINT `quan_he_2` FOREIGN KEY (`IDThanhVien`) REFERENCES `nhan_khau` (`ID`);

--
-- Các ràng buộc cho bảng `tam_tru`
--
ALTER TABLE `tam_tru`
  ADD CONSTRAINT `tam_tru_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`);

--
-- Các ràng buộc cho bảng `tam_vang`
--
ALTER TABLE `tam_vang`
  ADD CONSTRAINT `tam_vang_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
