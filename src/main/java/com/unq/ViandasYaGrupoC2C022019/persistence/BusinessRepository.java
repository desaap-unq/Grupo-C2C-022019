package com.unq.ViandasYaGrupoC2C022019.persistence;

import com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessRepository extends JpaRepository<Business, Long>{
	String properties = "m.business.name, m.business.logo, m.business.locality, m.business.address, m.business.phone, m.business.days, m.business.description, m.business.link";
	String businessDto = "select distinct new com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto("+properties+")";
    														// c.value like 
    @Query(businessDto +" "+ "from Menu m right join m.category c on c = :food")
	List<BusinessDto> findByMenuCategory(@Param("food") MenuCategory food);
}