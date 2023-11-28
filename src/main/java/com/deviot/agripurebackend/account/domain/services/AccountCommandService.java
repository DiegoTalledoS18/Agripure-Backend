package com.deviot.agripurebackend.account.domain.services;

import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.DeleteAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import com.deviot.agripurebackend.account.infrastructure.dtos.AuthResponse;

public interface AccountCommandService {

    AuthResponse handle(CreateAccountCommand createAccountCommand);
    AuthResponse handle(LogInCommand logInCommand);

    String handle(DeleteAccountCommand deleteAccountCommand);
}
