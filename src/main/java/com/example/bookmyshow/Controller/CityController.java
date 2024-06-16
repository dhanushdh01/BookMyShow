package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.CityRequestDTO;
import com.example.bookmyshow.Models.City;
import com.example.bookmyshow.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City savedCity = cityService.getByCityName(cityName);
        return ResponseEntity.ok(savedCity);
    }

    @GetMapping("/city")
    public ResponseEntity getAllCities(){
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        try {
            String cityName = cityRequestDTO.getCityName();
            if(cityName.isBlank() || cityName.isEmpty() || cityName == null){
                throw new Exception("City Name cannot be empty");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        cityService.deleteCity(cityId);
        return ResponseEntity.ok("City Deleted Successfully");
    }
}
