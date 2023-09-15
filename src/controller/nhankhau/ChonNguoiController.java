package controller.nhankhau;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.KhoanThuModel;
import models.NhanKhauModel;
import services.KhoanThuService;
import services.NhanKhauService;

public class ChonNguoiController implements Initializable {

    @FXML
    private TableView<NhanKhauModel> tvChonNguoi;
    @FXML
    private TableColumn<NhanKhauModel, String> colID;
    @FXML
    private TableColumn<NhanKhauModel, String> colHoTen;
    @FXML
    private TableColumn<NhanKhauModel, String> colCMT;
    @FXML
    private TableColumn<NhanKhauModel, String> colNgaySinh;
    private NhanKhauModel nhankhauChoose;
    private List<NhanKhauModel> listnhankhau;
    private ObservableList<NhanKhauModel> listValueTableView;

    public NhanKhauModel getNhankhauChoose() {
        return nhankhauChoose;
    }

    public void setNhankhauChoose(NhanKhauModel nhankhauChoose) {
        this.nhankhauChoose = nhankhauChoose;
    }

    public void showNguoiChon() throws ClassNotFoundException, SQLException {
        listnhankhau = new NhanKhauService().getListNhanKhau();
        listValueTableView = FXCollections.observableArrayList(listnhankhau);

        // thiet lap cac cot cho table views
        colID.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("id"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("ten"));
        colCMT.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("cmnd"));
        colNgaySinh.setCellValueFactory(new PropertyValueFactory<NhanKhauModel, String>("tuoi"));
        
        tvChonNguoi.setItems(listValueTableView);
    }
    public void xacnhan(ActionEvent event) {
		nhankhauChoose = tvChonNguoi.getSelectionModel().getSelectedItem();
		setNhankhauChoose(nhankhauChoose);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
			showNguoiChon();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
