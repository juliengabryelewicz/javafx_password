package com.juliengabryelewicz.password;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Random;

public class PasswordController {

    @FXML
    private CheckBox minCharacters;
    @FXML
    private CheckBox majCharacters;
    @FXML
    private CheckBox numCharacters;
    @FXML
    private CheckBox speCharacters;

    @FXML
    private Slider lengthSlider;

    @FXML
    private Label passwordLabel;

    @FXML
    protected void onGeneratePasswordButtonClick() {
        passwordLabel.setText(generatePassword());
    }

    @FXML
    protected void onCopyButtonClick() {

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(passwordLabel.getText());
        clipboard.setContent(content);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Message");

        alert.setHeaderText(null);
        alert.setContentText("Mot de passe copié");

        alert.showAndWait();
    }

    private String generatePassword() {

        String password = "";
        String listCharacters = "";

        if(minCharacters.isSelected()) {
            listCharacters += "abcdefghijklmnopqrstuvwxyz";
        }

        if(majCharacters.isSelected()) {
            listCharacters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }

        if(numCharacters.isSelected()) {
            listCharacters += "0123456789";
        }

        if(speCharacters.isSelected()) {
            listCharacters += "!#%$&@?-_|])([";
        }

        for (int i = 0; i < lengthSlider.getValue(); i++) {
            password += listCharacters.toCharArray()[new Random().nextInt(listCharacters.length())];
        }
        return password;

    }

}