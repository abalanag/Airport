package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long id;
    private String flightNumber;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private String departureAirport;
    private String arrivalAirport;
    private String airline;
}
