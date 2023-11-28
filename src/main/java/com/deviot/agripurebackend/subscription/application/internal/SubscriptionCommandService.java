package com.deviot.agripurebackend.subscription.application.internal;

import com.deviot.agripurebackend.subscription.domain.model.aggregates.Subscription;
import com.deviot.agripurebackend.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.DeleteSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.UpdateSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.services.ISubscriptionCommandService;
import com.deviot.agripurebackend.subscription.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionCommandService implements ISubscriptionCommandService {
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public String handle(CreateSubscriptionCommand createSubscriptionCommand) {
        Subscription subscription=Subscription.builder()
                .accountId(createSubscriptionCommand.accountId())
                .validDate(createSubscriptionCommand.validDate())
                .active(createSubscriptionCommand.active())
                .build();
        if(subscriptionRepository.save(subscription)!=null){
            return "SUBSCRIPTION CREATED!!";
        }else {
            return "CANT REGISTER YOUR SUBSCRIPTION";
        }
    }

    @Override
    public String handle(UpdateSubscriptionCommand updateSubscriptionCommand) {
        Optional<Subscription> subscription=Optional.ofNullable(subscriptionRepository.findSubscriptionByAccountId(updateSubscriptionCommand.accountId()));
        if(subscription.isPresent()){
            subscription.get().setActive(updateSubscriptionCommand.active());
            subscriptionRepository.save(subscription.get());
            return "SUBSCRIPTION updated!";
        }
        else {
            return "SUBSCRIPTION with the given id doesn't exist";
        }
    }

    @Override
    public String handle(DeleteSubscriptionCommand deleteSubscriptionCommand) {
        Optional<Subscription> subscription=Optional.ofNullable(subscriptionRepository.findSubscriptionByAccountId(deleteSubscriptionCommand.accountId()));
        if(subscription.isPresent()){
            subscriptionRepository.deleteById(subscription.get().getId());
            return "Profile with account Id "+deleteSubscriptionCommand.accountId()+" was deleted";
        }
        else {
            return "Profile with account Id: "+deleteSubscriptionCommand.accountId()+" doesn´t exist";
        }
    }
}
