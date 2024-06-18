package com.twitter.user_service.services;

import com.twitter.user_service.dto.UserDTO;
import com.twitter.user_service.entities.UserEntity;
import com.twitter.user_service.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDTO getUserById(long id) {
        UserEntity userEntity = userRepository.getById(id);
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(modelMapper.map(userDTO, UserEntity.class));
        return modelMapper.map(userEntity, UserDTO.class);
    }

}
