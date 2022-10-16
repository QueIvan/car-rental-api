package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.rental.domain.RentalDto;
import queivan.rental.facade.RentalFacade;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalFacade facade;

    @GetMapping("/{rentalId}")
    public RentalDto getRentalById(@PathVariable("rentalId") UUID id){
        return facade.getRentalById(id);
    }

    @GetMapping
    public List<RentalDto> getAllRentals(){
        return facade.getAllRentals();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentalDto createRental(@RequestBody RentalDto dto){
        return facade.createRental(dto);
    }
    @PutMapping (consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentalDto updateRental(@RequestBody RentalDto dto){
        return facade.updateRental(dto);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteRental(@PathVariable UUID id){
        facade.deleteRental(id);
    }
}
