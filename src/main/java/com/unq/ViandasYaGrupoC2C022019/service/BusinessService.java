package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.persistence.BusinessRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BusinessService {
    @Autowired
    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business save(Business aBusiness) {
        return this.businessRepository.save(aBusiness);
    }
    
    public Business findBusinessById(Long businessId) {
        Assert.isTrue(businessRepository.existsById(businessId), ("Not found Busness with id ".concat(businessId.toString())));
        return this.businessRepository.findById(businessId).get();
    }

    public List<Business> findByCategory(MenuCategory menuCategory) {
        return this.businessRepository.findByMenuCategory(menuCategory);
    }
}
