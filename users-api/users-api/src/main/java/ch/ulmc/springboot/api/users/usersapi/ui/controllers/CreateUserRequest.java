package ch.ulmc.springboot.api.users.usersapi.ui.controllers;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull
    @Size(min=2)
    private String firstName;
    @NotNull
    @Size(min=2)
    private String lastName;
    @NotNull
    @Size(min = 8, max = 25)
    private String password;
    @NotNull
    @Email
    private String email;
}
