package com.deviot.agripurebackend.subscription.interfaces.rest;

import com.deviot.agripurebackend.subscription.application.internal.QueryService.SubscriptionQueryService;
import com.deviot.agripurebackend.subscription.application.internal.SubscriptionCommandService;
import com.deviot.agripurebackend.subscription.domain.model.aggregates.Subscription;
import com.deviot.agripurebackend.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.DeleteSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.commands.UpdateSubscriptionCommand;
import com.deviot.agripurebackend.subscription.domain.model.queries.GetSubscriptionByAccountIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createSubscription(@RequestBody CreateSubscriptionCommand createSubscriptionCommand){
        this.subscriptionCommandService.handle(createSubscriptionCommand);
        return ResponseEntity.ok("subscription created!!!");
    }

    @CrossOrigin
    @GetMapping("/getSubscription/{accountId}")
    public ResponseEntity<?> getSubscriptionByAccountId(@PathVariable("accountId")Long accountId){
        GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery=new GetSubscriptionByAccountIdQuery(accountId);
        Subscription subscription=this.subscriptionQueryService.handle(getSubscriptionByAccountIdQuery);
        if(subscription!=null){
            return ResponseEntity.ok(subscription);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<?> updateSubscriptionByAccountId(@RequestBody UpdateSubscriptionCommand updateSubscriptionCommand){
        String message=this.subscriptionCommandService.handle(updateSubscriptionCommand);
        return ResponseEntity.ok(message);
    }

    @CrossOrigin
    @DeleteMapping("/deleteSubscription/{accountId}")
    public ResponseEntity<?> deleteSubscriptionByAccountId(@PathVariable("accountId")Long accountId){
        DeleteSubscriptionCommand deleteSubscriptionCommand=new DeleteSubscriptionCommand(accountId);
        String message=this.subscriptionCommandService.handle(deleteSubscriptionCommand);
        return ResponseEntity.ok(message);
    }
}
