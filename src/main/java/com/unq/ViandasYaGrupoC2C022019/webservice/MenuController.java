package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.aspects.LogExecutionTimeAspectCustomPointcut;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;
import com.unq.ViandasYaGrupoC2C022019.service.MenuService;
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
@RequestMapping("menu")
@CrossOrigin(origins = "http://localhost:3000")
@EnableAutoConfiguration
public class MenuController {

	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectCustomPointcut.class);
	
    @Autowired
    MenuService menuService;
    
    @Autowired
    BusinessService businessService;

    @GetMapping("/business/{id}")
    public List<Menu> findByBusinessId(@PathVariable long id) {
        List<Menu> menus = menuService.findByBusinessId(id);
        logger.info("/////// Inside method2() method");
        return menus;
    }
    
    @PostMapping("/business/{id}")
    public Menu createMenu(@RequestBody Menu menu, @PathVariable long id) {
        Business business = businessService.findBusinessById(id);
        menu.setBusiness(business);
        return menuService.save(menu);
    }
    
}
