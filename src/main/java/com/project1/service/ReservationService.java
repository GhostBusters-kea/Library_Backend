package com.project1.service;

import com.project1.dto.LibraryRequest;
import com.project1.dto.LibraryResponse;
import com.project1.dto.ReservationRequest;
import com.project1.dto.ReservationResponse;
import com.project1.entity.Book;
import com.project1.entity.Library;
import com.project1.entity.Reservation;
import com.project1.error.ClientException;
import com.project1.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> getReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    }

    public List<ReservationResponse> getReservationsByMember(String username){
        try {
            List<Reservation> reservations = reservationRepository.findReservationByMember_Username(username);
            return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());

        } catch (Exception e){
            throw new ClientException("Reservations not found");
        }
    }

    public List<ReservationResponse> getReservationsByBook(int id){
        try {
            List<Reservation> reservations = reservationRepository.findReservationByBook_Id(id);
            return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
        } catch (Exception e){
            throw new ClientException("Reservations not found");
        }
    }

    public ReservationResponse getReservation(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->
                new ClientException("Reservation not found",HttpStatus.NOT_FOUND));
        return new ReservationResponse(reservation);
    }

    public Reservation getReservationToAddMemberOrBook(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->
                new ClientException("Reservation not found", HttpStatus.NOT_FOUND));
        return reservation;
    }

    public ReservationResponse addReservation(ReservationRequest body){
        Reservation newReservation = reservationRepository.save(new Reservation(body));
        return new ReservationResponse(newReservation);
    }

    public void deleteReservation(int id){
        if(!reservationRepository.existsById(id)){
            throw new ClientException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

}
