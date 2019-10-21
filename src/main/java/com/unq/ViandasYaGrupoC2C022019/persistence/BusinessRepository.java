package com.unq.ViandasYaGrupoC2C022019.persistence;

import com.unq.ViandasYaGrupoC2C022019.model.Business;

public interface BusinessRepository extends MyBaseRepository<Business, Long> {

	Business findById(Long idBusiness);	
}