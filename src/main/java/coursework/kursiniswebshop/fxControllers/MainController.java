package coursework.kursiniswebshop.fxControllers;

import coursework.kursiniswebshop.model.Game;
import coursework.kursiniswebshop.model.Product;
import coursework.kursiniswebshop.model.Software;
import coursework.kursiniswebshop.model.Subscriptions;
import coursework.kursiniswebshop.utils.Popup;
import coursework.kursiniswebshop.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public Tab shopTab;
    @FXML
    public ListView<Product> productAdminList;
    @FXML
    public TextField titleField;
    @FXML
    public TextField descriptionField;
    @FXML
    public TextField genrecategField;
    @FXML
    public TextField devField;
    @FXML
    public TextField versionField;
    @FXML
    public TextField durationField;
    @FXML
    public DatePicker releaseDateField;
    @FXML
    public Button addButton;
    @FXML
    public Button updateButton;
    @FXML
    public Button removeButton;
    @FXML
    public RadioButton gameRadioButton;
    @FXML
    public RadioButton softwareRadioButton;
    @FXML
    public RadioButton subRadioButton;

    //<editor-fold desc="Function: addProductOnClick">
    @FXML
    public void addProductOnClick() {
        try {
            if (gameRadioButton.isSelected()) {
                Game game = new Game(
                        Validation.validateString(titleField.getText(), "title"),
                        Validation.validateString(descriptionField.getText(), "descr"),
                        Validation.validateString(genrecategField.getText(), "genrecateg"),
                        Validation.validateString(devField.getText(), "devfield"),
                        Validation.validateString(versionField.getText(), "version"),
                        releaseDateField.getValue());
                //Kai turėsime duomenų bazę, šiame žyngsnyje tą objekto info išsaugosime db ir tik tada atvaizduosime
                productAdminList.getItems().add(game); //Kol kas tiesiog atvaizduoju sukurtą objektą ListView elemente
            } else if (softwareRadioButton.isSelected()) {
                Software software = new Software(
                        Validation.validateString(titleField.getText(), "title"),
                        Validation.validateString(descriptionField.getText(), "descr"),
                        Validation.validateString(genrecategField.getText(), "genrecateg"),
                        Validation.validateString(devField.getText(), "devfield"),
                        Validation.validateString(versionField.getText(), "version"),
                        releaseDateField.getValue());
                productAdminList.getItems().add(software);
            } else if (subRadioButton.isSelected()) {
                Subscriptions subscriptions = new Subscriptions(
                        Validation.validateString(titleField.getText(), "title"),
                        Validation.validateString(descriptionField.getText(), "descr"),
                        Validation.validateString(genrecategField.getText(), "genrecateg"),
                        Validation.validateString(devField.getText(), "devfield"),
                        releaseDateField.getValue(),
                        Validation.validateString(durationField.getText(), "duration"));
                productAdminList.getItems().add(subscriptions);
            }
        } catch (Exception e) {
            Popup.show("Field" + e.getMessage(), Popup.PopupType.WARNING);
        }


    }
    //</editor-fold>

    //<editor-fold desc="Function: updateProduct">
    public void updateProduct() {
        if (productAdminList.getSelectionModel().getSelectedItem() != null) {
            Product product = productAdminList.getSelectionModel().getSelectedItem();
            product.setTitle(titleField.getText());
            product.setDescription(descriptionField.getText());
            product.setDeveloper(devField.getText());
            product.setReleaseDate(releaseDateField.getValue());
            product.setVersion(versionField.getText());

            if (product instanceof Subscriptions subscriptions) {
                subscriptions.setDuration(durationField.getText());
            }
            productAdminList.refresh();
        }
        else {
            Popup.show("Please select a product first.", Popup.PopupType.WARNING);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Function: readProduct">
    public void readProduct() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        if (product != null)
        {
            titleField.setText(product.getTitle());
            descriptionField.setText(product.getDescription());
            genrecategField.setText(product.getGenrecateg());
            devField.setText(product.getDeveloper());
            versionField.setText(product.getVersion());
            releaseDateField.setValue(product.getReleaseDate());

            if (product instanceof Subscriptions subscriptions) {
                durationField.setText(subscriptions.getDuration());
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Function: removeProduct">
    public void removeProduct() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        productAdminList.getItems().remove(product);
    }
    //</editor-fold>



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
