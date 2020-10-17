package com.avinash.urlshortening.model;

import lombok.SneakyThrows;

/**
 * Created by avinash on 17/10/20.
 */
public abstract class AbstractURLRequest implements URLRequest{

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public <S extends URLRequest> S asType(Class<S> clazz) {

        if (clazz.isAssignableFrom(getClass())) return (S)this;

        S clone = clazz.getConstructor().newInstance();
        copyPropertiesTo(clone);

        return clone;
    }

    private <T extends URLRequest> void copyPropertiesTo(T clone) {
        clone.setId(this.getId());
        clone.setLongUrl(this.getLongUrl());
        clone.setExpiresDate(this.getExpiresDate());
        clone.setCreatedDate(this.getCreatedDate());
    }
}

