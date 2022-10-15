package queivan.rental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Client {
    @Id
    @NotNull
    @GeneratedValue
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private LocalDateTime dateOfBirth;
    @NotNull
    private String documentIdentifier;
    @OneToMany(mappedBy = "client", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Rental> history;
}
