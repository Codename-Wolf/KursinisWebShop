package coursework.kursiniswebshop.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Popup {

    public enum PopupType {
        ERROR, WARNING
    }

    public static void show(String message, PopupType type) {
        Alert alert = new Alert(type == PopupType.ERROR ? Alert.AlertType.ERROR : Alert.AlertType.WARNING);
        alert.setTitle(type == PopupType.ERROR ? "Error" : "Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}