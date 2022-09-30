package com.juliengabryelewicz.password;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PasswordApplication.class.getResource("password-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 250);
        stage.setTitle("Générateur de mot de passe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}