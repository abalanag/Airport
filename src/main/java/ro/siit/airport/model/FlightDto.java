package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.airport.domain.Airline;
import ro.siit.airport.domain.Airport;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Long id;

    @NotBlank
    private String flightNumber;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime departure;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime arrival;

    private Airport departureAirport;

    private Airport arrivalAirport;

    private Airline airline;
}
