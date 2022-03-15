package com.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project1.dto.LoanRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //Skal gøres til foreign key, så hvert loan er til tildelt et memeber
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username")
    private Member username;

    //Auto set date when a loan is made
    @Column
    @CreationTimestamp
    private LocalDateTime checkoutdate;

    @Column
    private LocalDateTime duedate;

    @Column
    private LocalDateTime returneddate;


    public Loan(LoanRequest body) {
        this.username = body.getUsername();
        this.checkoutdate = body.getCheckoutdate();
        this.duedate = body.getDuedate();
        this.returneddate = body.getReturneddate();
    }
}
