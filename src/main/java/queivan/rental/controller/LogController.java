package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.rental.domain.LogDto;
import queivan.rental.facade.LogFacade;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogFacade facade;

    @GetMapping
    public List<LogDto> getAllLogs(){
        return facade.getAllLogs();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LogDto createLog(@RequestBody LogDto dto){
        return facade.createLog(dto);
    }
}
