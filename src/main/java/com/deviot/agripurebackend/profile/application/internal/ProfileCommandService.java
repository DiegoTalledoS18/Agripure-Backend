package com.deviot.agripurebackend.profile.application.internal;
import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.UpdateProfileCommand;
import com.deviot.agripurebackend.profile.domain.service.IProfileCommandService;
import com.deviot.agripurebackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProfileCommandService implements IProfileCommandService {
    private final ProfileRepository profileRepository;

    @Override
    public String handle(CreateProfileCommand createProfileCommand){
        Profile newProfile=Profile.builder()
                .accountId(createProfileCommand.accountId())
                .name(createProfileCommand.name())
                .description(createProfileCommand.description())
                .imageUrl(createProfileCommand.imageUrl())
                .location(createProfileCommand.location())
                .planId(createProfileCommand.planId())
                .build();
        if(profileRepository.save(newProfile)!=null){
            return "PROFILE CREATED!!";
        }else {
            return "CANT REGISTER YOUR PROFILE";
        }
    }

    @Override
    public String handle(UpdateProfileCommand updateProfileCommand){
        Optional<Profile> profile= Optional.ofNullable(profileRepository.findProfileByAccountId(updateProfileCommand.accountId()));
        if(profile.isPresent()){
            profile.get().setName(updateProfileCommand.name());
            profile.get().setDescription(updateProfileCommand.description());
            profile.get().setImageUrl(updateProfileCommand.imageUrl());
            profile.get().setLocation(updateProfileCommand.location());
            profile.get().setPlanId(updateProfileCommand.planId());
            profileRepository.save(profile.get());
            return "Profile updated!";
        }
        else {
            return "Profile with the given id doesn't exist";
        }
    }

    @Override
    public String handle(DeleteProfileCommand deleteProfileCommand){
        Optional<Profile> profile = Optional.ofNullable(profileRepository.findProfileByAccountId(deleteProfileCommand.accountId()));
        if(profile.isPresent()){
            profileRepository.deleteById(profile.get().getId());
            return "Profile with Id "+deleteProfileCommand.accountId()+" was deleted";
        }else {
            return "Profile with Id: "+deleteProfileCommand.accountId()+" doesn´t exist";
        }
    }
}
