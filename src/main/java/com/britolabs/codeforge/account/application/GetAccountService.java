package com.britolabs.codeforge.account.application;


import com.britolabs.codeforge.account.application.port.in.GetAccountUseCase;
import com.britolabs.codeforge.account.application.port.out.CurrentUser;
import com.britolabs.codeforge.account.domain.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetAccountService implements GetAccountUseCase {

    private static final int INITIAL_LEVEL = 1;
    private static final int INITIAL_STREAK = 0;
    private static final int DAILY_GOAL_TARGET = 3;

    private final CurrentUser currentUser;

    public GetAccountService(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }
    @Override
    public Optional<AccountView> get() {
        return currentUser.get().map(this::toView);
    }
    private AccountView toView(User user) {
        return new AccountView(
                user.name(),
                greetingName(user.name()),
                INITIAL_LEVEL,
                INITIAL_STREAK,
                new AccountView.DailyGoal(0, DAILY_GOAL_TARGET));
    }
    private String greetingName(String name) {
        int space = name.indexOf(' ');
        if (space == -1) {
            return name;
        }
        return name.substring(0, space);
    }

}
