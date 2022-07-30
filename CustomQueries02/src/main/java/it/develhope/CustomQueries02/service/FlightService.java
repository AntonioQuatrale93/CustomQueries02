package it.develhope.CustomQueries02.service;

import it.develhope.CustomQueries02.entities.Flight;
import it.develhope.CustomQueries02.entities.StatusEnum;
import it.develhope.CustomQueries02.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public void setFlight(Integer n) {
        Integer counter = 0;
        Random random = new Random();
        if (n == null) {
            n = 100;
        }
        while (counter != n) {
            Flight flight = new Flight(random.ints(200).count(), random.ints(200).toString(), random.ints(200).toString(), random.ints(200).toString(), StatusEnum.getRandom());
            flightRepository.save(flight);
            counter++;
        }
    }


    public Page<Flight> getFlightPaginate(Integer page, Integer size) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "fromAirport"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Flight> flights = flightRepository.findAll(pageable);
        return flights;
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }


    public List<Flight> onTimeFlight() {
        List<Flight> flightList = new ArrayList<>();
        flightRepository.findAll().forEach(singleFlight -> {
            if (singleFlight.getEnumStatus() == StatusEnum.ONTIME) {
                flightList.add(singleFlight);
            }
        });
        return flightList;
    }


    public List<Flight> getFlightsByStatus(String status) {
        return flightRepository.getByStatus(status);
    }


}
