package com.britolabs.codeforge.account.adapter.out.token;

import com.britolabs.codeforge.account.application.port.out.AccessTokenIssuer;
import com.britolabs.codeforge.account.domain.User;
import org.springframework.stereotype.Component;

@Component
public class FixedAccessTokenIssuer implements AccessTokenIssuer {

    static final String MOCK_TOKEN = "mock-token";

    @Override
    public String issue(User user) {
        if (user == null){
            throw new IllegalArgumentException("Usuário obrigatório para emitir o token.");
        }
        return MOCK_TOKEN;
    }
}
