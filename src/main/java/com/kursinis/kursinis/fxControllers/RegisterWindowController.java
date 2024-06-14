package com.kursinis.kursinis.fxControllers;

import com.kursinis.kursinis.MainApplication;
import com.kursinis.kursinis.hibernate.GenericHibernate;
import com.kursinis.kursinis.model.Customer;
import com.kursinis.kursinis.model.Manager;
import com.kursinis.kursinis.model.User;
import com.kursinis.kursinis.utils.PasswordHashing;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.hibernate.annotations.Check;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWindowController implements Initializable {

    @FXML
    public TextField emailRegisterField;
    @FXML
    public TextField nameRegisterField;
    @FXML
    public TextField surnameRegisterField;
    @FXML
    public TextField loginRegisterField;
    @FXML
    public TextField passwordRegisterField;
    @FXML
    public CheckBox managerCheckbox;

    private GenericHibernate genericHibernate;
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");
    }
    @SneakyThrows
    public void register() throws IOException {
        User user;
        if (managerCheckbox.isSelected()) {
            user = new Manager(
                    emailRegisterField.getText(),
                    nameRegisterField.getText(),
                    surnameRegisterField.getText(),
                    loginRegisterField.getText(),
                    PasswordHashing.hashPassword(passwordRegisterField.getText()),
                    "false"
            );
        }
        else {
            user = new Customer(
                    emailRegisterField.getText(),
                    nameRegisterField.getText(),
                    surnameRegisterField.getText(),
                    loginRegisterField.getText(),
                    PasswordHashing.hashPassword(passwordRegisterField.getText()),
                    null,
                    null,
                    "false"
            );
        }
        genericHibernate.create(user);
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) managerCheckbox.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public RegisterWindowController() {
        this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));
    }
}