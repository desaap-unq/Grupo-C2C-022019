package com.unq.ViandasYaGrupoC2C022019.webservice;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.service.BusinessService;
import com.unq.ViandasYaGrupoC2C022019.service.MenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MenuController {

    @Autowired
    MenuService menuService;
    
    @Autowired
    BusinessService businessService;

    @GetMapping("/business/{id}")
    public List<Menu> findByBusinessId(@PathVariable long id) {
        List<Menu> menus = menuService.findByBusinessId(id);
        return menus;
    }
    
    @PostMapping("/business/{id}")
    public Menu createMenu(@RequestBody Menu menu, @PathVariable long id) {
        Business business = businessService.findBusinessById(id);
        menuService.setMenu2Business(menu, business);
        return menuService.save(menu);
    }
    
}
