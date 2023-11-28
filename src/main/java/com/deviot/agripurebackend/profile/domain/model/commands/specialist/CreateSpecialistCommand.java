package com.deviot.agripurebackend.profile.domain.model.commands.specialist;

public record CreateSpecialistCommand(Long accountId, String expertise,String contactEmail ,String areasOfFocus) {
}
