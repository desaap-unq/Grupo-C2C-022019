package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("business")
@CrossOrigin(origins = "http://localhost:3000")
public class BusinessController {
    
    @Autowired 
    BusinessService businessService;
    
    @GetMapping("/{id}")
    public Business findBusinessById(@PathVariable long id){
        System.err.println("no hay negocios en la bd por eso no tira error");
        Business business = businessService.findBusinessById(id);
        return business;
    } 
}
