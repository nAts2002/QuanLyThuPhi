package models;

import java.sql.Date;

public class TamTruModel {
    private int id;
    private int idNhanKhau;
    private String maGiayTamTru;
    private String noiTamTru;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;

    public TamTruModel() {
    }

    public TamTruModel(int id, int idNhanKhau, String maGiayTamTru, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamTru = maGiayTamTru;
        this.noiTamTru = noiTamTru;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
    }
    public TamTruModel(int idNhanKhau, String maGiayTamTru, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamTru = maGiayTamTru;
        this.noiTamTru = noiTamTru;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }

    public void setMaGiayTamTru(String maGiayTamTru) {
        this.maGiayTamTru = maGiayTamTru;
    }

    public String getNoiTamTru() {
        return noiTamTru;
    }

    public void setNoiTamTru(String noiTamTru) {
        this.noiTamTru = noiTamTru;
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

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}
