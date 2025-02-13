package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/* Author : pasindu
 place: ACPT student*/public class LoginContraller {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void login(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(email.equals("admin.com") && password.equals("123")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Login");
            alert.setContentText("Login Successful.");
            alert.showAndWait();
        }
        else {
            Alert warning = new Alert(Alert.AlertType.INFORMATION);
            warning.setTitle("Failed");
            warning.setContentText("Login failed!! Try again.");
            warning.showAndWait();
        }
    }

}
