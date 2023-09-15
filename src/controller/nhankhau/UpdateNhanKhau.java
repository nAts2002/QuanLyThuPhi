package controller.nhankhau;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import models.ChuHoModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.QuanHeModel;
import services.ChuHoService;
import services.HoKhauService;
import services.NhanKhauService;
import services.QuanHeService;

public class UpdateNhanKhau {

    private int maNhanKhau;
    private boolean isChuHo=false;
    @FXML
    private TextField tfMaNhanKhau;
    @FXML
    private DatePicker tfTuoi;
    @FXML
    private TextField tfTenNhanKhau;
    @FXML
    private TextField tfSoDienThoai;
    @FXML
    private TextField tfSoCMND;
    @FXML
    private TextField tfGioiTinh;
    @FXML
    private TextField tfSoHoChieu;
    @FXML
    private TextField tfQuocTich;
    @FXML
    private TextField tfGhiChu;
    @FXML
    private TextField tfMaHoKhau;
    @FXML
    private TextField tfDanToc;
    @FXML
    private TextField tfNoiThuongTru;
    @FXML
    private TextField tfNoiSinh;
    @FXML
    private TextField tfNguyenQuan;
    @FXML
    private TextField tfTonGiao;
    @FXML
    private TextField tfDiaChiHienTai;
    @FXML
    private TextField tfQuanHe;

    private NhanKhauModel nhanKhauModel;

    public NhanKhauModel getNhanKhauModel() {
        return nhanKhauModel;
    }

    public void setNhanKhauModel(NhanKhauModel nhanKhauModel) throws ClassNotFoundException, SQLException {
        this.nhanKhauModel = nhanKhauModel;

        maNhanKhau = nhanKhauModel.getId();
        tfMaNhanKhau.setText(Integer.toString(maNhanKhau));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(nhanKhauModel.getTuoi(), formatter);
        tfTuoi.setValue(date);

        tfTenNhanKhau.setText(nhanKhauModel.getTen());
        tfSoDienThoai.setText(nhanKhauModel.getSdt());
        tfSoCMND.setText(nhanKhauModel.getCmnd());
        tfGioiTinh.setText(nhanKhauModel.getGioiTinh());
        tfSoHoChieu.setText(nhanKhauModel.getSoHoChieu());
        tfQuocTich.setText(nhanKhauModel.getQuocTich());
        tfGhiChu.setText(nhanKhauModel.getGhiChu());

        // tao map anh xa gia tri Id sang maHo
        Map<Integer, Integer> mapIdToMaho = new HashMap<>();
        List<QuanHeModel> listQuanHe = new QuanHeService().getListQuanHe();
        listQuanHe.forEach(quanhe -> {
            mapIdToMaho.put(quanhe.getIdThanhVien(), quanhe.getMaHo());
        });
        List<ChuHoModel> listchuho = new ChuHoService().getListChuHo();
        listchuho.forEach(chuho -> {
            mapIdToMaho.put(chuho.getIdChuHo(), chuho.getMaHo());
        });
        int maHoKhau = mapIdToMaho.get(maNhanKhau);
        tfMaHoKhau.setText(Integer.toString(maHoKhau));

        tfDanToc.setText(nhanKhauModel.getDanToc());

        List<ChuHoModel> listChuHoModels = new ChuHoService().getListChuHo();
        for (ChuHoModel chuho : listChuHoModels) {
            if (chuho.getIdChuHo() == Integer.parseInt(tfMaNhanKhau.getText())) {
                tfQuanHe.setText("Chủ hộ");
                isChuHo = true;
                tfQuanHe.setEditable(false);
                break;
            }
        }
        if (!isChuHo) {
            Map<Integer, String> mapIdToQuanHe = new HashMap<>();// có thể đặt là biến cục bộ
            List<QuanHeModel> listQuanHe1 = new QuanHeService().getListQuanHe(maHoKhau);
            listQuanHe.forEach(quanhe -> {
                mapIdToQuanHe.put(quanhe.getIdThanhVien(), quanhe.getQuanHe());
            });
            String quanhe = mapIdToQuanHe.get(maNhanKhau);
            tfQuanHe.setText(quanhe);
        }

        tfNoiThuongTru.setText(nhanKhauModel.getNoiThuongTru());
        tfNoiSinh.setText(nhanKhauModel.getNoiSinh());
        tfNguyenQuan.setText(nhanKhauModel.getNguyenQuan());
        tfTonGiao.setText(nhanKhauModel.getTonGiao());
        tfDiaChiHienTai.setText(nhanKhauModel.getDiaChiHienTai());
    }

    public void updateNhanKhau(ActionEvent event) throws ClassNotFoundException, SQLException {
        // khai bao mot mau de so sanh
        Pattern pattern;

        // kiem tra ten nhap vao
        // ten nhap vao la chuoi tu 1 toi 50 ki tu
        if (tfTenNhanKhau.getText().length() >= 50 || tfTenNhanKhau.getText().length() <= 1) {
            Alert alert = new Alert(AlertType.WARNING, "Hãy nhập vào 1 tên hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // kiem tra tuoi nhap vao
        // tuoi nhap vao nhieu nhat la 1 so co 3 chu so
        if (tfTuoi.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập ngày sinh", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // kiem tra cmnd nhap vao
        // cmnd nhap vao phai la mot day so tu 1 toi 20 so
        pattern = Pattern.compile("\\d{1,20}");
        if (!pattern.matcher(tfSoCMND.getText()).matches()) {
            Alert alert = new Alert(AlertType.WARNING, "Hãy nhập vào CMND hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // kiem tra sdt nhap vao
        // SDT nhap vao phai khong chua chu cai va nho hon 15 chu so
        pattern = Pattern.compile("\\d{0,15}");
        if (!pattern.matcher(tfSoDienThoai.getText()).matches()) {
            Alert alert = new Alert(AlertType.WARNING, "Hãy nhập vào SĐT hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        String tenString = tfTenNhanKhau.getText();
        String tuoiInt = tfTuoi.getValue().toString();//int tuoiInt = Integer.parseInt(tfTuoi.getText());
        String cmndString = tfSoCMND.getText();
        String sdtString = tfSoDienThoai.getText();
        String gioitinhString = tfGioiTinh.getText();
        String noisinhString = tfNoiSinh.getText();
        String nguyenquanString = tfNguyenQuan.getText();
        String dantocString = tfDanToc.getText();
        String quoctichString = tfQuocTich.getText();
        String sohochieuString = tfSoHoChieu.getText();
        String noithuongtruString = tfNoiThuongTru.getText();
        String dc_hientaiString = tfDiaChiHienTai.getText();
        String tongiaoString = tfTonGiao.getText();
        String ghichuString = tfGhiChu.getText();
        String quanheString = tfQuanHe.getText();

        // xoa di nhan khau hien tai va them vao nhan khau vua cap nhat
        new NhanKhauService().update(maNhanKhau, cmndString, tenString, tuoiInt, sdtString, gioitinhString, noisinhString, nguyenquanString, dantocString, quoctichString, sohochieuString, noithuongtruString, dc_hientaiString, tongiaoString, ghichuString);
        if(!isChuHo){
            int maho =Integer.parseInt(tfMaHoKhau.getText());
            int idthanhvien=Integer.parseInt(tfMaNhanKhau.getText());
            new QuanHeService().update(maho, idthanhvien, quanheString);
        }
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
}
