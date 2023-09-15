package models;

public class HoKhauModel {

    int maHo;
    String diaChi;
    String maKhuVuc;
    int soThanhVien;

    public HoKhauModel() {

    }

//    public HoKhauModel(int soThanhVien, String diaChi) {
//        this.soThanhvien = soThanhVien;
//        this.diaChi = diaChi;
//    }
    public HoKhauModel(int maHo, int soThanhVien, String diaChi) {
        this.maHo = maHo;
        this.soThanhVien=soThanhVien;
        this.diaChi = diaChi;
    }

    public HoKhauModel(int maHo, int soThanhVien, String diaChi, String maKhuVuc) {
        this.maHo = maHo;
        this.diaChi = diaChi;
        this.maKhuVuc = maKhuVuc;
        this.soThanhVien = soThanhVien;
    }
    
    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
    
}
