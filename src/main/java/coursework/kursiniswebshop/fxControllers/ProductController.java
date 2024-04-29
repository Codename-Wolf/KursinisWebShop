package coursework.kursiniswebshop.fxControllers;

import coursework.kursiniswebshop.model.Game;
import coursework.kursiniswebshop.model.Product;
import coursework.kursiniswebshop.model.Software;
import coursework.kursiniswebshop.model.Subscriptions;
import coursework.kursiniswebshop.utils.Popup;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import coursework.kursiniswebshop.hibernate.GenericHibernate;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
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
    @FXML
    public TextField searchField;

    //This class has methods for entity manipulation
    private  GenericHibernate genericHibernate;

    private EntityManagerFactory entityManagerFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");
    }

    //<editor-fold desc="Function: addProductOnClick">
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
        refreshProduct();
    }
    //</editor-fold>

    //<editor-fold desc="Function: updateProduct">
    public void updateProduct() {
        if (productAdminList.getSelectionModel().getSelectedItem() != null) {
            try {
                Product product = productAdminList.getSelectionModel().getSelectedItem();
                if (product instanceof Game) {
                    updateProductWithType(product, Game.class);
                } else if (product instanceof Software) {
                    updateProductWithType(product, Software.class);
                } else if (product instanceof Subscriptions) {
                    updateProductWithType(product, Subscriptions.class);
                }
                refreshProduct();
            } catch (Exception e) {
                e.printStackTrace();
                // Popup.show("Field" + e.getMessage(), Popup.PopupType.WARNING);
            }
        } else {
            Popup.show("Please select a product first.", Popup.PopupType.WARNING);
        }
    }

    private <T extends Product> void updateProductWithType(Product product, Class<T> newType) {
        T productToUpdate = genericHibernate.getEntityById(newType, product.getID());
        productToUpdate.setTitle(titleField.getText());
        productToUpdate.setDescription(descriptionField.getText());
        productToUpdate.setGenrecateg(genrecategField.getText());
        productToUpdate.setDeveloper(devField.getText());
        productToUpdate.setVersion(versionField.getText());
        productToUpdate.setReleaseDate(releaseDateField.getValue());

        if (product instanceof Subscriptions && newType.equals(Subscriptions.class)) {
            Subscriptions subscriptionsToUpdate = (Subscriptions) productToUpdate;
            subscriptionsToUpdate.setDuration(durationField.getText());
        }

        genericHibernate.update(productToUpdate);
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
        genericHibernate.delete(Product.class, productAdminList.getSelectionModel().getSelectedItem().getID());
        refreshProduct();
    }
    //</editor-fold>

    public ProductController() {
        this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));;
    }


    public void refreshProduct() {
        productAdminList.getItems().clear();

        if(searchField.getText().isEmpty()) {
            productAdminList.getItems().addAll(genericHibernate.getAllRecords(Product.class));
        }
        else {
            ArrayList <Product> products = (ArrayList<Product>) genericHibernate.getAllRecords(Product.class);
            ArrayList <Product> searchProducts = new ArrayList<>();
            for (Product product: products) {
                if (product.getTitle().toLowerCase().contains(searchField.getText().toLowerCase())) {
                    searchProducts.add(product);
                }
            }
            productAdminList.getItems().addAll(searchProducts);
        }
    }

    public void clearProductFields() {
        titleField.clear();
        descriptionField.clear();
        genrecategField.clear();
        devField.clear();
        devField.clear();
        versionField.clear();
        durationField.clear();
        releaseDateField.setValue(null);
    }
}
