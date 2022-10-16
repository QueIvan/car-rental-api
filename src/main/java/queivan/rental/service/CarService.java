package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.Car;
import queivan.rental.domain.CarDto;
import queivan.rental.domain.LogDto;
import queivan.rental.domain.enums.LogType;
import queivan.rental.exceptions.CarNotFoundException;
import queivan.rental.mapper.CarMapper;
import queivan.rental.service.repository.CarRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;
    private final LogService logger;

    public CarDto getCarById(UUID id){
        Car fetched = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        logger.dbLog(LogDto.builder()
                        .message(String.format("Fetched car with id: %s", id))
                        .type(LogType.INFO)
                        .build());
        return mapper.mapCarToCarDto(fetched);
    }

    public List<CarDto> getAllCars(){
        List<Car> fetched = repository.findAll();
        logger.dbLog(LogDto.builder()
                .message("Fetched all cars")
                .type(LogType.INFO)
                .build());
        return mapper.mapCarListToCarDtoList(fetched);
    }

    public CarDto createCar(CarDto dto) {
        Car fetched = repository.save(mapper.mapCarDtoToCar(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Created car with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapCarToCarDto(fetched);
    }

    public CarDto updateCar(CarDto dto) {
        doesCarExist(dto.getId());
        Car fetched = repository.save(mapper.mapCarDtoToCar(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Updated car with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapCarToCarDto(fetched);
    }

    public void deleteCar(UUID id){
        doesCarExist(id);
        repository.deleteById(id);
        logger.dbLog(LogDto.builder()
                .message(String.format("Deleted car with id: %s", id))
                .type(LogType.INFO)
                .build());
    }

    private void doesCarExist(UUID id){
        if(!repository.existsById(id)) {
            logger.dbLog(LogDto.builder()
                    .message(String.format("Car with id: %s does not exist", id))
                    .type(LogType.ERROR)
                    .build());
            throw new CarNotFoundException(id);
        }
    }

}
