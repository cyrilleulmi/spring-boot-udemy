package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UsersController {

    UsersService usersService;
    
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + env.getProperty("local.server.port");
    }
    
    @PostMapping
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest userData) {  
        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = this.usersService.createUser(userData);
        CreateUserResponse response = modelMapper.map(entity, CreateUserResponse.class);
        return response;
    }
}
