package com.britolabs.codeforge.account.adapter.out.token;

import com.britolabs.codeforge.account.application.port.out.AccessTokenReader;
import com.britolabs.codeforge.account.application.port.out.UserDirectory;
import com.britolabs.codeforge.account.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class FixedAccessTokenReader implements AccessTokenReader {

    private static final UUID ALEX_ID =
            UUID.fromString("11111111-1111-1111-1111-111111111111");

    private final UserDirectory users;

    public FixedAccessTokenReader(UserDirectory users) {
        this.users = users;
    }

    @Override
    public Optional<User> read(String token) {
        if (!FixedAccessTokenIssuer.MOCK_TOKEN.equals(token)) {
            return Optional.empty();
        }
        return users.findById(ALEX_ID);
    }
}
