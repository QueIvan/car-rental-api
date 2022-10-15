package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.Rental;
import queivan.rental.domain.RentalDto;
import queivan.rental.exceptions.RentalNotFoundException;
import queivan.rental.mapper.RentalMapper;
import queivan.rental.service.repository.RentalRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository repository;
    private final RentalMapper mapper;

    public RentalDto getRentalById(UUID id){
        Rental fetched = repository.findById(id).orElseThrow(() -> new RentalNotFoundException(id));
        return mapper.mapRentalToRentalDto(fetched);
    }

    public List<RentalDto> getAllRentals(){
        List<Rental> fetched = repository.findAll();
        return mapper.mapRentalListToRentalDtoList(fetched);
    }

}
