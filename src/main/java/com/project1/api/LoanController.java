package com.project1.api;

import com.project1.dto.LoanRequest;
import com.project1.dto.LoanResponse;
import com.project1.entity.Loan;
import com.project1.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/loan")
public class LoanController {
    LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<LoanResponse> getLoans(){
        return loanService.getLoans();
    }

    @GetMapping("/{username}")
    public List<LoanResponse> getLoansOnMember(@PathVariable String username){
        return (loanService.getAllLoansOnMember(username));
    }

    @PostMapping
    public LoanResponse addLoan(@RequestBody LoanRequest body){
        return loanService.addLoan(body);
    }

    @PutMapping("/{id}")
    public LoanResponse editCar(@RequestBody LoanRequest body, @PathVariable int id){
        return loanService.editLoan(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable int id){
        loanService.deleteLoan(id);
    }

}
