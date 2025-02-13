package lk.acpt.demofx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/* Author : pasindu
 place: ACPT student*/
public class LoardAllVehicleController implements Initializable {

    @FXML
    private TableView<Vehiclee> tblVahicles;


    public ArrayList<Vehiclee> loadTable() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "1234");

            //dynamic query
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles");

            ResultSet resultSet =  preparedStatement.executeQuery();

            ArrayList<Vehiclee> list = new ArrayList();

            while (resultSet.next()) {
                Vehiclee vehiclee = new Vehiclee();

                vehiclee.setId(resultSet.getInt(1));
                vehiclee.setBrand(resultSet.getString(2));
                vehiclee.setModel(resultSet.getString(3));
                vehiclee.setNoOfGears(resultSet.getInt(4));
                vehiclee.setPrice(resultSet.getDouble(5));

                list.add(vehiclee);
            }
            return list;
        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void lolad(ActionEvent event) {
        tblVahicles.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVahicles.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVahicles.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVahicles.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tblVahicles.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehiclee> lists = loadTable();
        tblVahicles.setItems(FXCollections.observableList(lists));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblVahicles.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVahicles.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVahicles.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVahicles.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tblVahicles.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehiclee> lists = loadTable();
        tblVahicles.setItems(FXCollections.observableList(lists));
    }
}
