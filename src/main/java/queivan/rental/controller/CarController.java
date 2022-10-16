package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.rental.domain.CarDto;
import queivan.rental.facade.CarFacade;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarFacade facade;

    @GetMapping(value = "/{carId}", produces = APPLICATION_JSON_VALUE)
    public CarDto getCarById(@PathVariable("carId") UUID id){
        return facade.getCarById(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CarDto> getAllCars(){
        return facade.getAllCars();
    }

    @PostMapping (consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CarDto createCar(@RequestBody CarDto dto){
        return facade.createCar(dto);
    }
    @PutMapping (consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CarDto updateCar(@RequestBody CarDto dto){
        return facade.updateCar(dto);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteCar(@PathVariable UUID id){
        facade.deleteCar(id);
    }

}
