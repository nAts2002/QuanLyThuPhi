package controller.nhankhau;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.NhanKhauModel;
import models.TamTruModel;
import models.TamVangModel;
import services.NhanKhauService;
import services.TamTruService;
import services.TamVangService;

public class DanhSachTamTruController implements Initializable {

    @FXML
    private TableColumn<TamTruModel, String> colMaNhanKhau;
    @FXML
    private TableColumn<TamTruModel, String> colHoTen;
    @FXML
    private TableColumn<TamTruModel, String> colCMT;
    @FXML
    private TableColumn<TamTruModel, String> colNgaySinh;
    @FXML
    private TableColumn<TamTruModel, String> colLyDo;
    @FXML
    private TableView<TamTruModel> tvDSTamTru;

    private ObservableList<TamTruModel> listValueTableView;
    private List<TamTruModel> listTamTru;

    // hien thi thong tin
    public void showDSTamTru() throws ClassNotFoundException, SQLException {
        listTamTru = new TamTruService().getListTamTru();
        listValueTableView = FXCollections.observableArrayList(listTamTru);

        // tao map anh xa gia tri Id sang maHo
        Map<Integer, String> mapIdToTen = new HashMap<>();
        Map<Integer, String> mapIdToCmt = new HashMap<>();
        Map<Integer, String> mapIdToNgaySinh = new HashMap<>();
        List<NhanKhauModel> listnhankhau = new NhanKhauService().getListNhanKhau();
        listnhankhau.forEach(nhankhau -> {
            mapIdToTen.put(nhankhau.getId(), nhankhau.getTen());
            mapIdToCmt.put(nhankhau.getId(), nhankhau.getCmnd());
            mapIdToNgaySinh.put(nhankhau.getId(), nhankhau.getTuoi());
        });

        // thiet lap cac cot cho tableviews
        colMaNhanKhau.setCellValueFactory(new PropertyValueFactory<TamTruModel, String>("id"));
        colLyDo.setCellValueFactory(new PropertyValueFactory<TamTruModel, String>("lyDo"));
        try {
            colHoTen.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamTruModel, String> p) -> new ReadOnlyStringWrapper(mapIdToTen.get(p.getValue().getIdNhanKhau()).toString())
            );
            colCMT.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamTruModel, String> p) -> new ReadOnlyStringWrapper(mapIdToCmt.get(p.getValue().getIdNhanKhau()).toString())
            );
            colNgaySinh.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamTruModel, String> p) -> new ReadOnlyStringWrapper(mapIdToNgaySinh.get(p.getValue().getIdNhanKhau()).toString())
            );
        } catch (Exception e) {
            // TODO: handle exception
        }

        tvDSTamTru.setItems(listValueTableView);

        // thiet lap gia tri cho combobox
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            showDSTamTru();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
