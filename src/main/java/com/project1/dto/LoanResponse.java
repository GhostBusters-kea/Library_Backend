package com.project1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project1.entity.Book;
import com.project1.entity.Loan;
import com.project1.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanResponse {
    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate checkoutdate;

    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate duedate;

    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate returneddate;

    private MemberResponse memberResponse;

    private Book bookId;

    private int id;

    //Get all loan info
    public LoanResponse(Loan loan){
        this.id = loan.getId();
        this.checkoutdate = loan.getCheckoutdate();
        this.duedate = loan.getDuedate();
        this.returneddate = loan.getReturneddate();
        this.memberResponse = new MemberResponse(loan.getUsername());
        this.bookId = loan.getBookId();
    }

    public static List<LoanResponse> getLoansFromEntity(List<Loan> loans){
        return loans.stream().map(loan -> new LoanResponse(loan)).collect(Collectors.toList());
    }
}
