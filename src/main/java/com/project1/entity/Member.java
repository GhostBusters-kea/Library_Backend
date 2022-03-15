package com.project1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project1.dto.MemberRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id
    @Column(length = 50)
    private String username;

    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(length = 40)
    private String firstName;

    @Column(length = 60)
    private String lastName;

    @Column(length = 60)
    private String street;

    @Column(length = 30)
    private String city;

    @Column(length = 4)
    private String zip;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @JsonIgnore
    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Reservation> reservations = new HashSet<>();

    public Member(String username, String email, String password, String firstName, String lastName, String street, String city, String zip) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Member(MemberRequest body) {
        this.username = body.getUsername();
        this.email = body.getEmail();
        this.password = body.getPassword();
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();
        this.street = body.getStreet();
        this.city = body.getCity();
        this.zip = body.getZip();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
}