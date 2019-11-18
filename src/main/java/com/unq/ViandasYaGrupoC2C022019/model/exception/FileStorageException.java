package com.unq.ViandasYaGrupoC2C022019.model.exception;

public class FileStorageException extends RuntimeException {

	private String filename;

	public FileStorageException(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String getMessage() {
		return "Sorry! Filename contains invalid path sequence ["+ this.filename +"]";
	}
}
