package com.project1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project1.dto.LibraryRequest;
import com.project1.repository.LibraryRepository;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public Library(LibraryRequest body){
        this.id=body.getId();
        this.name= body.getName();
    }

}
