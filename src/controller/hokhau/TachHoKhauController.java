package controller.hokhau;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.ChuHoModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.QuanHeModel;
import models.TamTruModel;
import services.ChuHoService;
import services.HoKhauService;
import services.NhanKhauService;
import services.QuanHeService;

public class TachHoKhauController implements Initializable {

    @FXML
    private TextField tfMaHKBanDau;
    @FXML
    private TextField tfTenBanDau;
    @FXML
    private TableView<NhanKhauModel> tvBanDau;
    @FXML
    private TableColumn<NhanKhauModel, String> colTenBD;
    @FXML
    private TableColumn<NhanKhauModel, String> colDateBD;
    @FXML
    private TableColumn<NhanKhauModel, String> colQuanHeBD;
    @FXML
    private TextField tfMaHKMoi;
    @FXML
    private TextField tfTenMoi;
    @FXML
    private TableView<NhanKhauModel> tvMoi;
    @FXML
    private TableColumn<NhanKhauModel, String> colTenMoi;
    @FXML
    private TableColumn<NhanKhauModel, String> colDateMoi;
    @FXML
    private TableColumn<NhanKhauModel, String> colQuanHeMoi;
    private ObservableList<NhanKhauModel> listValueTableViewBD;
    private List<NhanKhauModel> listThanhVienBD;
    private ObservableList<NhanKhauModel> listValueTableViewMoi;
    private List<NhanKhauModel> listThanhVienMoi = new ArrayList<>();
    private NhanKhauModel chuHoMoi;

    private HoKhauModel hokhauBD;
    private HoKhauModel hokhauMoi;

    public void chonHoKhau() throws IOException, ClassNotFoundException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/hokhau/ChooseHoKhau.fxml"));
        Parent home = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Chọn hộ khẩu");
        stage.setScene(new Scene(home, 600, 400));
        stage.setResizable(false);
        stage.showAndWait();

        ChooseHoKhauController chooseHoKhau = loader.getController();
        hokhauBD = chooseHoKhau.getHoKhauChoose();
        if (hokhauBD == null) {
            return;
        }
        tfMaHKBanDau.setText(Integer.toString(hokhauBD.getMaHo()));

        Map<Integer, Integer> mapToIDChuho = new HashMap<>();
        List<ChuHoModel> listchuho = new ChuHoService().getListChuHo();
        listchuho.forEach(chuho -> {
            mapToIDChuho.put(chuho.getMaHo(), chuho.getIdChuHo());
        });

