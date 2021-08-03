package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.siit.airport.domain.Airport;

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
    private String departureAirportId;
    private String arrivalAirportId;
    private String airlineId;
}
