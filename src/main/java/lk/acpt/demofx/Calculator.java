package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/* Author : pasindu
 place: ACPT student*/
public class Calculator {


    @FXML
    private Button addition;

    @FXML
    private Button division;

    @FXML
    private Button multification;

    @FXML
    private Button substraction;

    @FXML
    private TextField txtNumOne;

    @FXML
    private TextField txtNumTwo;

    @FXML
    private TextField txtAns;

    String operation;

    @FXML
    void addition(ActionEvent event) {
        operation="addition";
    }

    @FXML
    void division(ActionEvent event) {
        operation="division";
    }

    @FXML
    void multification(ActionEvent event) {
        operation="multification";
    }

    @FXML
    void substraction(ActionEvent event) {
        operation="substraction";
    }


    @FXML
    void getAnswer(ActionEvent event) {
        int num1 = Integer.parseInt(txtNumOne.getText());
        int num2 = Integer.parseInt(txtNumTwo.getText());


        switch (operation) {
            case "addition":
                txtAns.setText(String.valueOf(num1 + num2));
                break;
            case "division":
                txtAns.setText(String.valueOf(num1 / num2));
                break;
           case "multification":
               txtAns.setText(String.valueOf(num1 *num2));
               break;
           case "substraction":
               txtAns.setText(String.valueOf(num1 - num2));
               break;
        }

    }
}
