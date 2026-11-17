package com.britolabs.codeforge.account.application.port.out;

import com.britolabs.codeforge.account.domain.User;

import java.util.Optional;

public interface AccessTokenReader {

    Optional<User> read(String token);
}
