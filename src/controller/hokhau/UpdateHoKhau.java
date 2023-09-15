package controller.hokhau;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

public class UpdateHoKhau {

    @FXML
    private TextField tfSDT;
    @FXML
    private TextField tfTenChuHo;
    @FXML
    private TextField tfDiaChi;
    @FXML
    private TextField tfMaHo;
    @FXML
    private TextField tfSoThanhVien;
    @FXML
    private TextField tfMaKhuVuc;
    @FXML
    private TextField tfMaChuHo;
    @FXML
    private DatePicker tfTuoi;
    @FXML
    private TextField tfCMND;
    @FXML
    private TextField tfGioiTinh;
    @FXML
    private TextField tfSoHoChieu;
    @FXML
    private TextField tfQuocTich;
    @FXML
    private TextField tfDanToc;
    @FXML
    private TextField tfNoiTru;
    @FXML
    private TextField tfNoiSinh;
    @FXML
    private TextField tfNguyenQuan;
    @FXML
    private TextField tfTonGiao;
    @FXML
    private TextField tfDiaChiHienTai;
    @FXML
    private TextField tfGhiChu;

    private HoKhauModel hoKhauModel;
    private NhanKhauModel chuHoModel;

    public void setHoKhauModel(HoKhauModel hoKhauModel) throws ClassNotFoundException, SQLException {
        this.hoKhauModel = hoKhauModel;

        tfMaHo.setText(Integer.toString(hoKhauModel.getMaHo()));
        tfMaKhuVuc.setText(hoKhauModel.getMaKhuVuc());
        tfDiaChi.setText(hoKhauModel.getDiaChi());
        tfSoThanhVien.setText(Integer.toString(hoKhauModel.getSoThanhVien()));

        Map<Integer, Integer> mapMahoToId = new HashMap<>();
        List<ChuHoModel> listChuHo = new ChuHoService().getListChuHo();
        listChuHo.forEach(chuho -> {
            mapMahoToId.put(chuho.getMaHo(), chuho.getIdChuHo());
        });
        int idChuHo = mapMahoToId.get(hoKhauModel.getMaHo());
        chuHoModel = new NhanKhauService().getNhanKhau(idChuHo);

        tfMaChuHo.setText(Integer.toString(chuHoModel.getId()));
        tfTenChuHo.setText(chuHoModel.getTen());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(chuHoModel.getTuoi(), formatter);
        tfTuoi.setValue(date);
        
        tfSDT.setText(chuHoModel.getSdt());
        tfCMND.setText(chuHoModel.getCmnd());
        tfGioiTinh.setText(chuHoModel.getGioiTinh());
        tfSoHoChieu.setText(chuHoModel.getSoHoChieu());
        tfQuocTich.setText(chuHoModel.getQuocTich());
        tfDanToc.setText(chuHoModel.getDanToc());
        tfNoiTru.setText(chuHoModel.getNoiThuongTru());
        tfNoiSinh.setText(chuHoModel.getNoiSinh());
        tfNguyenQuan.setText(chuHoModel.getNguyenQuan());
        tfTonGiao.setText(chuHoModel.getTonGiao());
        tfDiaChiHienTai.setText(chuHoModel.getDiaChiHienTai());
        tfGhiChu.setText(chuHoModel.getGhiChu());
    }

    public void updateHoKhau(ActionEvent event) throws ClassNotFoundException, SQLException {
        // kiem tra dia chi nhap vao
        // dia chi nhap vao la 1 chuoi t 1 toi 30 ki tu
        if (tfDiaChi.getText().length() >= 50 || tfDiaChi.getText().length() <= 1) {
            Alert alert = new Alert(AlertType.WARNING, "Hãy nhập vào 1 địa chỉ hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
        String diaChiString = tfDiaChi.getText();
        String makhuvuc= tfMaKhuVuc.getText();
        new HoKhauService().update(hoKhauModel.getMaHo(), diaChiString, makhuvuc);
        
        String tenString = tfTenChuHo.getText();
        String tuoiInt = tfTuoi.getValue().toString();
        String cmndString = tfCMND.getText();
        String sdtString = tfSDT.getText();
        String gioitinhString = tfGioiTinh.getText();
        String noisinhString = tfNoiSinh.getText();
        String nguyenquanString = tfNguyenQuan.getText();
        String dantocString = tfDanToc.getText();
        String quoctichString = tfQuocTich.getText();
        String sohochieuString = tfSoHoChieu.getText();
        String noithuongtruString = tfNoiTru.getText();
        String dc_hientaiString = tfDiaChiHienTai.getText();
        String tongiaoString = tfTonGiao.getText();
        String ghichuString = tfGhiChu.getText();
        
        new NhanKhauService().update(chuHoModel.getId(), cmndString, tenString, tuoiInt, sdtString, gioitinhString, noisinhString, nguyenquanString, dantocString, quoctichString, sohochieuString, noithuongtruString, dc_hientaiString, tongiaoString, ghichuString);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
