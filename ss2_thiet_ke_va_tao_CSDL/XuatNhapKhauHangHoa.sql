create database if not exists XuatNhapHangHoa;
use XuatNhapHangHoa;
create table PhieuXuat(
 soPX int auto_increment primary key,
 ngayXuat date
);
create table VatTu(
 MaVTU varchar(100) primary key,
 TenVTU varchar(100)
);

create table ChiTietPhieuXuat(
	 soPX int auto_increment,
     MaVTU varchar(100),
     primary key(soPX,MaVTU),
     foreign key(soPX) references PhieuXuat(soPX),
     foreign key(MaVTU) references VatTu(MaVTU)
);
create table PhieuNhap(
 soPN int auto_increment primary key,
 ngayNhap date
);
create table ChiTietPhieuNhap(
	 soPN int auto_increment,
     MaVTU varchar(100),
     primary key(soPN,MaVTU),
     foreign key(soPN) references PhieuNhap(soPN),
     foreign key(MaVTU) references VatTu(MaVTU)
);
create table SoDienThoaiNCC(
	MaNCC_SDT varchar(100) primary key,
    SDT varchar(20)
);
create table NhaCungCap(
	MaNCC varchar(100) primary key,
    TenNCC varchar(100),
    MaNCC_SDT varchar(100),
    foreign key(MaNCC_SDT) references SoDienThoaiNCC(MaNCC_SDT)
);
create table DonDatHang(
	soDH int auto_increment primary key,
    ngayDH date,
    MaNCC varchar(100),
    foreign key(MaNCC) references NhaCungCap(MaNCC)
);
create table ChiTietDonHang(
	MaVTU varchar(100),
    soDH int,
    primary key(MaVTU,soDH),
    foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(soDH) references DonDatHang(soDH)
);
