package com.deviot.agripurebackend.account.interfaces.rest;

import com.deviot.agripurebackend.account.application.internal.AccountCommandService;
import com.deviot.agripurebackend.account.application.internal.QueryService.AccountQueryService;
import com.deviot.agripurebackend.account.domain.model.commands.DeleteAccountCommand;
import com.deviot.agripurebackend.profile.application.internal.ProfileCommandService;
import com.deviot.agripurebackend.profile.application.internal.SpecialistCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final ProfileCommandService profileCommandService;
    private final SpecialistCommandService specialistCommandService;

    @CrossOrigin
    @PostMapping(value = "prueba")
    public String Welcome(){
        return "Welcome to agripure";
    }
}
