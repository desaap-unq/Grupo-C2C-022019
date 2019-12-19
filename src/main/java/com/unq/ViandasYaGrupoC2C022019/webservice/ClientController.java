package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("client")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    ClientService clientService;

    
    @GetMapping("/{id}")
    public Client findById(@PathVariable long id) {
        Client client;
        client = clientService.findById(id);
        return client;
    }
}
