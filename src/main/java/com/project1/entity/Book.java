package com.project1.entity;

import com.project1.dto.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, unique = true, length = 100)
    private String isbnNumber;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private String authors;

    @Column(nullable = false, length = 50)
    private String publisher;

    @Column (nullable = false, length = 4)
    private String publishYear;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    public Book(BookRequest body) {
        this.isbnNumber = body.getIsbnNumber();
        this.title = body.getTitle();
        this.authors = body.getAuthors();
        this.publisher = body.getPublisher();
        this.publishYear = body.getPublishYear();
    }

    //Mangler noget mapping

}
