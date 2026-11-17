package com.britolabs.codeforge.account.application.port.in;

import com.britolabs.codeforge.account.application.AccountView;

import java.util.Optional;

public interface GetAccountUseCase {

    Optional<AccountView> get();
}
