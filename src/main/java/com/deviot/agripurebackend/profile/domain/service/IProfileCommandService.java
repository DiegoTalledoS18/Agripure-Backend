package com.deviot.agripurebackend.profile.domain.service;

import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.UpdateProfileCommand;

public interface IProfileCommandService {
    String handle(CreateProfileCommand createProfileCommand);

    String handle(UpdateProfileCommand updateProfileCommand);

    String handle(DeleteProfileCommand deleteProfileCommand);
}
