package com.deviot.agripurebackend.subscription.domain.services.queryService;

import com.deviot.agripurebackend.subscription.domain.model.aggregates.Subscription;
import com.deviot.agripurebackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;

public interface ISubscriptionQueryService {
    Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery);
}
