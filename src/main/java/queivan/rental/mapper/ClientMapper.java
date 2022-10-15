package queivan.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import queivan.rental.domain.Client;
import queivan.rental.domain.ClientDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientDto mapClientToClientDto(Client fetched);
    List<ClientDto> mapClientListToClientListDto(List<Client> fetched);
}
