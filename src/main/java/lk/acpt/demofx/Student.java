package lk.acpt.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/* Author : pasindu
 place: ACPT student*/
public class Student {
    String name;
    int age;
    String address;
    int tel;

    public Student(String name, int age, String address, int tel) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
    }
}
