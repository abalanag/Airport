package ro.siit.airport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime departure;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime arrival;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_Id", nullable = false)
    private Airline airline;

    public Flight(String flightNumber, LocalDateTime departure, LocalDateTime arrival, Airport departureAirport, Airport arrivalAirport, Airline airline) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.airline = airline;
    }
}
