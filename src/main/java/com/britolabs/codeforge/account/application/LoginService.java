package com.britolabs.codeforge.account.application;

import com.britolabs.codeforge.account.application.port.in.LoginUseCase;
import com.britolabs.codeforge.account.application.port.out.AccessTokenIssuer;
import com.britolabs.codeforge.account.application.port.out.UserDirectory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements LoginUseCase {

    private final UserDirectory users;
    private final AccessTokenIssuer tokens;

    public LoginService(UserDirectory users, AccessTokenIssuer tokens) {
        this.users = users;
        this.tokens = tokens;
    }

    @Override
    public Optional<String> login(String email, String password) {
        return users.authenticate(email, password).map(tokens::issue);
    }
}
