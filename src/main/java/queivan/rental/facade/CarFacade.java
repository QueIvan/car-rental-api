package queivan.rental.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.rental.domain.CarDto;
import queivan.rental.service.CarService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CarFacade {
    private final CarService service;

    public CarDto getCarById(UUID id){
        return service.getCarById(id);
    }

    public List<CarDto> getAllCars(){
        return service.getAllCars();
    }

}
