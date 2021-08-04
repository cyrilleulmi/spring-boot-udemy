package ch.ulmc.springboot.udemy.ws.ui.controller;

import java.util.HashMap;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ulmc.springboot.udemy.ws.ui.model.request.UserDetailsRequestModel;
import ch.ulmc.springboot.udemy.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

    HashMap<UUID, UserRest> users = new HashMap<UUID, UserRest>(); 

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit") int limit, @RequestParam(value = "sort", required = false) String sort) {
        return "get user was called with page " + page + " and limit " + limit + " and is sorted " + sort;
    }

    @GetMapping(path = "{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable UUID userId) {
        UserRest returnValue = users.get(userId);
        if (returnValue != null) {
            return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setUserId(UUID.randomUUID());
        users.put(returnValue.getUserId(), returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user called";
    }
}
