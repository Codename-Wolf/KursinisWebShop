package com.kursinis.kursinis.fxControllers;

import com.kursinis.kursinis.MainApplication;
import com.kursinis.kursinis.hibernate.GenericHibernate;
import com.kursinis.kursinis.model.*;
import com.kursinis.kursinis.utils.Popup;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import javafx.scene.text.Text;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    @FXML
    public TabPane tabs;
    @FXML
    public Tab shopTab;
    @FXML
    public Tab productsTab;
    @FXML
    public Tab usersTab;
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
    public Button logout;
    @FXML
    public RadioButton gameRadioButton;
    @FXML
    public RadioButton softwareRadioButton;
    @FXML
    public RadioButton subRadioButton;
    @FXML
    public TextField searchField;
    @FXML
    public TableView<User> usersTableView;
    @FXML
    public TableColumn<User, String> accTypeColumn;
    @FXML
    public TableColumn<User, String> emailColumn;
    @FXML
    public TableColumn<User, String > loginColumn;
    @FXML
    public TableColumn<User, String> nameColumn;
    @FXML
    public TableColumn<User, String> surnameColumn;
    @FXML
    public TableColumn<User, String> isAdminColumn;
    @FXML
    public ListView<Product> shopProductList;
    @FXML
    public Text titleShopText;
    @FXML
    public Text descriptionShopText;
    @FXML
    public Text genrecategShopText;
    @FXML
    public Text developerShopText;
    @FXML
    public Text releaseDateShopText;
    @FXML
    public Text durationShopText;
    @FXML
    public Text priceShopText;
    @FXML
    public TextField priceField;
    @FXML
    public TextField shopSearch;
    @FXML
    public Button refreshShopButton;
    @FXML
    public ChoiceBox<String> genrecategChoicebox;
    @FXML
    public ChoiceBox<String> developerChoicebox;
    @FXML
    public ChoiceBox<String> productTypeChoicebox;
    @FXML
    public Button filterButton;
    @FXML
    public ListView<Product> cartList;
    @FXML
    public ListView<Cart> orderList;
    @FXML
    public Button orderButton;
    @FXML
    public Text totalPriceText;

    @FXML
    public Text yourCartText;
    User user;
    Cart cart;
    private  GenericHibernate genericHibernate;
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");
        //<editor-fold desc="Table Column: AccType">
        accTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        accTypeColumn.setOnEditCommit(event -> {
            try {
                User user = event.getRowValue();
                user.setAcctype(event.getNewValue());
                genericHibernate.update(user);
            } catch (Exception e) {
                TableView<User> tableView = event.getTableView();
                TableColumn<User, String> col = event.getTableColumn();
                int row = event.getTablePosition().getRow();
                tableView.getItems().get(row).setAcctype(event.getOldValue());
                tableView.refresh();
            }
        });
        //</editor-fold>
        //<editor-fold desc="Table Column: Email">
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit(event -> {
            try {
                User user = event.getRowValue();
                user.setEmail(event.getNewValue());
                genericHibernate.update(user);
            } catch (Exception e) {
                TableView<User> tableView = event.getTableView();
                TableColumn<User, String> col = event.getTableColumn();
                int row = event.getTablePosition().getRow();
                tableView.getItems().get(row).setEmail(event.getOldValue());
                tableView.refresh();
            }
        });
        //</editor-fold>
        //<editor-fold desc="Table Column: Login">
        loginColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        loginColumn.setOnEditCommit(event -> {
            try {
                User user = event.getRowValue();
                user.setLogin(event.getNewValue());
                genericHibernate.update(user);
            } catch (Exception e) {
                TableView<User> tableView = event.getTableView();
                TableColumn<User, String> col = event.getTableColumn();
                int row = event.getTablePosition().getRow();
                tableView.getItems().get(row).setLogin(event.getOldValue());
                tableView.refresh();
            }
        });
        //</editor-fold>
        //<editor-fold desc="Table Column: Name">
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            try {
                User user = event.getRowValue();
                user.setName(event.getNewValue());
                genericHibernate.update(user);
            } catch (Exception e) {
                TableView<User> tableView = event.getTableView();
                TableColumn<User, String> col = event.getTableColumn();
                int row = event.getTablePosition().getRow();
                tableView.getItems().get(row).setName(event.getOldValue());
                tableView.refresh();
            }
        });
        //</editor-fold>
        //<editor-fold desc="Table Column: Surname">
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameColumn.setOnEditCommit(event -> {
            try {
                User user = event.getRowValue();
                user.setSurname(event.getNewValue());
                genericHibernate.update(user);
            } catch (Exception e) {
                TableView<User> tableView = event.getTableView();
                TableColumn<User, String> col = event.getTableColumn();
                int row = event.getTablePosition().getRow();
                tableView.getItems().get(row).setSurname(event.getOldValue());
                tableView.refresh();
            }
        });
        //</editor-fold>
        productTypeChoicebox.setItems(FXCollections.observableArrayList(null, "Game", "Software", "Subscriptions"));
        List<Product> products = genericHibernate.getAllRecords(Product.class);
        Set<String> developers = new HashSet<>();
        Set<String> genrecateg = new HashSet<>();
        for(Product product : products) {
            developers.add(product.getDeveloper());
            genrecateg.add(product.getGenrecateg());
        }
        genrecateg.add(null);
        developers.add(null);
        genrecategChoicebox.setItems(FXCollections.observableArrayList(genrecateg));
        developerChoicebox.setItems(FXCollections.observableArrayList(developers));

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
                        releaseDateField.getValue(),
                        Float.parseFloat(priceField.getText())
                );
                genericHibernate.create(game);
            } else if (softwareRadioButton.isSelected()) {
                Software software = new Software(
                        titleField.getText(),
                        descriptionField.getText(),
                        genrecategField.getText(),
                        devField.getText(),
                        versionField.getText(),
                        releaseDateField.getValue(),
                        Float.parseFloat(priceField.getText())
                );
                genericHibernate.create(software);
            } else if (subRadioButton.isSelected()) {
                Subscriptions subscriptions = new Subscriptions(
                        titleField.getText(),
                        descriptionField.getText(),
                        genrecategField.getText(),
                        devField.getText(),
                        releaseDateField.getValue(),
                        durationField.getText(),
                        Float.parseFloat(priceField.getText())
                );
                genericHibernate.create(subscriptions);
            }
        } catch (Exception e) {
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
            priceField.setText(String.valueOf(game.getPrice()));
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
            priceField.setText(String.valueOf(software.getPrice()));
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
            priceField.setText(String.valueOf(subscriptions.getPrice()));
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

    public MainController() {
        this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));
    }

    public void setUser(User user) {
        this.user = user;
        if (user.getAcctype().equals("Customer")) {
        tabs.getTabs().remove(productsTab);
        tabs.getTabs().remove(usersTab);
        if (user instanceof Customer) {
            this.cart = genericHibernate.getCartByCartSearch((Customer) user);
            }
        }
        else{
            tabs.getTabs().remove(shopTab);
            orderButton.setVisible(false);
            totalPriceText.setVisible(false);
            yourCartText.setText("Orders");
        }
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
        priceField.clear();
    }
    public void loadUsers() {
        List<User> allRecords = genericHibernate.getAllRecords(User.class);
        usersTableView.getItems().setAll(allRecords);
        usersTableView.refresh();
        usersTableView.getSelectionModel().clearSelection();
    }

    public void deleteUser() {
        genericHibernate.delete(User.class, usersTableView.getSelectionModel().getSelectedItem().getId());
        loadUsers();
    }

    @SneakyThrows
    public void logoutAction() {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) tabs.getScene().getWindow();
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //<editor-fold desc="Function: readShopProduct">
    public void readShopProduct() {
        Product product = shopProductList.getSelectionModel().getSelectedItem();
            titleShopText.setText("Title: " + product.getTitle());
            descriptionShopText.setText("Description: " + product.getDescription());
            genrecategShopText.setText("Genre/Category: " + product.getGenrecateg());
            developerShopText.setText("Developer: " + product.getDeveloper());
            releaseDateShopText.setText("Release date: " + product.getReleaseDate());
            if(product instanceof Subscriptions) {
                durationShopText.setText("Duration (subscription): " + ((Subscriptions) product).getDuration());
            }
            priceShopText.setText("Price: " + product.getPrice() + " €");

    }
    //</editor-fold>
    public void refreshShopProduct() {
        shopProductList.getItems().clear();

        if(shopSearch.getText().isEmpty()) {
            shopProductList.getItems().addAll(genericHibernate.getAllRecords(Product.class));
        }
        else {
            ArrayList <Product> products = (ArrayList<Product>) genericHibernate.getAllRecords(Product.class);
            ArrayList <Product> searchProducts = new ArrayList<>();
            for (Product product: products) {
                if (product.getTitle().toLowerCase().contains(shopSearch.getText().toLowerCase())) {
                    searchProducts.add(product);
                }
            }
            shopProductList.getItems().addAll(searchProducts);
        }
    }

    @SneakyThrows
    public void openCommentsWindow() {
        if (shopProductList.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("comments-window.fxml"));
            Parent root = loader.load();
            CommentsWindowController commentsWindowController = loader.getController();
            commentsWindowController.setCommentProductFromShop(shopProductList.getSelectionModel().getSelectedItem());
            commentsWindowController.setCommentAuthor(user);
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Comments");
            primaryStage.setScene(scene);
            primaryStage.showAndWait();
        }
        else {
            Popup.show("Please select a product first.", Popup.PopupType.WARNING);
        }
    }

    public void filter() {
        List<Product> products = genericHibernate.getAllRecords(Product.class);
        ObservableList<Product> filteredProducts = FXCollections.observableArrayList();
        for (Product product : products) {
            if (product.getGenrecateg().equals(genrecategChoicebox.getValue())) {
                filteredProducts.add(product);
            } else if (product.getDeveloper().equals(developerChoicebox.getValue())) {
                filteredProducts.add(product);
            } else if (product instanceof Game) {
                if (productTypeChoicebox.getValue() != null) {
                    if (productTypeChoicebox.getValue().equals("Game")) {
                        filteredProducts.add(product);
                    }
                }
            } else if (product instanceof Software) {
                if (productTypeChoicebox.getValue() != null) {
                    if (productTypeChoicebox.getValue().equals("Software")) {
                        filteredProducts.add(product);
                    }
                }
            } else if (product instanceof Subscriptions) {
                if (productTypeChoicebox.getValue() != null) {
                    if (productTypeChoicebox.getValue().equals("Subscription")) {
                        filteredProducts.add(product);
                    }
                }
            }
        }
        shopProductList.setItems(filteredProducts);
        shopProductList.refresh();
    }

    public void addProductToCart() {
        if (shopProductList.getSelectionModel().getSelectedItem() != null) {
            cart.addProduct(shopProductList.getSelectionModel().getSelectedItem());
            genericHibernate.update(cart);
        }
    }

    public void refreshCartList() {
        if (user instanceof Customer) {
            cartList.setItems(FXCollections.observableArrayList(cart.getProductList()));
            orderList.setVisible(false);
            float totalPrice = 0;
            for(Product product : cart.getProductList()) {
                totalPrice += product.getPrice();
            }
            totalPriceText.setText("Total price: " + totalPrice + " €");
        }
        else if (user instanceof Manager) {
            cartList.setVisible(false);
            refreshOrderList();
        }
    }

    public void order() {
        cart.setOrderstate("UNASSIGNED");
        genericHibernate.update(cart);
        cart = genericHibernate.getCartByCartSearch((Customer) user);
        refreshCartList();
    }

    public void refreshOrderList() {
        ObservableList<Cart> orders = FXCollections.observableArrayList();
        List<Cart> carts = genericHibernate.getAllRecords(Cart.class);
        for(Cart cart : carts) {
            if(!cart.getOrderstate().equals("NOT_PLACED")) {
                orders.add(cart);
            }
        }
        orderList.setItems(orders);
    }
}