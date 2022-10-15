package queivan.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queivan.rental.domain.ClientDto;
import queivan.rental.facade.ClientFacade;

import java.util.List;
import java.util.UUID;

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
}
