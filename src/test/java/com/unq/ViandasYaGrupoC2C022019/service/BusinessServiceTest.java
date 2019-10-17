
package com.unq.ViandasYaGrupoC2C022019.service;

import com.unq.ViandasYaGrupoC2C022019.ApplicationTests;
import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.util.BusinessBuilder;
import com.unq.ViandasYaGrupoC2C022019.util.VirtualWalletBuilder;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BusinessServiceTest extends ApplicationTests {
    
    @Autowired
    private BusinessService businessService;
    
    @Autowired
    EntityManager entityManager;
    
    @Test
    public void createBussines_WithBasicData_ABusinessWithIdNotNull() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business business = BusinessBuilder.aBusiness().withWallet(virtualWallet).build();
        
        businessService.save(business);
        assertNotNull(business.getId());
    }
    
    @Test
    public void findBusinessById_WithBusinessInDataBase_ABusiness() {
        VirtualWallet virtualWallet = VirtualWalletBuilder.aVirtualWallet().buildAndSave(entityManager);
        Business businessSaved = BusinessBuilder.aBusiness().withWallet(virtualWallet).buildAndSave(entityManager);
        
        assertThat(businessService.findBusinessById(businessSaved.getId()).getId());
        
    }
    @Test
    public void findBusinessById_WithoutBusinessInDataBase_aException() {
        
        assertThatIllegalArgumentException()
                .isThrownBy(() -> businessService.findBusinessById(1L))
                .withMessage("Not found Busness with id 1");
    }
}
