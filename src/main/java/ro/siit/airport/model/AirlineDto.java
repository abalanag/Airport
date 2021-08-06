package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.siit.airport.domain.Country;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDto {

    private Long id;
    private String airlineName;
    private Country country;
    private String iata;
    private String icao;
}
