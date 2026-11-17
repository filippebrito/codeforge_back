package com.britolabs.codeforge.account.adapter.out.memory;

import com.britolabs.codeforge.account.application.port.out.UserDirectory;
import com.britolabs.codeforge.account.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class InMemoryUserDirectory implements UserDirectory {

    private static final User ALEX = new User(
            UUID.fromString("11111111-1111-1111-1111-111111111111"),
            "Alex Brito",
            "alex@codeforge.dev");

    private static final String ALEX_PASSWORD = "Codeforge1";

    @Override
    public Optional<User> authenticate(String email, String rawPassword) {
        boolean sameEmail = ALEX.email().equalsIgnoreCase(email);
        boolean samePassword = ALEX_PASSWORD.equals(rawPassword);
        if (sameEmail && samePassword) {
            return Optional.of(ALEX);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(UUID id) {
        boolean sameID = ALEX.id().equals(id);
        if (sameID){
            return Optional.of(ALEX);
        }
        return Optional.empty();
    }
}