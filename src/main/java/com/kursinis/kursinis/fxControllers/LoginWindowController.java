package com.kursinis.kursinis.fxControllers;

import com.kursinis.kursinis.MainApplication;
import com.kursinis.kursinis.hibernate.GenericHibernate;
import com.kursinis.kursinis.model.User;
import com.kursinis.kursinis.utils.PasswordHashing;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {

    @FXML
    public TextField enterEmailField;
    @FXML
    public TextField enterPasswordField;
    @FXML
    public Button loginButton;
    @FXML
    public Button registerButton;

    private GenericHibernate genericHibernate;
    private EntityManagerFactory entityManagerFactory;

    public LoginWindowController() {
        this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");

    }

    @SneakyThrows
    public void login() {
        User user = genericHibernate.getUserByCredentials(enterEmailField.getText(), PasswordHashing.hashPassword(enterPasswordField.getText()));
        if (user == null) {
            throw new Exception("Incorrect credentials!");
        }
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.setUser(user);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) enterEmailField.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @SneakyThrows
    public void register() {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("register-window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) enterEmailField.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
