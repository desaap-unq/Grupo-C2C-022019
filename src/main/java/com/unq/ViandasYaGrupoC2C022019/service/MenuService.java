package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.persistence.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu save(Menu aMenu) {
        return this.menuRepository.save(aMenu);
    }
   
    public void delete(Menu aMenu){
        this.menuRepository.delete(aMenu);
    }
   
}
