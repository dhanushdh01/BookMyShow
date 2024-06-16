package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Models.Constant.AuditoriumFeature;
import com.example.bookmyshow.Models.Constant.SeatStatus;
import com.example.bookmyshow.Models.Constant.SeatType;
import com.example.bookmyshow.Models.Constant.ShowSeatStatus;
import com.example.bookmyshow.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private  MovieRepository movieRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean initialise() {

        //City Initialization
        City city1 = new City("Bangalore", "Karnataka", "India");
        City city2 = new City("Mumbai", "Maharashtra", "India");
        City city3 = new City("Delhi", "Delhi", "India");

        //City Repository
        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);

        //City Find By Name
        City savedDelhi = cityRepository.findByCityName("Delhi");

        //Theatre Initialization
        Theatre dhanushTheatre = new Theatre("DMultiplex", "Address ... ", city1);
        Theatre nithinTheatre = new Theatre("NithinIMAX", "Address ... ", city2);

        //Theatre Repository
        theatreRepository.save(dhanushTheatre);
        theatreRepository.save(nithinTheatre);

        //Theatre Find By Name
        Theatre savedAshishTheatre = theatreRepository.findByTheatreName("DMultiplex");
        Theatre savedNithinTheatre = theatreRepository.findByTheatreName("NithinIMAX");

        //Theatre Set Theatres
        List<Theatre> delhiTheatres = new ArrayList<>();
        delhiTheatres.add(savedAshishTheatre);
        delhiTheatres.add(savedNithinTheatre);
        //Theatre Save in City
        savedDelhi.setTheatres(delhiTheatres);
        //City save in cityRepository
        cityRepository.save(savedDelhi);

        //Seat Initialization
        for(int i=1;i<=5;i++){
            Seat s = new Seat(i, i, i+ " "+i, SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        //Seat Repository
        List<Seat> savedSeats = seatRepository.findAll(); // returns all the data of the table, "select * from table"

        //Auditorium Initialization
        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY_ATMOS, AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeats);
        //Auditorium Repository
        auditoriumRepository.save(auditorium);


        Auditorium savedAudi = auditoriumRepository.findByAuditoriumName("Audi01");

        Theatre savedTheatre = theatreRepository.findByTheatreName("DMultiplex");

        //Theatre Set Auditoriums
        List<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(savedAudi);
        savedTheatre.setAuditoriums(auditoriums);
        theatreRepository.save(savedTheatre);

        Movie movie1 = new Movie(
                "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
                "English",
                148,
                "Sci-Fi",
                "Christopher Nolan",
                "Emma Thomas",
                "Christopher Nolan",
                "Hans Zimmer",
                "Syncopy",
                "https://www.youtube.com/watch?v=YoHD9XEInc0",
                "https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg",
                "2010-07-16",
                "Released",
                "PG-13",
                "8.8"
        );

        Movie movie2 = new Movie(
                "The Dark Knight",
                "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
                "English",
                152,
                "Action",
                "Christopher Nolan",
                "Charles Roven",
                "Jonathan Nolan",
                "Hans Zimmer",
                "Warner Bros.",
                "https://www.youtube.com/watch?v=EXeTwQWrcwY",
                "https://m.media-amazon.com/images/I/71pVHZl5xRL._AC_SY679_.jpg",
                "2008-07-18",
                "Released",
                "PG-13",
                "9.0"
        );

        Movie movie3 = new Movie(
                "Interstellar",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "English",
                169,
                "Adventure, Drama, Sci-Fi",
                "Christopher Nolan",
                "Emma Thomas",
                "Jonathan Nolan, Christopher Nolan",
                "Hans Zimmer",
                "Syncopy",
                "https://www.youtube.com/watch?v=zSWdZVtXT7E",
                "https://m.media-amazon.com/images/I/71qK7Tl4X-L._AC_SY679_.jpg",
                "2014-11-07",
                "Released",
                "PG-13",
                "8.6"
        );
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findByMovieName("Inception"));
        show.setAuditorium(auditoriumRepository.findByAuditoriumName("Audi01"));

        showRepository.save(show);

        for(int i=1;i<=5;i++){
            ShowSeat s = new ShowSeat(1251, showRepository.findById(1).get(),
                                        seatRepository.findSeatbySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }
        return true;
    }

}
