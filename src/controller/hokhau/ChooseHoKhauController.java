package controller.hokhau;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.ChuHoModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.QuanHeModel;
import services.ChuHoService;
import services.HoKhauService;
import services.NhanKhauService;
import services.QuanHeService;

public class ChooseHoKhauController implements Initializable {

    @FXML
    private TableColumn<HoKhauModel, String> colMaHoKhau;
    @FXML
    private TableColumn<HoKhauModel, String> colTen;
    @FXML
    private TableColumn<HoKhauModel, String> colDiaChi;
    @FXML
    private TableView<HoKhauModel> tvHoKhau;
    private ObservableList<HoKhauModel> listValueTableView;
    private List<HoKhauModel> listHoKhau;
    private HoKhauModel hoKhauChoose;

    public HoKhauModel getHoKhauChoose() {
        return hoKhauChoose;
    }

    public void setHoKhauChoose(HoKhauModel hoKhauChoose) {
        this.hoKhauChoose = hoKhauChoose;
    }

    public void showHoKhau() throws ClassNotFoundException, SQLException {
        listHoKhau = new HoKhauService().getListHoKhau();
        listValueTableView = FXCollections.observableArrayList(listHoKhau);

        colMaHoKhau.setCellValueFactory(new PropertyValueFactory<HoKhauModel, String>("maHo"));
        colDiaChi.setCellValueFactory(new PropertyValueFactory<HoKhauModel, String>("diaChi"));

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

        try {
            colTen.setCellValueFactory((TableColumn.CellDataFeatures<HoKhauModel, String> p) -> new ReadOnlyStringWrapper(
                    mapToChuho.get(mapToIDChuho.get(p.getValue().getMaHo()))));
        } catch (Exception e) {
            // TODO: handle exception
        }
        tvHoKhau.setItems(listValueTableView);
    }

    public void xacnhan(ActionEvent event) {
        hoKhauChoose = tvHoKhau.getSelectionModel().getSelectedItem();
        setHoKhauChoose(hoKhauChoose);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            showHoKhau();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
