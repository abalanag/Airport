package ro.siit.airport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "airports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @Column
    private Boolean active;
}
