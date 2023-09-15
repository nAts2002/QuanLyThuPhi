package models;

//import java.util.Date;

import java.sql.Date;


public class NopTienModel {

    private int idNopTien;
    private int maKhoanThu;
    private Date ngayThu;
    private double soTien;

    public NopTienModel() {
    }

//    public NopTienModel(int idNopTien, int maKhoanThu) {
//        this.idNopTien = idNopTien;
//        this.maKhoanThu = maKhoanThu;
//    }
//
//    public NopTienModel(int idNopTien, int maKhoanThu, Date ngayThu) {
//        this.idNopTien = idNopTien;
//        this.maKhoanThu = maKhoanThu;
//        this.ngayThu = ngayThu;
//    }

    public NopTienModel(int idNopTien, int maKhoanThu, Date ngayThu, double soTien) {
        this.idNopTien = idNopTien;
        this.maKhoanThu = maKhoanThu;
        this.ngayThu = ngayThu;
        this.soTien = soTien;
    }
    

    public int getIdNopTien() {
        return idNopTien;
    }

    public void setIdNopTien(int idNopTien) {
        this.idNopTien = idNopTien;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    
}
