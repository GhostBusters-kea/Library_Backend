package com.project1.configuration;

import com.project1.entity.*;
import com.project1.repository.LoanRepository;
import com.project1.repository.MemberRepository;
import com.project1.repository.ReservationRepository;

import com.project1.repository.*;
import com.project1.service.ReservationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {
    ReservationRepository reservationRepository;
    MemberRepository memberRepository;
    LoanRepository loanRepository;
    BookRepository bookRepository;
    LibraryRepository libraryRepository;
    ReservationService reservationService;

    public MakeTestData(ReservationRepository reservationRepository, MemberRepository memberRepository, LoanRepository loanRepository, BookRepository bookRepository, LibraryRepository libraryRepository, ReservationService reservationService) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        this.reservationService = reservationService;
    }

    public void makeData(){
        /*

        // Members
        Member b = new Member("ib","j@k.dk","jjj","Jens","Jensen",
                "Gade","Kbh","1234");

        Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");
        Member c = new Member("hans","123@f.dk","dj","dd","dd","dd",
                "by","1112");

        memberRepository.save(a);
        memberRepository.save(b);
        memberRepository.save(c);

        // Libraries
        Library l1 = new Library("Vesterbro");
        Library l2 = new Library("Nørrebro");
        Library l3 = new Library("Østerbro");
        Library l4 = new Library("Amager");
        Library l5 = new Library("Sydhavnen");
        Library l6 = new Library("Nordvest");

        libraryRepository.save(l1);
        libraryRepository.save(l2);
        libraryRepository.save(l3);
        libraryRepository.save(l4);
        libraryRepository.save(l5);
        libraryRepository.save(l6);


        // Books
        Book b1 = new Book("393939","Animal Farm","George Orwell",
                "Gyldeldal","2020",l1);

         */


        /*
        Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");
        Member b = new Member("hans","123@f.dk","dj","dd","dd","dd",
                "by","1112");
        memberRepository.save(a);
        memberRepository.save(b);
        Book b2 = new Book("393949","1984","George Orwell",
                "Gyldeldal","2020",l1);

        Book b3= new Book("395549","Bla","George Orwell",
                "Gyldeldal","2020",l1);

        Book b4 = new Book("393999","Blabla","George Orwell",
                "Gyldeldal","2020",l1);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);
        bookRepository.save(b4);

        // Reservations
        Reservation r1 = new Reservation();
        Reservation r2 = new Reservation();
        Reservation r3 = new Reservation();
        Reservation r4 = new Reservation();

        r1.setBook(b1);
        r2.setBook(b2);
        r3.setBook(b3);
        r4.setBook(b4);

        r1.setMember(a);
        r2.setMember(a);
        r3.setMember(b);
        r4.setMember(c);


        reservationService.saveReservation(r1);
        reservationService.saveReservation(r2);
        reservationService.saveReservation(r3);
        reservationService.saveReservation(r4);



/*
        Loan newLoan = new Loan();
        loanRepository.save(newLoan);*/

/*

        memberRepository.save(a);
        memberRepository.save(b);


        bookRepository.save(book);
        bookRepository.save(book2);

        Loan newLoan = new Loan();
        newLoan.setUsername(a);
        loanRepository.save(newLoan);
        Loan newLoan1 = new Loan();
        newLoan1.setUsername(a);
        loanRepository.save(newLoan1);
        Loan newLoan3 = new Loan();
        newLoan3.setUsername(b);
        loanRepository.save(newLoan3);

         */


    }

    @Override
    public void run(ApplicationArguments args){

        reservationRepository.deleteAll();
        memberRepository.deleteAll();
        bookRepository.deleteAll();
        libraryRepository.deleteAll();
        makeData();
    }

}
