package queivan.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private UUID id;
    private String brand;
    private String model;
    private Integer productionYear;
    private Float mileage;
    private List<RentalCarDto> history;
}
