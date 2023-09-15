package controller.nhankhau;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.NhanKhauModel;
import models.TamVangModel;
import services.NhanKhauService;
import services.TamVangService;

public class DangKyTamVangController {

    @FXML
    private TextField tfCMT;
    @FXML
    private TextField tfMaTamVang;
    @FXML
    private DatePicker dateTuNgay;
    @FXML
    private DatePicker dateDenNgay;
    @FXML
    private TextArea taLyDo;

    public void addTamVang(ActionEvent event) throws ClassNotFoundException, SQLException {
        int idnhanKhauTamVang = 0;

        // check CMT/CMND co trung voi nhung CMT/CMND da ton tai hay khong
        List<NhanKhauModel> listNhanKhauModels = new NhanKhauService().getListNhanKhau();
        for (NhanKhauModel nhankhau : listNhanKhauModels) {
            if (nhankhau.getCmnd().equals(tfCMT.getText())) {
                idnhanKhauTamVang = nhankhau.getId();
            }
        }
        // kiem tra CMT/CMND 
        if (idnhanKhauTamVang == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Không thấy tìm thấy CMT/CMND như trên", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        //kiem tra date bat dau, ket thuc
        if (dateTuNgay.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập ngày bắt đầu", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        if (dateDenNgay.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập ngày bắt đầu", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        // ghi nhan gia tri ghi tat ca deu da hop le

        int idnhankhau = idnhanKhauTamVang;
        String maGiayTamVang = tfMaTamVang.getText();
        Date TuNgay = Date.valueOf(this.dateTuNgay.getValue());
        Date DenNgay = Date.valueOf(this.dateDenNgay.getValue());
        String lydo = taLyDo.getText();

        TamVangService tamVangService = new TamVangService();
        TamVangModel tamVangModel = new TamVangModel(idnhankhau,maGiayTamVang, TuNgay, DenNgay, lydo);
        tamVangService.add(tamVangModel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
