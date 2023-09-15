package controller.nhankhau;

import controller.noptien.ChooseNguoiNop;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.KhaiTuModel;
import models.NhanKhauModel;
import services.KhaiTuService;

public class KhaiTuController {

    @FXML
    private TextField tfNguoiKhai;
    @FXML
    private TextField tfNguoiMat;
    @FXML
    private DatePicker dateNgayMat;
    @FXML
    private TextArea taLyDo;
    @FXML
    private TextField tfSoGiayKhaiTu;
    private NhanKhauModel nguoiKhai;
    private NhanKhauModel nguoiMat;

    public void chooseNguoiKhai() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/noptien/ChooseNguoiNop.fxml"));
        Parent home = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Chọn người khai");
        stage.setScene(new Scene(home, 800, 600));
        stage.setResizable(false);
        stage.showAndWait();;
        ChooseNguoiNop chooseNguoiNop = loader.getController();
        nguoiKhai = chooseNguoiNop.getNhanKhauChoose();
        if (nguoiKhai == null) {
            return;
        }
        tfNguoiKhai.setText(nguoiKhai.getTen());
    }

    public void chooseNguoiMat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/noptien/ChooseNguoiNop.fxml"));
        Parent home = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Chọn người mất");
        stage.setScene(new Scene(home, 800, 600));
        stage.setResizable(false);
        stage.showAndWait();

        ChooseNguoiNop chooseNguoiNop = loader.getController();
        nguoiMat = chooseNguoiNop.getNhanKhauChoose();
        if (nguoiMat == null) {
            return;
        }
        tfNguoiMat.setText(nguoiMat.getTen());
    }

    public void addKhaiTu(ActionEvent event) throws ClassNotFoundException, SQLException {
        // khai bao mot mau de so sanh
        Pattern pattern;

        // kiem tra sogiaykhaitu nhap vao
        // sogiaykhaitu la day so tu 1 toi 11 chu so
        pattern = Pattern.compile("\\d{1,11}");
        if (!pattern.matcher(tfSoGiayKhaiTu.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập vào số giấy khai tử hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        // kiem tra sogiaykhaitu them moi da ton tai hay khong
        List<KhaiTuModel> listkhaitu = new KhaiTuService().getListKhaiTu();
        for (KhaiTuModel khaitu : listkhaitu) {
            if (khaitu.getSoGIayKhaiTu()== Integer.parseInt(tfSoGiayKhaiTu.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Số giấy khai tử bị trùng!", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
        }
//        //không để trống lý do
//        if (taLyDo.getText().length() <= 0) {
//            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập vào 1 lý do hợp lệ!", ButtonType.OK);
//            alert.setHeaderText(null);
//            alert.showAndWait();
//            return;
//        }
        
        //add
        int sogiaykhaitu = Integer.parseInt(tfSoGiayKhaiTu.getText());
        int idnguoikhai = nguoiKhai.getId();
        int idnguoimat = nguoiMat.getId();
        Date ngaykhai = Date.valueOf(java.time.LocalDate.now());
        Date ngaymat = Date.valueOf(this.dateNgayMat.getValue());
        String lydochet = taLyDo.getText();
        
        KhaiTuService khaiTuService = new KhaiTuService();
        KhaiTuModel khaiTuModel = new KhaiTuModel(sogiaykhaitu, idnguoikhai, idnguoimat, ngaykhai, ngaymat, lydochet);
        khaiTuService.add(khaiTuModel);
        khaiTuService.updateGhiChu(idnguoimat);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
