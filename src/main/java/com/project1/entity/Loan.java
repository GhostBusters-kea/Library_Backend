package com.project1.entity;

import com.project1.dto.LoanRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="bookid", referencedColumnName = "id")
    private Book bookId;

    //Auto set date when a loan is made
    @Column
    @CreationTimestamp
    private LocalDate checkoutdate;

    @Column
    private LocalDate duedate;

    @Column
    private LocalDate returneddate;

    /*
    public Loan(LoanRequest body) {
        this.username = body.getUsername();
        this.bookId = body.getBookId();
        this.checkoutdate = body.getCheckoutdate();
        this.duedate = body.getDuedate();
        this.returneddate = body.getReturneddate();
    }

     */

    public Loan(Member username, LocalDate duedate, LocalDate returneddate) {
        this.username = username;
        this.duedate = duedate;
        this.returneddate = returneddate;
    }

    public Loan(LoanRequest body){
        this.username = body.getUsername();
        this.duedate = body.getDuedate();
        this.returneddate = body.getReturneddate();
    }

}
