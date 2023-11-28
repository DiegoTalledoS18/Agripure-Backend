package com.deviot.agripurebackend.profile.domain.model.commands.specialist;

public record UpdateSpecialistCommand(Long accountId, String expertise, String contactEmail, String areasOfFocus) {
}
