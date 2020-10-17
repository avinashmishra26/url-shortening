package com.avinash.urlshortening.entity

import com.avinash.urlshortening.model.AbstractURLRequest
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString;

import javax.persistence.*

@Entity(name='url')
@ToString
@EqualsAndHashCode
public class UrlEntity extends AbstractURLRequest {

    @Version
    Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Date expiresDate;

}
