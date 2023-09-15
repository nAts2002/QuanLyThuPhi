package models;

import java.sql.Date;

public class TamVangModel {
    private int id_tam_vang;
    private int idNhanKhau;
    private String maGiayTamVang;
    private Date tuNgay;
    private Date denNgay;
    private String lydo;

    public TamVangModel() {
    }

    public TamVangModel(int id_tam_vang, int idNhanKhau, String maGiayTamVang, Date tuNgay, Date denNgay, String lydo) {
        this.id_tam_vang = id_tam_vang;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamVang = maGiayTamVang;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lydo = lydo;
    }
    public TamVangModel(int idNhanKhau, String maGiayTamVang, Date tuNgay, Date denNgay, String lydo) {
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamVang = maGiayTamVang;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lydo = lydo;
    }
    public int getId_tam_vang() {
        return id_tam_vang;
    }

    public void setId_tam_vang(int id_tam_vang) {
        this.id_tam_vang = id_tam_vang;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public String getMaGiayTamVang() {
        return maGiayTamVang;
    }

    public void setMaGiayTamVang(String maGiayTamVang) {
        this.maGiayTamVang = maGiayTamVang;
    }
    
}
