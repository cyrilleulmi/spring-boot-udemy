package ch.ulmc.springboot.udemy.ws.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UuidService {
    public UUID getUuid() {
        return UUID.randomUUID();
    }
}
