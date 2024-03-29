package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.dto.BusinessDto;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.persistence.BusinessRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.VirtualWalletRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BusinessService {
    @Autowired
    private final BusinessRepository businessRepository;
    
    @Autowired
    private final VirtualWalletRepository vwRepository;

    public BusinessService(BusinessRepository businessRepository,
    					   VirtualWalletRepository vwRepository) {
        this.businessRepository = businessRepository;
        this.vwRepository = vwRepository;
    }

    public Business save(Business aBusiness) {
        return this.businessRepository.save(aBusiness);
    }
    
    public Business findBusinessById(Long businessId) {
        Assert.isTrue(businessRepository.existsById(businessId), ("Not found Busness with id ".concat(businessId.toString())));
        return this.businessRepository.findById(businessId).get();
    }

    public List<BusinessDto> findByCategory(String menuCategory) {
       Arrays.asList(MenuCategory.values()).stream().map(category -> category.toString()).collect(Collectors.toList()).contains(menuCategory.toUpperCase());
       Assert.isTrue(Arrays.asList(MenuCategory.values()).stream().map(category -> category.toString()).collect(Collectors.toList()).contains(menuCategory.toUpperCase())
       , ("Not found food with name ".concat(menuCategory)));

        return this.businessRepository.findByMenuCategory(MenuCategory.valueOf(menuCategory.toUpperCase()));
    }

	public Business saveFromBusinessDto(BusinessDto business) {
		
		//validate business
		Business web = new Business(business);
		VirtualWallet vw = web.getWallet();
		
		this.getVwRepository().save(vw);
		
		return this.save(web);
	}

	public VirtualWalletRepository getVwRepository() {
		return vwRepository;
	}
}