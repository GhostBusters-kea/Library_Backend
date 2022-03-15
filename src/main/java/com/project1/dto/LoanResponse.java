package com.project1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project1.entity.Loan;
import com.project1.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanResponse {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime checkoutdate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime duedate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime returneddate;

    private Member username;

    //Get all loan info
    public LoanResponse(Loan loan){
        this.checkoutdate = loan.getCheckoutdate();
        this.duedate = loan.getDuedate();
        this.returneddate = loan.getReturneddate();
        this.username = loan.getUsername();
    }

    public static List<LoanResponse> getLoansFromEntity(List<Loan> loans){
        return loans.stream().map(loan -> new LoanResponse(loan)).collect(Collectors.toList());
    }
}
