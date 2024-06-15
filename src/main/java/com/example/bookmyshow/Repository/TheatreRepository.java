package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
    Theatre findByTheatreName(String theatreName);
}
