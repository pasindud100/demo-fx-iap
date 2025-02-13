package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Author : pasindu
 place: ACPT student*/
public class SaveVahicleSaveController {


    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtGear;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void save(ActionEvent event) {
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int gear =Integer.parseInt( txtGear.getText());
        double price = Double.parseDouble( txtPrice.getText());


        //load the installed driver to this class
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "1234");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles (brand,model,no_of_gears,price) values(?,?,?,?)");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gear);
            preparedStatement.setObject(4, price);

          int i=  preparedStatement.executeUpdate();

          if(i>0){
              System.out.println("Inserted Successfully");
          }else{
              System.out.println("Insertion Failed");
          }

        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

}
