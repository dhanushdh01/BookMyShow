package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Constant.ShowSeatStatus;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;

    public Ticket bookTicket(List<Integer> showSeatIds,int userId) throws Exception {
        checkAndLockSeats(showSeatIds);
        startPayment(showSeatIds);
        return new Ticket();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkAndLockSeats(List<Integer> showSeatIds) throws Exception {
        for(int showSeatId:showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new Exception("Seat is not available");
            }
        }
        // Updating the seats to be locked
        for(int showSeatId:showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(showSeat);
        }
    }

    public boolean startPayment(List<Integer> showSeatIds){
        // Payment Gateway Logic
        return true;
    }

    public Ticket getTicketById(int ticketId){
        // Fetch Ticket from DB
        return new Ticket();
    }

}
