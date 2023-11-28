package com.deviot.agripurebackend.subscription.domain.model.commands;

public record UpdateSubscriptionCommand(Long accountId, Boolean active) {
}
