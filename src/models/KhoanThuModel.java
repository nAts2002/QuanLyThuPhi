package models;

import java.sql.Date;

public class KhoanThuModel {

    private int maKhoanThu;
    private String tenKhoanThu;
    private double soTien;
    private int loaiKhoanThu;// tự nguyện là 1 bắt buộc là 0
    private Date hanNop;

    public KhoanThuModel() {
    }

//    public KhoanThuModel(String tenKhoanThu, double soTien, int loaiKhoanThu) {
//        this.tenKhoanThu = tenKhoanThu;
//        this.soTien = soTien;
//        this.loaiKhoanThu = loaiKhoanThu;
//    }

//    public KhoanThuModel(int maKhoanThu, String tenKhoanThu, double soTien, int loaiKhoanThu) {
//        this.maKhoanThu = maKhoanThu;
//        this.tenKhoanThu = tenKhoanThu;
//        this.soTien = soTien;
//        this.loaiKhoanThu = loaiKhoanThu;
//    }

    public KhoanThuModel(int maKhoanThu, String tenKhoanThu, double soTien, int loaiKhoanThu, Date hanNop) {
        this.maKhoanThu = maKhoanThu;
        this.tenKhoanThu = tenKhoanThu;
        this.soTien = soTien;
        this.loaiKhoanThu = loaiKhoanThu;
        this.hanNop = hanNop;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getLoaiKhoanThu() {
        return loaiKhoanThu;
    }

    public void setLoaiKhoanThu(int loaiKhoanThu) {
        this.loaiKhoanThu = loaiKhoanThu;
    }

    public Date getHanNop() {
        return hanNop;
    }

    public void setHanNop(Date hanNop) {
        this.hanNop = hanNop;
    }
    
}
