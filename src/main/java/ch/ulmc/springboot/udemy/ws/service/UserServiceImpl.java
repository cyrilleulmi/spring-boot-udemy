package ch.ulmc.springboot.udemy.ws.service;

import org.springframework.stereotype.Service;

import ch.ulmc.springboot.udemy.ws.ui.model.request.UserDetailsRequestModel;
import ch.ulmc.springboot.udemy.ws.ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {
    private UuidService uuidService;

    public UserServiceImpl(UuidService uuidService) {
        this.uuidService = uuidService;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setUserId(uuidService.getUuid());

        return returnValue;
    };
}
