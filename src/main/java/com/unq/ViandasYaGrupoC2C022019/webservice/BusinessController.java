package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.aspects.LogExecutionServiceAndRepository;
import com.unq.ViandasYaGrupoC2C022019.aspects.LogExecutionTime;
import com.unq.ViandasYaGrupoC2C022019.aspects.LogExecutionTimeAspectAnnotation;
import com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("business")
@CrossOrigin(origins = "http://localhost:3000")
@EnableAutoConfiguration
public class BusinessController {
	
	static Logger logger = LoggerFactory.getLogger(LogExecutionServiceAndRepository.class);

    @Autowired
    BusinessService businessService;

    @LogExecutionTime
    @GetMapping("/{id}")
    public Business findBusinessById(@PathVariable long id) {
        Business business = businessService.findBusinessById(id);
        logger.info("/////// Inside findBusinessById() method");
        return business;
    }

    @GetMapping("/search/{food}")
    public List<BusinessDto> findByBussinessName(@PathVariable String food) {
    	logger.info("/////// Inside findBusinessName() method");
        return businessService.findByCategory(food);
    }
    
    @PostMapping(value = "/add", consumes = "application/json")
    public Business createBusiness(@RequestBody BusinessDto business) {
		return businessService.saveFromBusinessDto(business);
    }
}
