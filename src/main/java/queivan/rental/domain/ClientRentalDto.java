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
public class ClientRentalDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime dateOfBirth;
    private String documentIdentifier;
}
