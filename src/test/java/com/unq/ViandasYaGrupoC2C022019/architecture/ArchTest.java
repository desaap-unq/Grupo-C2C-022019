package com.unq.ViandasYaGrupoC2C022019.architecture;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchTest {

	@Test
	public void services_should_only_be_accessed_by_webservice() {
		JavaClasses importClasses = new ClassFileImporter()
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
									    .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
										.importPackages("com.unq.ViandasYaGrupoC2C022019");
		
		ArchRule rule = classes()
							.that().resideInAPackage("..service..")
							.should().onlyBeAccessed().byAnyPackage("..webservice..", "..service..");
		
		rule.check(importClasses);
	}
	
	@Test
	public void domain_should_only_be_accessed_by_util_service() {
		JavaClasses importClasses = new ClassFileImporter()
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
										.importPackages("com.unq.ViandasYaGrupoC2C022019");
		
		ArchRule rule = classes()
						    .that().resideInAPackage("..model..")
						    .should().onlyBeAccessed().byAnyPackage("..model..", "..util..", "..service..");
		
		rule.check(importClasses);
	}
	
	@Test
	public void should_be_annotation_in_a_pck_service() {
		JavaClasses importClasses = new ClassFileImporter()
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
										.importPackages("com.unq.ViandasYaGrupoC2C022019");
		
		ArchRule rule = classes()
							.that().areAnnotatedWith((Class<? extends Annotation>) Service.class)
							.or().haveNameMatching(".*Service")
							.should().resideInAPackage("..service..");
		
		rule.check(importClasses);
	}
	
	@Test
	public void should_be_accessed_service() {
		JavaClasses importClasses = new ClassFileImporter()
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
										.importPackages("com.unq.ViandasYaGrupoC2C022019");
		
		ArchRule rule = classes()
							.that().areAssignableTo(EntityManager.class)
							.should().onlyBeAccessed().byAnyPackage("..service..");
		
		rule.check(importClasses);
	}
	
	@Test
	public void should_be_accessed_annotation_by_transactional() {
		JavaClasses importClasses = new ClassFileImporter()
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
										.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
										.importPackages("com.unq.ViandasYaGrupoC2C022019");
		
		ArchRule rule = classes()
							.that().areAssignableTo(EntityManager.class)
							.should().onlyBeAccessed().byClassesThat().areAnnotatedWith((Class<? extends Annotation>) Transaction.class);
		
		rule.check(importClasses);
	}
	
}
