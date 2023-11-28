package com.deviot.agripurebackend.ccm.domain.services.message;


import com.deviot.agripurebackend.ccm.domain.model.commands.chat.CreateMessageCommand;

public interface IMessageCommandService {
    String handle (CreateMessageCommand createMessageCommand);
}
