package coursework.kursiniswebshop.fxControllers;

import coursework.kursiniswebshop.model.Game;
import coursework.kursiniswebshop.model.Product;
import coursework.kursiniswebshop.model.Software;
import coursework.kursiniswebshop.model.Subscriptions;
import coursework.kursiniswebshop.utils.Popup;
import coursework.kursiniswebshop.utils.Validation;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import coursework.kursiniswebshop.hibernate.GenericHibernate;

import java.net.URL;
import java.sql.SQLOutput;
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

    //This class has methods for entity manipulation
    private  GenericHibernate genericHibernate;

    private EntityManagerFactory entityManagerFactory;

    //<editor-fold desc="Function: addProductOnClick">

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");
    }

    @FXML
    public void addProductOnClick() {
        try {
            if (gameRadioButton.isSelected()) {
                Game game = new Game(
                        titleField.getText(),
                        descriptionField.getText(),
                        genrecategField.getText(),
                        devField.getText(),
                        versionField.getText(),
                        releaseDateField.getValue()
                );
                genericHibernate.create(game);
                //productAdminList.getItems().add(game); //Kol kas tiesiog atvaizduoju sukurtą objektą ListView elemente
            } else if (softwareRadioButton.isSelected()) {
                Software software = new Software(
                        titleField.getText(),
                        descriptionField.getText(),
                        genrecategField.getText(),
                        devField.getText(),
                        versionField.getText(),
                        releaseDateField.getValue());
                //productAdminList.getItems().add(software);
                genericHibernate.create(software);
            } else if (subRadioButton.isSelected()) {
                Subscriptions subscriptions = new Subscriptions(
                       titleField.getText(),
                        descriptionField.getText(),
                        genrecategField.getText(),
                        devField.getText(),
                        releaseDateField.getValue(),
                        durationField.getText());
                genericHibernate.create(subscriptions);
                //productAdminList.getItems().add(subscriptions);
            }
            /*//clear all fields for clean adding of products one after another
            titleField.clear();
            descriptionField.clear();
            genrecategField.clear();
            devField.clear();
            versionField.clear();
            releaseDateField.setValue(null);
            durationField.clear();*/
        } catch (Exception e) {
//            Popup.show("Field" + e.getMessage(), Popup.PopupType.WARNING);
            e.printStackTrace();
        }
            productAdminList.getItems().clear();
            productAdminList.getItems().addAll(genericHibernate.getAllRecords(Product.class));
    }
    //</editor-fold>

    //<editor-fold desc="Function: updateProduct">
    public void updateProduct() {
        if (productAdminList.getSelectionModel().getSelectedItem() != null) {
            try {
                Product product = productAdminList.getSelectionModel().getSelectedItem();
                if (product instanceof Game) {
                    Game gameToUpdate = genericHibernate.getEntityById(Game.class, product.getID());
                    gameToUpdate.setTitle(titleField.getText());
                    gameToUpdate.setDescription(descriptionField.getText());
                    gameToUpdate.setDeveloper(devField.getText());
                    gameToUpdate.setGenrecateg(genrecategField.getText());
                    gameToUpdate.setVersion(versionField.getText());
                    gameToUpdate.setReleaseDate(releaseDateField.getValue());

                    genericHibernate.update(gameToUpdate);
                    //productAdminList.getItems().add(game); //Kol kas tiesiog atvaizduoju sukurtą objektą ListView elemente
                } else if (product instanceof Software) {
                    Software softwareToUpdate = genericHibernate.getEntityById(Software.class, product.getID());
                    softwareToUpdate.setTitle(titleField.getText());
                    softwareToUpdate.setDescription(descriptionField.getText());
                    softwareToUpdate.setGenrecateg(genrecategField.getText());
                    softwareToUpdate.setDeveloper(devField.getText());
                    softwareToUpdate.setVersion(versionField.getText());
                    softwareToUpdate.setReleaseDate(releaseDateField.getValue());
                    //productAdminList.getItems().add(software);
                    genericHibernate.update(softwareToUpdate);
                } else if (product instanceof Subscriptions) {
                    Subscriptions subscriptionsToUpdate = genericHibernate.getEntityById(Subscriptions.class, product.getID());
                    subscriptionsToUpdate.setTitle(titleField.getText());
                    subscriptionsToUpdate.setDescription(descriptionField.getText());
                    subscriptionsToUpdate.setGenrecateg(genrecategField.getText());
                    subscriptionsToUpdate.setDeveloper(devField.getText());
                    subscriptionsToUpdate.setVersion(versionField.getText());
                    subscriptionsToUpdate.setReleaseDate(releaseDateField.getValue());
                    subscriptionsToUpdate.setDuration(durationField.getText());
                    genericHibernate.update(subscriptionsToUpdate);
                    //productAdminList.getItems().add(subscriptions);
                }
            } catch (Exception e) {
            //  Popup.show("Field" + e.getMessage(), Popup.PopupType.WARNING);
                e.printStackTrace();
            }
        }
        else {
            Popup.show("Please select a product first.", Popup.PopupType.WARNING);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Function: readProduct">
    public void readProduct() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        if (product instanceof Game)
        {
            Game game = (Game) product;
            titleField.setText(game.getTitle());
            descriptionField.setText(game.getDescription());
            genrecategField.setText(game.getGenrecateg());
            devField.setText(game.getDeveloper());
            versionField.setText(game.getVersion());
            releaseDateField.setValue(game.getReleaseDate());
            gameRadioButton.setSelected(true);
        }
        if (product instanceof Software) {
            Software software = (Software) product;
            titleField.setText(software.getTitle());
            descriptionField.setText(software.getDescription());
            genrecategField.setText(software.getGenrecateg());
            devField.setText(software.getDeveloper());
            versionField.setText(software.getVersion());
            releaseDateField.setValue(software.getReleaseDate());
            softwareRadioButton.setSelected(true);
        }
        if (product instanceof Subscriptions) {
            Subscriptions subscriptions = (Subscriptions) product;
            titleField.setText(subscriptions.getTitle());
            descriptionField.setText(subscriptions.getDescription());
            genrecategField.setText(subscriptions.getGenrecateg());
            devField.setText(subscriptions.getDeveloper());
            durationField.setText(subscriptions.getDuration());
            releaseDateField.setValue(subscriptions.getReleaseDate());
            subRadioButton.setSelected(true);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Function: removeProduct">
    public void removeProduct() {
        Product product = productAdminList.getSelectionModel().getSelectedItem();
        productAdminList.getItems().remove(product);
    }
    //</editor-fold>

    public MainController () {
           this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));;
    }


    public void refreshProduct() {
        productAdminList.getItems().clear();
        productAdminList.getItems().addAll(genericHibernate.getAllRecords(Product.class));
    }
}
