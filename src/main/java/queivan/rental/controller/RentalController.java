package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queivan.rental.domain.RentalDto;
import queivan.rental.facade.RentalFacade;

import java.util.List;
import java.util.UUID;

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
}
