package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    City findByCityName(String name);
}
