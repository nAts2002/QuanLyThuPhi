
package models;

import java.sql.Date;

public class KhaiTuModel {
    private int id;
    private int soGIayKhaiTu;
    private int idNguoiKhai;
    private int idNguoiChet;
    private Date ngayKhai;
    private Date ngayChet;
    private String lyDoChet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoGIayKhaiTu() {
        return soGIayKhaiTu;
    }

    public void setSoGIayKhaiTu(int soGIayKhaiTu) {
        this.soGIayKhaiTu = soGIayKhaiTu;
    }

    public int getIdNguoiKhai() {
        return idNguoiKhai;
    }

    public void setIdNguoiKhai(int idNguoiKhai) {
        this.idNguoiKhai = idNguoiKhai;
    }

    public int getIdNguoiChet() {
        return idNguoiChet;
    }

    public void setIdNguoiChet(int idNguoiChet) {
        this.idNguoiChet = idNguoiChet;
    }

    public Date getNgayKhai() {
        return ngayKhai;
    }

    public void setNgayKhai(Date ngayKhai) {
        this.ngayKhai = ngayKhai;
    }

    public Date getNgayChet() {
        return ngayChet;
    }

    public void setNgayChet(Date ngayChet) {
        this.ngayChet = ngayChet;
    }

    public String getLyDoChet() {
        return lyDoChet;
    }

    public void setLyDoChet(String lyDoChet) {
        this.lyDoChet = lyDoChet;
    }

    public KhaiTuModel() {
    }

    public KhaiTuModel(int id, int soGIayKhaiTu, int idNguoiKhai, int idNguoiChet, Date ngayKhai, Date ngayChet, String lyDoChet) {
        this.id = id;
        this.soGIayKhaiTu = soGIayKhaiTu;
        this.idNguoiKhai = idNguoiKhai;
        this.idNguoiChet = idNguoiChet;
        this.ngayKhai = ngayKhai;
        this.ngayChet = ngayChet;
        this.lyDoChet = lyDoChet;
    }
    public KhaiTuModel(int soGIayKhaiTu, int idNguoiKhai, int idNguoiChet, Date ngayKhai, Date ngayChet, String lyDoChet) {
        this.soGIayKhaiTu = soGIayKhaiTu;
        this.idNguoiKhai = idNguoiKhai;
        this.idNguoiChet = idNguoiChet;
        this.ngayKhai = ngayKhai;
        this.ngayChet = ngayChet;
        this.lyDoChet = lyDoChet;
    }
    
}
