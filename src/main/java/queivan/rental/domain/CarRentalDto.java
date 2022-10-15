package queivan.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarRentalDto {
    private String brand;
    private String model;
    private Integer productionYear;
    private Float mileage;
}
