/**
 * Created by avinash on 17/10/20.
 */

package com.avinash.urlshortening.web;

import com.avinash.urlshortening.model.HypermediaUrlLongRequest;
import com.avinash.urlshortening.service.UrlService;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/url/actions")
@Slf4j
public class UrlShorteningController {

    @Autowired
    private UrlService urlService;

    @ApiOperation(value = "Convert Long URL", notes = "Converts long url to short url")
    @RequestMapping(value = "shortenUrl", method = RequestMethod.POST)
    public ResponseEntity createShortUrl(@RequestBody HypermediaUrlLongRequest request) {
        log.debug("Starting createShortUrl.");
        return new ResponseEntity(urlService.convertToShortUrl(request), HttpStatus.OK);
    }

    @ApiOperation(value = "Redirect", notes = "Finds original url from short url and redirects")
    @RequestMapping(value = "{shortUrl}", method = RequestMethod.GET)
    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<Void> retriveOriginalURL(@PathVariable String shortUrl) {
        log.debug("Starting retriveOriginalURL");
        String url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }
}
