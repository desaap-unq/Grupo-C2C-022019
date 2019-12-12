package com.unq.ViandasYaGrupoC2C022019.persistence;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MenuRepository  extends JpaRepository<Menu, Long>{
     public List<Menu> findByBusinessId(Long idBusiness);
}
