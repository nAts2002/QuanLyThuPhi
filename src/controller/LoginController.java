package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.LoginService;

public class LoginController {
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField tfPassword;
    @FXML
    private Button btnLogin;
	
    @FXML
	public void Login(ActionEvent event) throws IOException, ClassNotFoundException {
		String name = tfUsername.getText();
		String pass = tfPassword.getText();
//		!name.equals("admin") || !pass.equals("admin")
		// check username and password
                LoginService loginService = new LoginService();
		if( ! loginService.checkLogin(name, pass)) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn nhập sai mật khẩu rồi hihi!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		Parent home = FXMLLoader.load(getClass().getResource("/views/Home3.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home,1600,800));
        stage.setResizable(false);
        stage.show();
	}

}
