package com.britolabs.codeforge.account.application.port.out;

import com.britolabs.codeforge.account.domain.User;
import java.util.Optional;
import java.util.UUID;

public interface UserDirectory {

    Optional<User> authenticate(String email, String rawPassword);

    Optional<User> findById(UUID id);
}
