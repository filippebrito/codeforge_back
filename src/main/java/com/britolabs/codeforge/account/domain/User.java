package com.britolabs.codeforge.account.domain;

import java.util.UUID;

public record User(UUID id,  String name, String email) {
}
