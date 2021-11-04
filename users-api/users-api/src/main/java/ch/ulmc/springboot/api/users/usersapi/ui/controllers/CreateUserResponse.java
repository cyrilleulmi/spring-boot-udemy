package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateUserResponse {
    @NotNull
    @Size(min=2)
    private String firstName;
    @NotNull
    @Size(min=2)
    private String lastName;
    @NotNull
    @Email
    private String email;
}
