package com.avinash.urlshortening;

import groovy.util.logging.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = "com.avinash.urlshortening.*")
@EnableCaching
public class UrlShorteningApplication {

	public static void main(String[] args) {
		log.info("UrlEntity Shortening Application Service starting...");
		SpringApplication.run(UrlShorteningApplication.class, args);
	}

}
