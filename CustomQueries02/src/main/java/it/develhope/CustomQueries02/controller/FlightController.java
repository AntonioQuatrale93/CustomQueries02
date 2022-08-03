package it.develhope.CustomQueries02.controller;

import it.develhope.CustomQueries02.entities.Flight;
import it.develhope.CustomQueries02.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @PostMapping("")
    public void scheduleFlights(@RequestParam @Nullable Integer n) {
        flightService.setFlight(n);
    }


    @GetMapping("")
    public Page<Flight> getFlightsPaginate(@RequestParam Integer page, @RequestParam Integer size) {
        return flightService.getFlightPaginate(page, size);
    }

    @GetMapping("/all")
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightService.onTimeFlight();
    }

    @GetMapping("/status")
    public List<Flight> getFlightByStatus(@RequestParam String p1, @RequestParam String p2) {
        return flightService.getFlightsByStatus(p1, p2);
    }


}
