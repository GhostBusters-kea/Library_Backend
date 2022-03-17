package com.project1.dto;

import com.project1.entity.Book;
import com.project1.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    private Member username;

    private Book bookId;

    private LocalDateTime checkoutdate;

    private LocalDateTime duedate;

    private LocalDateTime returneddate;
}
