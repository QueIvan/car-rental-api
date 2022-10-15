package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queivan.rental.domain.CarDto;
import queivan.rental.facade.CarFacade;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarFacade facade;

    @GetMapping("/{carId}")
    public CarDto getCarById(@PathVariable("carId") UUID id){
        return facade.getCarById(id);
    }

    @GetMapping
    public List<CarDto> getAllCars(){
        return facade.getAllCars();
    }

}
