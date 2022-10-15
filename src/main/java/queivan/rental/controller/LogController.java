package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queivan.rental.domain.LogDto;
import queivan.rental.facade.LogFacade;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogFacade facade;

    @GetMapping
    public List<LogDto> getAllLogs(){
        return facade.getAllLogs();
    }
}
