package com.project1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project1.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
public class BookResponse {
    int id;
    String isbnNumber;
    String title;
    String authors;
    String publisher;
    String publishYear;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    public BookResponse(Book book, boolean allFields){
        this.id = book.getId();
        this.isbnNumber = book.getIsbnNumber();
        this.title = book.getTitle();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
        this.publishYear = book.getPublishYear();
        if (allFields) {
            this.created = book.getCreated();
            this.edited = book.getEdited();
        }
    }

    public static List<BookResponse> getBooksFromEntities(List<Book> books){
        return books.stream().map(book -> new BookResponse(book, false)).collect(Collectors.toList());
    }
}
