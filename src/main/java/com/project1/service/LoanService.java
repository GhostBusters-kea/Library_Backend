package com.project1.service;

import com.project1.dto.LoanRequest;
import com.project1.dto.LoanResponse;
import com.project1.entity.Loan;
import com.project1.entity.Member;
import com.project1.error.ClientException;
import com.project1.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public List<LoanResponse> getLoans(){
        List<Loan> loans = loanRepository.findAll();
        return LoanResponse.getLoansFromEntity(loans);
    }

    //Skal gøres, så alle loans kan findes på et memberid
    public List<LoanResponse> getAllLoansOnMember(String username) {
        Member member = new Member(username);
        List<Loan> loans = loanRepository.findAllLoanByUsername(member);
        return LoanResponse.getLoansFromEntity(loans);
    }

    //Denne metode skal gerne kunne bruges til at tilføje individuelt dates

    public LoanResponse addLoan(LoanRequest body){
        Loan newCheckoutDate = loanRepository.save(new Loan(body));
        return new LoanResponse(newCheckoutDate);
    }

    /*
    public LoanResponse addLoan(LoanRequest body, Member memberUsername){
        Loan newCheckoutDate = loanRepository.save(new Loan(body));
        //Tror ikke linje 30 er nødvendig
        newCheckoutDate.setUsername(memberUsername);
        return new LoanResponse(newCheckoutDate);
    }
     */

    public LoanResponse editLoan(LoanRequest body, int loanId){
        if(!(loanRepository.existsById(loanId))){
            throw new ClientException("No such loan exist");
        }
        Loan loanToEdit = new Loan(body);
        loanToEdit.setId(loanId);
        loanRepository.save(loanToEdit);
        return new LoanResponse(loanToEdit);
    }

    /*
    public void deleteLoan(int loanId){
        List<Loan> loanList = loanRepository.findById(loanId).stream().collect(Collectors.toList());
        loanRepository.deleteAllById((Iterable<? extends Integer>) loanList.remove(loanId));

    }

     */

    public void deleteLoan(int loanId){
        if(!loanRepository.existsById(loanId)){
            throw new ClientException("Loan not found");
        }
        loanRepository.deleteById(loanId);
    }
}