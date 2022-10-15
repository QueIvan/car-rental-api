package queivan.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.rental.domain.Log;
import queivan.rental.domain.LogDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper {
    List<LogDto> mapLogToLogDto(List<Log> fetched);
    Log mapLogDtoToLog(LogDto dto);
}
