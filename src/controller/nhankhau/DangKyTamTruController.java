package controller.nhankhau;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.NhanKhauModel;
import models.TamTruModel;
import services.NhanKhauService;
import services.TamTruService;

public class DangKyTamTruController {
    @FXML
    private TextField tfCMT;
    @FXML
    private TextField tfMa;
    @FXML
    private TextField tfNoiTru;
    @FXML
    private DatePicker dateTuNgay;
    @FXML
    private DatePicker dateDenNgay;
    @FXML
    private TextArea taLyDo;

    public void addTamTru(ActionEvent event) throws ClassNotFoundException, SQLException {
        int idnhanKhauTamTru = 0;
        
        // check CMT/CMND co trung voi nhung CMT/CMND da ton tai hay khong
        List<NhanKhauModel> listNhanKhauModels = new NhanKhauService().getListNhanKhau();
        for (NhanKhauModel nhankhau : listNhanKhauModels) {
            if (nhankhau.getCmnd().equals(tfCMT.getText())) {
                idnhanKhauTamTru = nhankhau.getId();
            }
        }
        // kiem tra CMT/CMND 
        if (idnhanKhauTamTru == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Không thấy tìm thấy CMT/CCCD như trên", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
        //kiem tra mã giấy tạm trú
        if (tfMa.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập mã giấy tạm trú", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
        //kiem tra nơi tạm trú
        if (tfNoiTru.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập nơi tạm trú", ButtonType.OK);
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
        
        //kiem tra text are ly do
        if (taLyDo.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập lý do", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        
        // ghi nhan gia tri ghi tat ca deu da hop le
        int idNhanKhau = idnhanKhauTamTru;
        String maGiayTamTru = tfMa.getText();
        String noiTamTru = tfNoiTru.getText();
        Date TuNgay = Date.valueOf(this.dateTuNgay.getValue());
        Date DenNgay = Date.valueOf(this.dateDenNgay.getValue());
        String lyDo = taLyDo.getText();
        
        TamTruService tamTruService = new TamTruService();
        TamTruModel tamTruModel =  new TamTruModel(idNhanKhau, maGiayTamTru, noiTamTru, TuNgay, DenNgay, lyDo);
        tamTruService.add(tamTruModel);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
