package com.project1.configuration;



import com.project1.entity.Loan;
import com.project1.entity.Member;
import com.project1.repository.LoanRepository;
import com.project1.repository.MemberRepository;
import com.project1.repository.ReservationRepository;

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

        /*

        Member b = new Member("ib","j@k.dk","jjj","Jens","Jensen",
                "Gade","Kbh","1234");




        Book ee= new Book();
        bookRepository.save(ee);

        Reservation e = new Reservation(a,ee);
        reservationRepository.save(e);


        Library l = new Library();

        Loan newLoan = new Loan();
        loanRepository.save(newLoan);*/

        /*
        Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");
        Member b = new Member("hans","123@f.dk","dj","dd","dd","dd",
                "by","1112");
        memberRepository.save(a);
        memberRepository.save(b);

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
        /*
        reservationRepository.deleteAll();
        memberRepository.deleteAll();
        bookRepository.deleteAll();

         */
        makeData();
    }

}

