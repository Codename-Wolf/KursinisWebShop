package com.kursinis.kursinis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User author;
    @ManyToOne
    private Comment parentComment;
    private String commentBody;
    private int rating;

    public Comment(Product product, User author, Comment parentComment, String commentBody, int rating) {
        this.product = product;
        this.author = author;
        this.parentComment = parentComment;
        this.commentBody = commentBody;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return author.getName() + " " + author.getSurname() + " /Rated:" + "♥".repeat(this.rating) + "/ " + commentBody;
    }
}
