package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestModel {
    private String email;
    private String password;
}
