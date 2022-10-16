package queivan.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.rental.domain.Rental;
import queivan.rental.domain.RentalDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RentalMapper {
    RentalDto mapRentalToRentalDto(Rental fetched);

    List<RentalDto> mapRentalListToRentalDtoList(List<Rental> fetched);

    Rental mapRentalDtoToRental(RentalDto dto);
}
