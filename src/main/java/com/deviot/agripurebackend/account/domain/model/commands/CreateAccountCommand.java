package com.deviot.agripurebackend.account.domain.model.commands;

import lombok.Getter;

public record CreateAccountCommand( String email,String password,String type) {
}
