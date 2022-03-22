package com.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BookRequest {
    private int id;
    private String isbnNumber;
    private String title;
    private String authors;
    private String publisher;
    private String publishYear;

}
