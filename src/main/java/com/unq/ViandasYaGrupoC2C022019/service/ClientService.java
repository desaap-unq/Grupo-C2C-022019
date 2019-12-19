package com.unq.ViandasYaGrupoC2C022019.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        return this.clientRepository.findById(id).get();
    }
}
