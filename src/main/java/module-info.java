module lk.acpt.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens lk.acpt.demofx to javafx.fxml;
    exports lk.acpt.demofx;
}