package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.Car;
import queivan.rental.domain.CarDto;
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

    public CarDto getCarById(UUID id){
        Car fetched = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        return mapper.mapCarToCarDto(fetched);
    }

    public List<CarDto> getAllCars(){
        List<Car> fetched = repository.findAll();
        return mapper.mapCarListToCarDtoList(fetched);
    }

}
