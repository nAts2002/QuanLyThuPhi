package models;

public class NhanKhauModel {

    int id;
    String cmnd;
    String ten;
    String tuoi;
    String sdt;
    String gioiTinh;
    String noiSinh;
    String nguyenQuan;
    String danToc;
    String quocTich;
    String soHoChieu;
    String noiThuongTru;
    String diaChiHienTai;
    String tonGiao;
    String ghiChu;

    public NhanKhauModel() {
    }

    public NhanKhauModel(String cmnd, String ten, String tuoi, String sdt) {
        this.cmnd = cmnd;
        this.ten = ten;
        this.tuoi = tuoi;
        this.sdt = sdt;
    }

    public NhanKhauModel(int id, String cmnd, String ten, String tuoi, String sdt) {
        this.id = id;
        this.cmnd = cmnd;
        this.ten = ten;
        this.tuoi = tuoi;
        this.sdt = sdt;
    }

    public NhanKhauModel(int id, String cmnd, String ten, String tuoi, String sdt, String ghiChu) {
        this.id = id;
        this.cmnd = cmnd;
        this.ten = ten;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.ghiChu = ghiChu;
    }

    public NhanKhauModel(int id, String cmnd, String ten, String tuoi, String sdt, String gioiTinh, String noiSinh, String nguyenQuan, String danToc, String quocTich, String soHoChieu, String noiThuongTru, String diaChiHienTai, String tonGiao, String ghiChu) {
        this.id = id;
        this.cmnd = cmnd;
        this.ten = ten;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.soHoChieu = soHoChieu;
        this.noiThuongTru = noiThuongTru;
        this.diaChiHienTai = diaChiHienTai;
        this.tonGiao = tonGiao;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getSoHoChieu() {
        return soHoChieu;
    }

    public void setSoHoChieu(String soHoChieu) {
        this.soHoChieu = soHoChieu;
    }

    public String getNoiThuongTru() {
        return noiThuongTru;
    }

    public void setNoiThuongTru(String noiThuongTru) {
        this.noiThuongTru = noiThuongTru;
    }

    public String getDiaChiHienTai() {
        return diaChiHienTai;
    }

    public void setDiaChiHienTai(String diaChiHienTai) {
        this.diaChiHienTai = diaChiHienTai;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