        Map<Integer, String> mapToChuho = new HashMap<>();
        List<NhanKhauModel> listnhankhau = new NhanKhauService().getListNhanKhau();
        listnhankhau.forEach(nhankhau -> {
            mapToChuho.put(nhankhau.getId(), nhankhau.getTen());
        });
        String tenChuHo = mapToChuho.get(mapToIDChuho.get(hokhauBD.getMaHo()));
        tfTenBanDau.setText(tenChuHo);
        listThanhVienBD = new NhanKhauService().getListThanhVien(hokhauBD.getMaHo());
        showTvBanDau();
    }

    public void showTvBanDau() throws ClassNotFoundException, SQLException {
        listValueTableViewBD = FXCollections.observableArrayList(listThanhVienBD);

        Map<Integer, String> mapIdToQuanHe = new HashMap<>();// có thể đặt là biến cục bộ
        List<QuanHeModel> listQuanHe = new QuanHeService().getListQuanHe(hokhauBD.getMaHo());
        listQuanHe.forEach(quanhe -> {
            mapIdToQuanHe.put(quanhe.getIdThanhVien(), quanhe.getQuanHe());
        });

        // thiet lap cac cot cho tableviews
        colTenBD.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("ten"));
        colDateBD.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("tuoi"));
        try {
            colQuanHeBD.setCellValueFactory(
                    (TableColumn.CellDataFeatures<NhanKhauModel, String> p) -> new ReadOnlyStringWrapper(mapIdToQuanHe.get(p.getValue().getId()).toString())
            );
        } catch (Exception e) {
            // TODO: handle exception
        }

        tvBanDau.setItems(listValueTableViewBD);
    }

    public void showTvMoi() throws ClassNotFoundException, SQLException {
        listValueTableViewMoi = FXCollections.observableArrayList(listThanhVienMoi);

        // tao map anh xa gia tri Id sang maHo
        Map<Integer, String> mapIdToQuanHe = new HashMap<>();
        List<QuanHeModel> listQuanHe = new QuanHeService().getListQuanHe(hokhauBD.getMaHo());
        listQuanHe.forEach(quanhe -> {
            mapIdToQuanHe.put(quanhe.getIdThanhVien(), quanhe.getQuanHe());
        });

        // thiet lap cac cot cho tableviews
        colTenMoi.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("ten"));
        colDateMoi.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("tuoi"));
        try {
            colQuanHeMoi.setCellValueFactory(
                    (TableColumn.CellDataFeatures<NhanKhauModel, String> p) -> new ReadOnlyStringWrapper(mapIdToQuanHe.get(p.getValue().getId()).toString())
            );
        } catch (Exception e) {
            // TODO: handle exception
        }

        tvMoi.setItems(listValueTableViewMoi);
    }

    public void chuyenSangPhai() throws ClassNotFoundException, SQLException {
        NhanKhauModel nhanKhauModel = tvBanDau.getSelectionModel().getSelectedItem();
        if (nhanKhauModel != null) {
            listThanhVienBD.remove(nhanKhauModel);
            showTvBanDau();
            listThanhVienMoi.add(nhanKhauModel);
            showTvMoi();
        }
    }

    public void chuyenSangTrai() throws ClassNotFoundException, SQLException {
        NhanKhauModel nhanKhauModel = tvMoi.getSelectionModel().getSelectedItem();
        if (nhanKhauModel != null) {
            listThanhVienMoi.remove(nhanKhauModel);
            showTvMoi();
            listThanhVienBD.add(nhanKhauModel);
            showTvBanDau();
        }
    }

    public void chonChuHoMoi() throws ClassNotFoundException, SQLException {
        NhanKhauModel nhanKhauModel = tvMoi.getSelectionModel().getSelectedItem();
        if (nhanKhauModel != null) {
            if (chuHoMoi != null) {
                listThanhVienMoi.add(chuHoMoi);
            }
            chuHoMoi = nhanKhauModel;
            listThanhVienMoi.remove(nhanKhauModel);
            showTvMoi();
            tfTenMoi.setText(chuHoMoi.getTen());
        }

    }

    public void xacNhan(ActionEvent event) throws ClassNotFoundException, SQLException {
        int maHo = Integer.parseInt(tfMaHKMoi.getText());
        HoKhauModel hoKhauModel = new HoKhauModel(maHo, 1, hokhauBD.getDiaChi(), hokhauBD.getMaKhuVuc());
        new HoKhauService().add(hoKhauModel);
        new ChuHoService().add(new ChuHoModel(maHo, chuHoMoi.getId()));
        
        Map<Integer, String> mapIdToQuanHe = new HashMap<>();
        List<QuanHeModel> listQuanHe = new QuanHeService().getListQuanHe(hokhauBD.getMaHo());
        listQuanHe.forEach(quanhe -> {
            mapIdToQuanHe.put(quanhe.getIdThanhVien(), quanhe.getQuanHe());
        });
        
        new QuanHeService().del(hokhauBD.getMaHo(), chuHoMoi.getId());
        if (!listThanhVienMoi.isEmpty()) {
            for (NhanKhauModel nhankhau : listThanhVienMoi) {
                System.out.println("alo");
                new QuanHeService().del(hokhauBD.getMaHo(), nhankhau.getId());
                String quanhe = mapIdToQuanHe.get(nhankhau.getId());
                new QuanHeService().add(new QuanHeModel(maHo, nhankhau.getId(),quanhe ));
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
