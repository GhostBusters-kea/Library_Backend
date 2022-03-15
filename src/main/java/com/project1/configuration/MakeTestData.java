package com.project1.configuration;


import com.project1.entity.Loan;
import com.project1.entity.Member;
import com.project1.entity.Reservation;
import com.project1.repository.LoanRepository;
import com.project1.repository.MemberRepository;
import com.project1.repository.ReservationRepository;

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

    public MakeTestData(ReservationRepository reservationRepository, MemberRepository memberRepository, LoanRepository loanRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    public void makeData(){
        /*Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");

        Member b = new Member("ib","j@k.dk","jjj","Jens","Jensen",
                "Gade","Kbh","1234");

        memberRepository.save(a);


        Reservation e = new Reservation(a);
        reservationRepository.save(e);

         */


        Loan newLoan = new Loan();
        loanRepository.save(newLoan);



    }

    @Override
    public void run(ApplicationArguments args){
        reservationRepository.deleteAll();
        memberRepository.deleteAll();
        makeData();
    }

}

