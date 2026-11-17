package com.britolabs.codeforge.account.application.port.out;

import com.britolabs.codeforge.account.domain.User;

import java.util.Optional;

public interface CurrentUser {
    Optional<User> get();
}
