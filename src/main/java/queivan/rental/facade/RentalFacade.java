package queivan.rental.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.rental.domain.RentalDto;
import queivan.rental.service.RentalService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RentalFacade {
    private final RentalService service;

    public RentalDto getRentalById(UUID id){
        return service.getRentalById(id);
    }

    public List<RentalDto> getAllRentals(){
        return service.getAllRentals();
    }

}
