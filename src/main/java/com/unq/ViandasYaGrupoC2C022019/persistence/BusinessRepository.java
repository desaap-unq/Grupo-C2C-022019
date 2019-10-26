package com.unq.ViandasYaGrupoC2C022019.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {

	//Business findById(Long idBusiness);

	@Query("select m.business.id from Menu m join m.category c where c = :food")
	List<Integer> findByMenuId(@Param("food") MenuCategory food);	
}