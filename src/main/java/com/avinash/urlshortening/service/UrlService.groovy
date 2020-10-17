package com.avinash.urlshortening.service;

import com.avinash.urlshortening.model.HypermediaUrlLongRequest;
import com.avinash.urlshortening.entity.UrlEntity;
import com.avinash.urlshortening.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private BaseConversion conversion;


    public String convertToShortUrl(HypermediaUrlLongRequest request) {
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setLongUrl(request.getLongUrl());
        urlEntity.setExpiresDate(request.getExpiresDate());
        urlEntity.setCreatedDate(new Date());
        UrlEntity entity = urlRepository.save(urlEntity);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        long id = conversion.decode(shortUrl);
        UrlEntity entity = urlRepository.findById(id)

        if (entity.getExpiresDate() != null && entity.getExpiresDate().before(new Date())){
            urlRepository.delete(entity);
            throw new EntityNotFoundException("Link expired!");
        }

        return entity.getLongUrl();
    }
}
