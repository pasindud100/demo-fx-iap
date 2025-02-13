package lk.acpt.demofx;

/* Author : pasindu
 place: ACPT student*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;


public class DeleteVehicleController {


    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtGears;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancle(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void search(ActionEvent event) {
        int id =Integer.parseInt( txtId.getText());
        //load the installed driver to this class
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "1234");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles where id = ?");
            preparedStatement.setObject(1, id);

            ResultSet resultSet =  preparedStatement.executeQuery();

            if(resultSet.next()){
                txtBrand.setText(resultSet.getString(2));
                txtModel.setText(resultSet.getString(3));
                txtGears.setText(String.valueOf(resultSet.getInt(4)));
                txtPrice.setText(String.valueOf(resultSet.getDouble(5)));

            }

        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void update(ActionEvent event) {
        int id =Integer.parseInt( txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int gear =Integer.parseInt(txtGears.getText());
        double price = Double.parseDouble( txtPrice.getText());


        //load the installed driver to this class
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "1234");

            //dynamic query
         PreparedStatement preparedStatement = connection.prepareStatement("update vehicles set brand=?, model=? ,no_of_gears=? ,price=? where id = ?");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gear);
            preparedStatement.setObject(4, price);
            preparedStatement.setObject(5, id);

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
