/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.unq.ViandasYaGrupoC2C022019.util;

import javax.persistence.EntityManager;

/**
 * An abstract class that creates simple Builders. 
 * It provides a method to persist the created object.
 * @param <T> the type of object that this Builder will create.
 */
public abstract class AbstractPersistenceBuilder<T> extends AbstractBuilder<T> {
    
    /**
     * Builds the object and persists it using the provided EntityManager.
     * @param em an EntityManager to persist the object.
     * @return the persisted object, detached.
     */
    public T build(EntityManager em) {
        em.persist(instance);
        em.flush();
        em.detach(instance);
        return instance;
    }

}
