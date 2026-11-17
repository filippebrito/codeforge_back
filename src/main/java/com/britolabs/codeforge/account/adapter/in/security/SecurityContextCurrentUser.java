package com.britolabs.codeforge.account.adapter.in.security;

import com.britolabs.codeforge.account.application.port.out.CurrentUser;
import com.britolabs.codeforge.account.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityContextCurrentUser implements CurrentUser {
    @Override
    public Optional<User> get() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof User user)){
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
