package queivan.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalDto {
    private UUID id;
    private CarRentalDto car;
    private ClientRentalDto client;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private Float deposit;
}
