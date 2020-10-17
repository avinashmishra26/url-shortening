package com.avinash.urlshortening.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import groovy.transform.ToString;
import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HypermediaUrlLongRequest extends AbstractURLRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String longUrl;

    @Getter
    @Setter
    private Date expiresDate;

    @CreatedDate
    @Column
    Date createdDate;

}
