package com.project1.configuration;


import com.project1.entity.*;
import com.project1.repository.*;

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

    public MakeTestData(ReservationRepository reservationRepository, MemberRepository memberRepository, LoanRepository loanRepository, BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public void makeData(){

        /*Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");

        Member b = new Member("ib","j@k.dk","jjj","Jens","Jensen",
                "Gade","Kbh","1234");

        memberRepository.save(a);


        Book ee= new Book();
        bookRepository.save(ee);

        Reservation e = new Reservation(a,ee);
        reservationRepository.save(e);

        Library l = new Library();

        Loan newLoan = new Loan();
        loanRepository.save(newLoan);*/

    }

    @Override
    public void run(ApplicationArguments args){
        /*
        reservationRepository.deleteAll();
        memberRepository.deleteAll();
        bookRepository.deleteAll();
        makeData();*/
    }

}
