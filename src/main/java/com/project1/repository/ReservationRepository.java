package com.project1.repository;

import com.project1.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findReservationByMember_Username(String username);

    List<Reservation> findReservationByBook_Id(int id);


}
