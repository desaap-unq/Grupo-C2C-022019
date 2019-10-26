package com.unq.ViandasYaGrupoC2C022019.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.unq.ViandasYaGrupoC2C022019.model.Business;

@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends JpaRepository<T, ID>{

	Business findById(Long id);
	
//	List<Business> findByMenuId(String food);
}
