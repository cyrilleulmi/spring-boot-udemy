package ch.ulmc.springboot.api.account.accountmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountManagementController {
    @GetMapping("/status")
    public String getStatus() {
        return "account management working";
    }
}
