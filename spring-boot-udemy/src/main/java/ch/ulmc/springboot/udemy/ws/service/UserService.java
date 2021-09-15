package ch.ulmc.springboot.udemy.ws.service;

import ch.ulmc.springboot.udemy.ws.ui.model.request.UserDetailsRequestModel;
import ch.ulmc.springboot.udemy.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}