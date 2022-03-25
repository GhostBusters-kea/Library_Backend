package com.project1.api;

import com.project1.dto.ReservationRequest;
import com.project1.dto.ReservationResponse;
import com.project1.entity.Book;
import com.project1.entity.Member;
import com.project1.entity.Reservation;
import com.project1.repository.MemberRepository;
import com.project1.repository.ReservationRepository;
import com.project1.service.BookService;
import com.project1.service.MemberService;
import com.project1.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    ReservationService reservationService;
    BookService bookService;
    MemberService memberService;

    public ReservationController(ReservationService reservationService, BookService bookService, MemberService memberService) {
        this.reservationService = reservationService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @GetMapping
    List<ReservationResponse> getReservations(){return reservationService.getReservations();}

    @GetMapping("/{id}")
    ReservationResponse getReservation(@PathVariable int id){return reservationService.getReservation(id); }

    @PostMapping
    ReservationResponse addReservation(@RequestBody ReservationRequest body){
        return reservationService.addReservation(body);
    }

    @PutMapping("/{reservationId}/books/{bookId}")
    public void addBookToReservation(
            @PathVariable int reservationId,
            @PathVariable int bookId
    ){
        Reservation reservation = reservationService.getReservationToAddMemberOrBook(reservationId);
        Book book = bookService.getBookToReservation(bookId);
        reservation.setBook(book);
        reservationService.saveReservation(reservation);
    }

    @PutMapping("/{reservationId}/members/{username}")
    public void addMemberToReservation(
            @PathVariable int reservationId,
            @PathVariable String username
    ){
        Reservation reservation = reservationService.getReservationToAddMemberOrBook(reservationId);
        Member member = memberService.getMemberToReservation(username);
        reservation.setMember(member);
        reservationService.saveReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationService.deleteReservation(id);
    }
}
