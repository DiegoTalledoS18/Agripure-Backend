package com.deviot.agripurebackend.ccm.domain.services;

import com.deviot.agripurebackend.ccm.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.ccm.domain.model.commands.DeleteNotificationCommand;

public interface INotificationsCommandService {
    String handle(CreateNotificationCommand createNotificationCommand);
    String handle(DeleteNotificationCommand deleteNotificationCommand);

}
