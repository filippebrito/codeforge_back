package com.britolabs.codeforge.account.application;

public record AccountView(
        String name,
        String greetingName,
        int level,
        int streakDays,
        DailyGoal dailyGoal) {
    public record DailyGoal(int completed, int target) {
    }
}