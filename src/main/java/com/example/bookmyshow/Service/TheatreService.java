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

    public Theatre saveTheatre(String theatreName,String address ,int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(theatreName);
        theatre.setAddress(address);
        theatre.setCity(cityService.getByCityId(cityId));
        Theatre savedTheatre = theatreRepository.save(theatre);

        City city = cityService.getByCityId(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return savedTheatre;
    }
}
