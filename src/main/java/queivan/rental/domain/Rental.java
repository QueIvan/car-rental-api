package queivan.rental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "rentals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Rental {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Car car;
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Client client;
    @NotNull
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    @NotNull
    private Float deposit;
}
