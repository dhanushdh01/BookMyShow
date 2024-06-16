package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.BookTicketRequestDTO;
import com.example.bookmyshow.Models.Ticket;
import com.example.bookmyshow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket/{id}")
    public ResponseEntity getTicketById(@PathVariable("id") int ticketId){
        Ticket savedTicket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(savedTicket);
    }

    @PostMapping("/ticket")
    public ResponseEntity bookticket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        Ticket savedTicket = ticketService.bookTicket(
                bookTicketRequestDTO.getShowSeatNumbers(),
                bookTicketRequestDTO.getUserId()
        );
        return ResponseEntity.ok(savedTicket);
    }
}
