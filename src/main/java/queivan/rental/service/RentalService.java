package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.*;
import queivan.rental.domain.enums.LogType;
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
    private final LogService logger;

    public RentalDto getRentalById(UUID id){
        Rental fetched = repository.findById(id).orElseThrow(() -> new RentalNotFoundException(id));
        return mapper.mapRentalToRentalDto(fetched);
    }

    public List<RentalDto> getAllRentals(){
        List<Rental> fetched = repository.findAll();
        return mapper.mapRentalListToRentalDtoList(fetched);
    }

    public RentalDto createRental(RentalDto dto) {
        Rental fetched = repository.save(mapper.mapRentalDtoToRental(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Created rental with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapRentalToRentalDto(fetched);
    }

    public RentalDto updateRental(RentalDto dto) {
        doesRentalExist(dto.getId());
        Rental fetched = repository.save(mapper.mapRentalDtoToRental(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Updated rental with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapRentalToRentalDto(fetched);
    }

    public void deleteRental(UUID id){
        doesRentalExist(id);
        repository.deleteById(id);
        logger.dbLog(LogDto.builder()
                .message(String.format("Deleted rental with id: %s", id))
                .type(LogType.INFO)
                .build());
    }

    private void doesRentalExist(UUID id){
        if(!repository.existsById(id)) {
            logger.dbLog(LogDto.builder()
                    .message(String.format("Rental with id: %s does not exist", id))
                    .type(LogType.ERROR)
                    .build());
            throw new RentalNotFoundException(id);
        }
    }

}
