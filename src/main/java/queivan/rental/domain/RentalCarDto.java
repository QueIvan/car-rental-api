package queivan.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalCarDto {
    private ClientRentalDto client;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private Float deposit;
}
