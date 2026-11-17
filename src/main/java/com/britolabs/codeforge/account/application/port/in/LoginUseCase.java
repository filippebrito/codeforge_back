package com.britolabs.codeforge.account.application.port.in;

import java.util.Optional;

public interface LoginUseCase {
    Optional<String> login(String email, String password);
}
