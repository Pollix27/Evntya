module com.mycompany.salondeeventos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.salondeeventos to javafx.fxml;
    exports com.mycompany.salondeeventos;
}
