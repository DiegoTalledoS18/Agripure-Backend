package com.deviot.agripurebackend.advisory.domain.model.commands.contact;

public record CreateContactCommand(Long farmerId,Long specialistId,Boolean isChatStarted) {
}
