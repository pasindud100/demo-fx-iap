package lk.acpt.demofx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Author : pasindu
 place: ACPT student*/
public class UpdateVahicleController {
    @FXML
    private TextField txtId;

    @FXML
    void cancle(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void update(ActionEvent event) {

        int id =Integer.parseInt( txtId.getText());
        //load the installed driver to this class
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "1234");

            //dynamic query
         PreparedStatement preparedStatement = connection.prepareStatement("delete from vehicles where id = ?");
            preparedStatement.setObject(1, id);

            int i=  preparedStatement.executeUpdate();

            if(i>0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete");
                alert.setContentText("Deleted Successful.");
                alert.showAndWait();
            }else{
                Alert warning = new Alert(Alert.AlertType.INFORMATION);
                warning.setTitle("Failed");
                warning.setContentText("Deleted failed!! Give correct ID.");
                warning.showAndWait();
            }

        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }



}
