package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer> {
    Auditorium findAuditoriumByName(String name);
}
