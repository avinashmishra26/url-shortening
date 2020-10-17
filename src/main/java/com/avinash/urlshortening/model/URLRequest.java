/**
 * Created by avinash on 17/10/20.
 */
package com.avinash.urlshortening.model;

import java.util.Date;


public interface URLRequest {
    long getId();

    void setId(long id);

    String getLongUrl();

    void setLongUrl(String longUrl);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Date getExpiresDate();

    void setExpiresDate(Date expiresDate);

    <S extends URLRequest> S asType(Class<S> clazz);

}
