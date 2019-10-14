package com.unq.ViandasYaGrupoC2C022019.util;

import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import javax.persistence.EntityManager;

public class VirtualWalletBuilder extends AbstractPersistenceBuilder<VirtualWallet> {

    private double balance;

    public static VirtualWalletBuilder aVirtualWallet() {
        return new VirtualWalletBuilder();
    }

    public VirtualWalletBuilder withBalance(double balanze) {
        this.balance = balanze;
        return this;
    }
    
    public VirtualWallet build(){
         VirtualWallet virtualWallet = new VirtualWallet();
         virtualWallet.setBalance(balance);
         return virtualWallet;
    }
    
    public VirtualWallet buildAndSave(EntityManager entityManager){
        this.instance = this.build();
        return super.build(entityManager);
    }
}
