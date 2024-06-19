package com.twitter.user_service.services;

import com.twitter.user_service.dto.UserDTO;
import com.twitter.user_service.entities.UserEntity;
import com.twitter.user_service.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
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

        public UserDTO getUserByUsername(String username) {
        UserEntity userEntity = userRepository.getUserByUsername(username);
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        return userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        //log.info(userList.toString());
    }
//
//    public UserDTO updateUser(Long id, UserDTO userDTO) {
//    }
//
//    public void deleteUser(Long id) {
//    }
}
