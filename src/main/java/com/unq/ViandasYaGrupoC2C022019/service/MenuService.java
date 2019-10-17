package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.persistence.MenuRepository;
import java.util.List;
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

    public void update(Menu menu) {
        this.menuRepository.save(menu);
    }
    
    public List<Menu> findByBusinessId(Long idBusiness){
        return menuRepository.findByBusinessId(idBusiness);
    }
   
}
