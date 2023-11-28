package com.deviot.agripurebackend.ccm.domain.services.queryService;

import com.deviot.agripurebackend.ccm.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.ccm.domain.model.queries.GetNotificationsByToAccountId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId);
}
