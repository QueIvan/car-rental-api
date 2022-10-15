package queivan.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import queivan.rental.domain.enums.LogType;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDto {
    private LogType type;
    private String message;
    private LocalDateTime createdAt;
}
