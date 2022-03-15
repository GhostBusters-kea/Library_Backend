package com.project1.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.project1.entity.Library;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class LibraryResponse {
    private int id;
    private String name;
    // private Set<BookResponse> books = new HashSet<>();

    public LibraryResponse(Library library){
        this.id= library.getId();
        this.name= library.getName();
        //this.book= library.getBooks():
    }

}
