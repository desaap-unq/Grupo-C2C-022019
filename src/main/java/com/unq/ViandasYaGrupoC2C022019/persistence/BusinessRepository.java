package com.unq.ViandasYaGrupoC2C022019.persistence;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessRepository extends JpaRepository<Business, Long>{
    
    @Query("select distinct m.business from Menu m join m.category c where c = :food")
	List<Business> findByMenuCategory(@Param("food") MenuCategory food);
}