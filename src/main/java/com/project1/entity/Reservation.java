package com.project1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private LocalDateTime reservationDate;


    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Member member;

    /*
    @ManyToOne
    @JoinColumn(name="isbn", referenceColumnName = "isbn")
    private Book book;

    */

    public Reservation(Member member){
    this.member=member;
    // this.book=book;
    member.addReservation(this);
    // book.addReservation(this);
    }

}
