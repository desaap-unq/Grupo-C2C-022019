package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class ClientService {
     @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        return this.clientRepository.findById(id).get();
    }

  
}
