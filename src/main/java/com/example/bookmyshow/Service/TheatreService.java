package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.City;
import com.example.bookmyshow.Models.Theatre;
import com.example.bookmyshow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;
    }


}