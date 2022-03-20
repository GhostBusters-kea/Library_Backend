package com.project1.service;

import com.project1.dto.ReservationResponse;
import com.project1.entity.Book;
import com.project1.entity.Member;
import com.project1.entity.Reservation;
import com.project1.repository.BookRepository;
import com.project1.repository.MemberRepository;
import com.project1.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@DataJpaTest
class ReservationServiceTest {

    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookRepository bookRepository;

    static int reservationId1, reservationId2;

    @BeforeEach
    void setUp(@Autowired ReservationRepository reservationRepository,
               @Autowired MemberRepository memberRepository,
               @Autowired BookRepository bookRepository) {
        Member m = new Member("Svend","e@2.dk","wrf3","erferf","ervfer","erfver","ercer","6666");
        Member m1 = new Member("Valdemar","f@g.dk","wec","wrvcwe","wercvwe","wervwe","wecew","4447");
        memberRepository.save(m);
        memberRepository.save(m1);
        Book b = new Book();
        Book b1 = new Book();
        bookRepository.save(b);
        bookRepository.save(b1);
        reservationId1 = reservationRepository.save(new Reservation(m,b)).getId();
        reservationId2 = reservationRepository.save(new Reservation(m1,b1)).getId();
    }

    @BeforeEach
    void setupService(){
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    void getReservations() {
        List<ReservationResponse> responses = reservationService.getReservations();
        assertEquals(2,responses.size());

    }
}