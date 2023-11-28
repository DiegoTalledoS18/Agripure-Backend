package com.deviot.agripurebackend.subscription.domain.services;

import com.deviot.agripurebackend.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.DeleteSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.UpdateSubscriptionCommand;

public interface ISubscriptionCommandService {
    String handle(CreateSubscriptionCommand createSubscriptionCommand);
    String handle(UpdateSubscriptionCommand updateSubscriptionCommand);
    String handle(DeleteSubscriptionCommand deleteSubscriptionCommand);
}
