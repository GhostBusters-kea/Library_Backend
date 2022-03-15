package com.project1.configuration;


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

    public MakeTestData(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    public void makeData(){

    }

    @Override
    public void run(ApplicationArguments args){
        memberRepository.deleteAll();
        makeData();
    }

}