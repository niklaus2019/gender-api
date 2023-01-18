package com.example.genderapi.service;

import com.example.genderapi.dto.GenderDto;
import com.example.genderapi.entity.GenderEntity;
import com.example.genderapi.repository.GenderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainGenderService {
    private ExternalGenderService externalGenderService;
    private GenderRepository genderRepository;
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(MainGenderService.class);

    public MainGenderService(ExternalGenderService externalGenderService, GenderRepository genderRepository, ModelMapper modelMapper) {
        this.externalGenderService = externalGenderService;
        this.genderRepository = genderRepository;
        this.modelMapper = modelMapper;

    }
    @Transactional
    public GenderDto getGenderData(String name) {
        logger.debug("Start do findGenderEntityByName call");
        Optional<GenderEntity> genderEntityByName = genderRepository.findGenderEntityByName(name);
        logger.info("Fetch data from db for name {}; result {}", name, genderEntityByName.isEmpty());
        if(genderEntityByName.isEmpty()) {
            GenderDto genderData = externalGenderService.getGenderData(name);
            GenderEntity genderEntity = modelMapper.map(genderData, GenderEntity.class);
            GenderEntity saved = genderRepository.save(genderEntity);
            logger.info("Saved to db for name {}; result id {}", name, saved.getId());
            return modelMapper.map(saved, GenderDto.class);//GenderDto.from(saved);
        }
        logger.info("Get cashed data from db to client with name {} and id {}", name, genderEntityByName.get().getId());
        return modelMapper.map(genderEntityByName.get(), GenderDto.class);
    }
}
