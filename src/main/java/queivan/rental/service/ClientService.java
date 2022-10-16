package queivan.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import queivan.rental.domain.*;
import queivan.rental.domain.enums.LogType;
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
    private final LogService logger;

    public ClientDto getClientById(UUID id){
        Client fetched = repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        return mapper.mapClientToClientDto(fetched);
    }

    public List<ClientDto> getAllClients(){
        List<Client> fetched = repository.findAll();
        return mapper.mapClientListToClientListDto(fetched);
    }

    public ClientDto createClient(ClientDto dto) {
        Client fetched = repository.save(mapper.mapClientDtoToClient(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Created client with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapClientToClientDto(fetched);
    }

    public ClientDto updateClient(ClientDto dto) {
        doesClientExist(dto.getId());
        Client fetched = repository.save(mapper.mapClientDtoToClient(dto));
        logger.dbLog(LogDto.builder()
                .message(String.format("Updated client with id: %s", fetched.getId()))
                .type(LogType.INFO)
                .build());
        return mapper.mapClientToClientDto(fetched);
    }

    public void deleteClient(UUID id){
        doesClientExist(id);
        repository.deleteById(id);
        logger.dbLog(LogDto.builder()
                .message(String.format("Deleted client with id: %s", id))
                .type(LogType.INFO)
                .build());
    }

    private void doesClientExist(UUID id){
        if(!repository.existsById(id)) {
            logger.dbLog(LogDto.builder()
                    .message(String.format("Client with id: %s does not exist", id))
                    .type(LogType.ERROR)
                    .build());
            throw new ClientNotFoundException(id);
        }
    }

}
