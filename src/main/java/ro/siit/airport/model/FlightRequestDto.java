package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.airport.domain.Airport;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequestDto {

    private Airport id;

    private String flightType;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime endDate;
}
