package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.City;
import com.example.bookmyshow.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    // to get all cities
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    //to get a city by City Name
    public City getByCityName(String cityName) {
        /*
        City city = cityRepository.findByCityName(cityName);
        return city;
         */
        return cityRepository.findByCityName(cityName);
    }

    //to get city by city id
    public City getByCityId(int cityId) {
        City city= cityRepository.findById(cityId).get();
        return city;
    }

    //to save city in repo by city name
    public City saveCity(String cityName){
        City city =new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    //to save city in repo by city obj
    public City saveCity(City city){
        return cityRepository.save(city);
    }

    //to delete city in repo
    public boolean deleteCity(int cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }
}
