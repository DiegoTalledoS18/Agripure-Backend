package com.deviot.agripurebackend.profile.domain.model.commands;

public record CreateProfileCommand(Long accountId ,String name,String description,String imageUrl, String location,Long planId) {
}
