package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import java.util.ArrayList;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {
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

    public UserEntity getUserByEmail(String email) {
        UserEntity userEntity = this.usersRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByEmail(username);
        if (userEntity == null) throw new UsernameNotFoundException(username);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}
