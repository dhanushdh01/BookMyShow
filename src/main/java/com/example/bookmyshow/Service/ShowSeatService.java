package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat saveShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }

    public ShowSeat getShowSeatById(int showSeatId){
        return showSeatRepository.findById(showSeatId).get();
    }
}
