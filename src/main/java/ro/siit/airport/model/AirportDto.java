package ro.siit.airport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {

    private Long id;
    private String name;
    private String city;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Boolean active;
}
