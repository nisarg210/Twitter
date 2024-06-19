package com.twitter.user_service.configuration;

import com.twitter.user_service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

//    @Bean
//    public UserService userService() {
//        return new UserService();
//    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
