package com.britolabs.codeforge.account.adapter.in.web;

import com.britolabs.codeforge.account.application.AccountView;

public record AccountResponse(
        String name,
        String greetingName,
        int level,
        int streakDays,
        DailyGoal dailyGoal) {
    public record DailyGoal(int completed, int target) {
    }
    public static AccountResponse from(AccountView view) {
        return new AccountResponse(
                view.name(),
                view.greetingName(),
                view.level(),
                view.streakDays(),
                new DailyGoal(view.dailyGoal().completed(), view.dailyGoal().target()));
    }
}
