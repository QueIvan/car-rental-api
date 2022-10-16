package queivan.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.rental.domain.Log;
import queivan.rental.domain.LogDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper {
    Log mapLogDtoToLog(LogDto dto);
    List<LogDto> mapLogListToLogDtoList(List<Log> fetched);
    LogDto mapLogToLogDto(Log fetched);
}
