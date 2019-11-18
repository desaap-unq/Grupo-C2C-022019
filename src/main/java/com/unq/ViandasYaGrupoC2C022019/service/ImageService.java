package com.unq.ViandasYaGrupoC2C022019.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.unq.ViandasYaGrupoC2C022019.model.ImageModel;
import com.unq.ViandasYaGrupoC2C022019.model.exception.FileStorageException;
import com.unq.ViandasYaGrupoC2C022019.persistence.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository irepository;

	public ImageService(ImageRepository irepository) {
		this.irepository = irepository;
	}
	
//	public ImageModel save(MultipartFile file) { version online
//		String filename = StringUtils.cleanPath(file.getOriginalFilename());
//		try {
//			if(filename.contains("..")) {
//				throw new FileStorageException(filename);
//			}
//			
//			ImageModel image = new ImageModel(filename, file.getContentType(), file.getBytes());
//			
//			return this.irepository.save(image);
//		} catch (IOException e) {
//			//"Could not store file " + fileName + ". Please try again!", ex
//			throw new FileStorageException(filename);
//		}
//	}
	
	public ImageModel findByName(String idImage) {
		return this.irepository.findByName(idImage);
	}
}
