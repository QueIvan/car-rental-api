package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import queivan.rental.domain.Log;
import queivan.rental.domain.LogDto;
import queivan.rental.domain.enums.LogType;
import queivan.rental.mapper.LogMapper;
import queivan.rental.service.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogService {
    private final LogRepository repository;
    private final LogMapper mapper;

    public List<LogDto> getAllLogs(){
        List<Log> fetched = repository.findAll();
        return mapper.mapLogListToLogDtoList(fetched);
    }

    public LogDto createLog(LogDto dto) {
        Log fetched = repository.save(mapper.mapLogDtoToLog(dto));
        dbLog(LogDto.builder()
                .message(String.format("Created Log with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapLogToLogDto(fetched);
    }

    public void dbLog(@NotNull LogDto dto){
        dto.setCreatedAt(LocalDateTime.now());
        repository.save(mapper.mapLogDtoToLog(dto));
        if(dto.getType().equals(LogType.INFO)) log.info(dto.getMessage());
        else if(dto.getType().equals(LogType.ERROR)) log.error(dto.getMessage());
        else log.debug(dto.getMessage());
    }

}
