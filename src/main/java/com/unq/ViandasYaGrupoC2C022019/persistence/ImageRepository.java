package com.unq.ViandasYaGrupoC2C022019.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unq.ViandasYaGrupoC2C022019.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{

	ImageModel findByName(String idImage);

}
