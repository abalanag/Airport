package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.siit.airport.domain.Country;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDto {

    private Long id;

    @NotNull
    private String airlineName;

    @NotNull
    private Country country;

    @NotBlank
    private String iata;

    @NotBlank
    private String icao;
}
