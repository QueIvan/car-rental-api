package queivan.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.rental.domain.Car;
import queivan.rental.domain.CarDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {
    CarDto mapCarToCarDto(Car fetched);
    List<CarDto> mapCarListToCarDtoList(List<Car> fetched);
    Car mapCarDtoToCar(CarDto dto);
}
