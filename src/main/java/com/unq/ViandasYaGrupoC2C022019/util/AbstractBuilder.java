/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.unq.ViandasYaGrupoC2C022019.util;

/**
 * An abstract class that creates simple Builders. It provides an instance of the
 * object that is being created, and a simple implementation for build().
 * @param <T> the type of object that this Builder will create.
 */
public abstract class AbstractBuilder<T> implements Builder<T> {
    
    protected T instance;
    
    @Override
    public T build() {
        return instance;
    }

}
