package com.unq.ViandasYaGrupoC2C022019.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;

@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	BusinessService service;
	
	@GetMapping("/business/{id}")
	public Business findByBusinessId(@PathVariable long id) {
		Business business = service.findByBusinessId(id);
		return business;
	}
	
	@GetMapping("/business/{comida}")
	public List<Business> findByBussinessName(@PathVariable String comida) {
		List<Business> business = service.findByCategory(comida);
		return null;
	}
}
