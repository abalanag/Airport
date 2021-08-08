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
public class FlightRequestDto {

    private Airport airport;

    private Airline airline;

    private String flightType;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime endDate;

    public FlightRequestDto(Airport id, String flightType, LocalDateTime startDate, LocalDateTime endDate) {
        this.airport = id;
        this.flightType = flightType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public FlightRequestDto(Airline id, String flightType, LocalDateTime startDate, LocalDateTime endDate) {
        this.airline = id;
        this.flightType = flightType;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}


