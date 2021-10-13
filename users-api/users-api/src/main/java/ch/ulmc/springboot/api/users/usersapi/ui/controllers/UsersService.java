package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserEntity createUser(@Valid CreateUserRequest userData) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userData, UserEntity.class);
        userEntity.setEncryptedPassword("hardcoded_password");
        userEntity.setUserId(UUID.randomUUID().toString());
        usersRepository.save(userEntity);
        return userEntity;
    }
}
