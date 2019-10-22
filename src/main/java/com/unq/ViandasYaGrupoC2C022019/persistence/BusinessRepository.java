package com.unq.ViandasYaGrupoC2C022019.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unq.ViandasYaGrupoC2C022019.model.Business;

public interface BusinessRepository extends MyBaseRepository<Business, Long> {

	Business findById(Long idBusiness);

	@Query("select m.business from Menu m where :food in category(m.category)")
	List<Business> findByMenuId(@Param("food") String food);	
}