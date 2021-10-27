package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    UsersRepository usersRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(@Valid CreateUserRequest userData) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userData, UserEntity.class);
        userEntity.setEncryptedPassword(passwordEncoder.encode(userData.getPassword()));
        userEntity.setUserId(UUID.randomUUID().toString());
        usersRepository.save(userEntity);
        return userEntity;
    }
}
