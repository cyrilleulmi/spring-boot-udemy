package ch.ulmc.springboot.udemy.ws.ui.controller;

import com.fasterxml.jackson.databind.util.RawValue;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ulmc.springboot.udemy.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit") int limit, @RequestParam(value = "sort", required = false) String sort) {
        return "get user was called with page " + page + " and limit " + limit + " and is sorted " + sort;
    }

    @GetMapping(path = "{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public UserRest getUser(@PathVariable String userId) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("obi-wan.kenobi@j.council.cor");
        returnValue.setFirstName("Obi Wan");
        returnValue.setLastName("Kenobi");
        returnValue.setUserId("a5c57b45-a875-40ef-8b41-149427eb8d97");
        return returnValue;
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
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
