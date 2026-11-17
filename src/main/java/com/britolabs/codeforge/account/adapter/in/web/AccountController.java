package com.britolabs.codeforge.account.adapter.in.web;

import com.britolabs.codeforge.account.application.port.in.GetAccountUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final GetAccountUseCase getAccount;

    public AccountController(GetAccountUseCase getAccount) {
        this.getAccount = getAccount;
    }

    @GetMapping
    public ResponseEntity<AccountResponse> get() {
        return getAccount.get()
                .map(view -> ResponseEntity.ok(AccountResponse.from(view)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
