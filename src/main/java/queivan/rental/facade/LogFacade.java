package queivan.rental.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.rental.domain.LogDto;
import queivan.rental.service.LogService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogFacade {
    private final LogService service;

    public List<LogDto> getAllLogs(){
        return service.getAllLogs();
    }
}
