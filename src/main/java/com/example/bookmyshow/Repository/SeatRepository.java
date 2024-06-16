package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Seat findSeatBySeatNumber(String seatNumber);
}
