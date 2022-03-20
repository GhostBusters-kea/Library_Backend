package com.project1.service;

import com.project1.dto.LoanRequest;
import com.project1.dto.LoanResponse;
import com.project1.entity.Book;
import com.project1.entity.Library;
import com.project1.entity.Loan;
import com.project1.entity.Member;
import com.project1.repository.BookRepository;
import com.project1.repository.LoanRepository;
import com.project1.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoanServiceTest {

    @Autowired
    LoanRepository loanRepository;
    LoanService loanService;

    @BeforeAll
    static void setUp(@Autowired LoanRepository loanRepository, @Autowired MemberRepository memberRepository) {

        Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");
        Member b = new Member("hans","123@f.dk","dj","dd","dd","dd",
                "by","1112");
        memberRepository.save(a);
        memberRepository.save(b);

        Loan loan = new Loan(a, LocalDateTime.of(2022, Month.MARCH, 1, 01, 1, 1, 1), LocalDateTime.of(2022, Month.MARCH, 2, 02, 1, 1, 1));
        loanRepository.save(loan);
    }

    @BeforeEach
    public void setupService(){
        loanService = new LoanService(loanRepository);
    }


    @Test
    void getAllLoansOnMember() {
        List<LoanResponse> loanResponseList = loanService.getLoans();
        assertEquals(1, loanResponseList.size());
        assertEquals("ole", loanResponseList.get(0).getMemberResponse().getUsername());
    }

    @Test
    void addLoan() {
        Member a = new Member("ole","k@f.dk","djdj","Svend","Svendsen","Gade",
                "by","1111");
        Loan loan = new Loan(a, LocalDateTime.of(2022, Month.MARCH, 1, 01, 1, 1, 1), LocalDateTime.of(2022, Month.MARCH, 2, 02, 1, 1, 1));

        //loanService.addLoan()
    }

    @Test
    void editLoan() {
    }

    @Test
    void deleteLoan() {
    }
}