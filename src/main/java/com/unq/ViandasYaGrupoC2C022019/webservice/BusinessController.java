package com.unq.ViandasYaGrupoC2C022019.webservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;

@RestController
public class BusinessController {

	BusinessService service;
	
	public Business findByBusinessId(@PathVariable long id) {
		Business business = service.findByBusinessId(id);
		return business;
	}
}
