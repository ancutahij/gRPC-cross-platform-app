package controller;

import javafx.scene.control.Alert;

public class WindowsUtils {

    public static  void showErrorMessage(String message) {
        Alert mes = new Alert(Alert.AlertType.ERROR);
        mes.setTitle("Error Message");
        mes.setContentText(message);
        mes.showAndWait();
    }

    public static void showConfirmationMessage(String message) {
        Alert mes = new Alert(Alert.AlertType.CONFIRMATION);
        mes.setTitle("Confirmation Message");
        mes.setContentText(message);
        mes.showAndWait();
    }


}
