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
import models.QuanHeModel;
import models.TamVangModel;
import services.NhanKhauService;
import services.QuanHeService;
import services.TamVangService;

public class DanhSachTamVangController implements Initializable {// 
    @FXML
    private TableColumn<TamVangModel, String> colMaNhanKhau;
    @FXML
    private TableColumn<TamVangModel, String> colHoTen;
    @FXML
    private TableColumn<TamVangModel, String> colCMT;
    @FXML
    private TableColumn<TamVangModel, String> colNgaySinh;
    @FXML
    private TableColumn<TamVangModel, String> colLyDo;
    @FXML
    private TableView<TamVangModel> tvDSTamVang;
    
    private ObservableList<TamVangModel> listValueTableView;
    private List<TamVangModel> listTamVang;
    
    // hien thi thong tin
    public void showDSTamVang() throws ClassNotFoundException, SQLException {
        listTamVang = new TamVangService().getListTamVang();
        listValueTableView = FXCollections.observableArrayList(listTamVang);

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
        colMaNhanKhau.setCellValueFactory(new PropertyValueFactory<TamVangModel, String>("id_tam_vang"));
        colLyDo.setCellValueFactory(new PropertyValueFactory<TamVangModel, String>("lydo"));
        try {
            colHoTen.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamVangModel, String> p) -> new ReadOnlyStringWrapper(mapIdToTen.get(p.getValue().getIdNhanKhau()).toString())
            );
            colCMT.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamVangModel, String> p) -> new ReadOnlyStringWrapper(mapIdToCmt.get(p.getValue().getIdNhanKhau()).toString())
            );
            colNgaySinh.setCellValueFactory(
                    (TableColumn.CellDataFeatures<TamVangModel, String> p) -> new ReadOnlyStringWrapper(mapIdToNgaySinh.get(p.getValue().getIdNhanKhau()).toString())
            );
        } catch (Exception e) {
            // TODO: handle exception
        }

        tvDSTamVang.setItems(listValueTableView);

        // thiet lap gia tri cho combobox
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            showDSTamVang();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
