package com.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project1.dto.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column( unique = true, length = 100)
    private String isbnNumber;

    @Column(unique = true, length = 50)
    private String title;

    @Column( length = 50)
    private String authors;

    @Column( length = 50)
    private String publisher;

    @Column ( length = 4)
    private String publishYear;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    @JoinColumn(name = "library_id", referencedColumnName = "id")
    @ManyToOne
    private Library library;


    public Book(String isbnNumber, String title, String authors, String publisher, String publishYear, Library library) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
        library.addBook(this);
        this.setLibrary(library);
    }

    public Book(BookRequest body) {
        this.isbnNumber = body.getIsbnNumber();
        this.title = body.getTitle();
        this.authors = body.getAuthors();
        this.publisher = body.getPublisher();
        this.publishYear = body.getPublishYear();
    }

    //Mangler noget mapping

    public void addReservation(Reservation reservation){reservations.add(reservation);}

    public void setLibrary(Library library){this.library=library;}

}
