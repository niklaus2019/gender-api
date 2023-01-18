package com.example.genderapi.service;

import com.example.genderapi.dto.GenderDto;
import com.example.genderapi.exception.ExternalApiException;
import com.example.genderapi.repository.GenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalGenderService {
    private String url = "https://api.genderize.io/?name=";
    private RestTemplate restTemplate;
    private GenderRepository genderRepository;
    private final Logger logger = LoggerFactory.getLogger(ExternalGenderService.class);

    public ExternalGenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GenderDto getGenderData(String name) {
        logger.debug("Start doing external call");
        String externalUrl = url + name;
        ResponseEntity<GenderDto> forEntity = restTemplate.getForEntity(externalUrl, GenderDto.class);
        if(forEntity.getStatusCode().is4xxClientError()) {
            logger.error("Data from external system not available for {} with {}", name, forEntity.getStatusCode());
            throw new ExternalApiException("Data from external system not available");
        }
        logger.info("External call for {} was completed", name);
        return forEntity.getBody();
    }
}
