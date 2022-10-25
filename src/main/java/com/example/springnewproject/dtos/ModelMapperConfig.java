package com.example.springnewproject.dtos;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper =  new ModelMapper();

        return  modelMapper;
    }
}
