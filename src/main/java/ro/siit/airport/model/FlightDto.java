package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long id;
    private String flightNumber;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime departure;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime arrival;
    private String departureAirport;
    private String arrivalAirport;
    private String airline;
}
