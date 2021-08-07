package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditFlightDto {
    private Long id;
    private String flightNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime departure;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime arrival;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Airline airline;
}
