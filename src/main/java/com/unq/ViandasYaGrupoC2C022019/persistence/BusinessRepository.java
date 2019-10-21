package com.unq.ViandasYaGrupoC2C022019.persistence;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long>{
    
}
