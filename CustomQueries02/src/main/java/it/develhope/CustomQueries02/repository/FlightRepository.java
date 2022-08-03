package it.develhope.CustomQueries02.repository;

import it.develhope.CustomQueries02.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flight WHERE status = ?1 OR status =?2", nativeQuery = true)
    List<Flight> getByStatus(String p1, String p2);
}
