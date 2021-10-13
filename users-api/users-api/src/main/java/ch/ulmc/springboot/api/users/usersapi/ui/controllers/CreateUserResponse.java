package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class CreateUserResponse {
    @NotNull
    @Size(min=2)
    private final String firstName;
    @NotNull
    @Size(min=2)
    private final String lastName;
    @NotNull
    @Size(min = 8, max = 25)
    private final String password;
    @NotNull
    @Email
    private final String email;
}
