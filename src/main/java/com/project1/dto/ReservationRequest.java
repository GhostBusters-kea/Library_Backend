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
public class ReservationRequest {
    private int id;
    private LocalDateTime reservationDate;
    private Member member;
    private Book book;

}
