package it.develhope.CustomQueries02.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "flight")
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    private StatusEnum enumStatus;
    // status serve a prendere il valore di enumStatus in modo che la custom query funzioni anche su sql
    @Column(name = "status")
    private String status = String.valueOf(enumStatus);


    public Flight(Long id, String description, String fromAirport, String toAirport, StatusEnum enumStatus) {
        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.enumStatus = enumStatus;
        this.status = String.valueOf(enumStatus);

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public StatusEnum getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(StatusEnum enumStatus) {
        this.enumStatus = enumStatus;
    }
}


