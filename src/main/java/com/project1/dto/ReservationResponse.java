package com.project1.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.project1.entity.Reservation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class ReservationResponse {

    private int id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime reservationDate;
    private MemberResponse memberResponse;
    private BookResponse bookResponse;

    public ReservationResponse(Reservation reservation){
        this.id=reservation.getId();
        this.reservationDate=reservation.getReservationDate();
        this.memberResponse= new MemberResponse(reservation.getMember());
        this.bookResponse= new BookResponse(reservation.getBook(),false);

    }


}
