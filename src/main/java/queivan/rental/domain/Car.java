package queivan.rental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Car {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private Integer productionYear;
    @NotNull
    private Float mileage;
    @OneToMany(mappedBy = "car", cascade = CascadeType.MERGE)
    private List<Rental> history;
}
