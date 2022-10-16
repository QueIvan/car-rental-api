package queivan.rental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import queivan.rental.domain.enums.LogType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "logs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Log {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private LogType type;
    @NotNull
    private String message;
    private LocalDateTime createdAt;
}
