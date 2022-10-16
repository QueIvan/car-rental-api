package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.rental.domain.ClientDto;
import queivan.rental.facade.ClientFacade;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientFacade facade;

    @GetMapping("/{clientId}")
    public ClientDto getClientById(@PathVariable("clientId") UUID id){
        return facade.getClientById(id);
    }

    @GetMapping
    public List<ClientDto> getAllClients(){
        return facade.getAllClients();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ClientDto createClient(@RequestBody ClientDto dto){
        return facade.createClient(dto);
    }
    @PutMapping (consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ClientDto updateClient(@RequestBody ClientDto dto){
        return facade.updateClient(dto);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteClient(@PathVariable UUID id){
        facade.deleteClient(id);
    }
}
