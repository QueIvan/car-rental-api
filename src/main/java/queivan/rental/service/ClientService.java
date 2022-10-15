package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.Client;
import queivan.rental.domain.ClientDto;
import queivan.rental.exceptions.ClientNotFoundException;
import queivan.rental.mapper.ClientMapper;
import queivan.rental.service.repository.ClientRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientDto getClientById(UUID id){
        Client fetched = repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        return mapper.mapClientToClientDto(fetched);
    }

    public List<ClientDto> getAllClients(){
        List<Client> fetched = repository.findAll();
        return mapper.mapClientListToClientListDto(fetched);
    }

}
