package com.unq.ViandasYaGrupoC2C022019.persistence;

import com.unq.ViandasYaGrupoC2C022019.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
