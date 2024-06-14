package com.kursinis.kursinis.fxControllers;

import com.kursinis.kursinis.hibernate.GenericHibernate;
import com.kursinis.kursinis.model.Comment;
import com.kursinis.kursinis.model.Product;
import com.kursinis.kursinis.model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CommentsWindowController implements Initializable {

    @FXML
    public TreeView<Comment> commentTree;
    @FXML
    public TextField commentTextField;
    @FXML
    public Slider ratingSlider;
    @FXML
    public Button commentButton;
    @FXML
    public Button deleteButton;

    Product product;
    User author;
    private GenericHibernate genericHibernate;
    private EntityManagerFactory entityManagerFactory;

    public CommentsWindowController() {
        this.genericHibernate = new GenericHibernate(Persistence.createEntityManagerFactory("Shop"));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Shop");
    }
    public void submitComment() {
            Comment comment;
            TreeItem<Comment> selectedTreeItem = commentTree.getSelectionModel().getSelectedItem();
            if (selectedTreeItem == null) {
                 comment = new Comment(
                        product,
                        author,
                        null,
                        commentTextField.getText(),
                        (int)ratingSlider.getValue()
                );

            } else {
                 comment = new Comment(
                        product,
                        author,
                        selectedTreeItem.getValue(),
                        commentTextField.getText(),
                        (int)ratingSlider.getValue()
                );

            }
            genericHibernate.create(comment);
            readComments();
    }

    private void buildCommentTree(TreeItem<Comment> rootItem, Product product, Comment parentComment) {
        List<Comment> productComments = genericHibernate.getProductComments(product,parentComment);
        for (Comment comment : productComments) {
            TreeItem<Comment> newItem = new TreeItem<>(comment);
            rootItem.getChildren().add(newItem);
            buildCommentTree(newItem,product,comment);
        }
    }

    public void readComments() {
            TreeItem<Comment> rootItem = new TreeItem<Comment>();
            commentTree.setRoot(rootItem);
            commentTree.setShowRoot(false);
            buildCommentTree(rootItem,product,null);
            commentTree.refresh();
    }

    public void deleteComment() {
        genericHibernate.delete(Comment.class, commentTree.getSelectionModel().getSelectedItem().getValue().getID());
        readComments();
    }

    public void setCommentProductFromShop(Product product)  {
        this.product = product;
    }

    public void setCommentAuthor(User author) {
        this.author = author;
        if (author.getAcctype().equals("Manager") && author.getIsAdmin().equals("true")) {
            System.out.println("mewing");
            deleteButton.setVisible(true);
        }
    }

}
