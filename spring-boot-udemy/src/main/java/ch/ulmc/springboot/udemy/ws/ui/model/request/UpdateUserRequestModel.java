package ch.ulmc.springboot.udemy.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserRequestModel {
    @NotNull(message="First name cannot be null")
    private String firstName;
    @NotNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
