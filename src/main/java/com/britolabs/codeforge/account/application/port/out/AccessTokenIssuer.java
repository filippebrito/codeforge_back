package com.britolabs.codeforge.account.application.port.out;

import com.britolabs.codeforge.account.domain.User;

public interface AccessTokenIssuer {
    String issue(User user);
}
