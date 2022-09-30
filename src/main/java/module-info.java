module com.juliengabryelewicz.password {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.juliengabryelewicz.password to javafx.fxml;
    exports com.juliengabryelewicz.password;
}