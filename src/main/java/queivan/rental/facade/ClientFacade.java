package queivan.rental.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.rental.domain.ClientDto;
import queivan.rental.service.ClientService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientFacade {
    private final ClientService service;

    public ClientDto getClientById(UUID id){
        return service.getClientById(id);
    }

    public List<ClientDto> getAllClients(){
        return service.getAllClients();
    }

    public ClientDto createClient(ClientDto dto){
        return service.createClient(dto);
    }
    public ClientDto updateClient(ClientDto dto){
        return service.updateClient(dto);
    }

    public void deleteClient(UUID id){
        service.deleteClient(id);
    }
}
