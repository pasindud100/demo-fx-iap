package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/* Author : pasindu
 place: ACPT student*/
public class StudentController  {

    @FXML
    private TextField textAgf;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTele;


    Student [] student = new Student[10];
    int counter = 0;

    @FXML
    void btnSave(ActionEvent event) {
        if(counter<student.length) {
            String address = textAgf.getText();
            int age = Integer.parseInt(textAgf.getText());
            String name = txtName.getText();
            int tele = Integer.parseInt(txtTele.getText());

            student[counter]= new Student(name,age,address,tele);
            counter++;

            System.out.println("Student added");
        }
    else {
            System.out.println("Student not added");
        }
    }

 }