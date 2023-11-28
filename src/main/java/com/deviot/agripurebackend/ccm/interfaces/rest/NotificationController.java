package com.deviot.agripurebackend.ccm.interfaces.rest;


import com.deviot.agripurebackend.ccm.application.internal.NotificationCommandService;
import com.deviot.agripurebackend.ccm.application.internal.QueryService.NotificationQueryService;
import com.deviot.agripurebackend.ccm.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.ccm.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.ccm.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.ccm.domain.model.queries.GetNotificationsByToAccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationCommandService notificationCommandService;

    private final NotificationQueryService notificationQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody CreateNotificationCommand createNotificationCommand){
        this.notificationCommandService.handle(createNotificationCommand);
        return ResponseEntity.ok("Notification created!!");
    }
    @CrossOrigin
    @DeleteMapping("/deleteNotificationById/{id}")
    public ResponseEntity<?> deleteNotificationById(@PathVariable("id") Long id){
        DeleteNotificationCommand deleteNotificationCommand=new DeleteNotificationCommand(id);
        this.notificationCommandService.handle(deleteNotificationCommand);
        return ResponseEntity.ok("Notification deleted");
    }
    @CrossOrigin
    @GetMapping("/getByToAccountId/{toAccountId}")
    public ResponseEntity<?> getNotificationsByToAccountId(@PathVariable("toAccountId") Long toAccountId){
        GetNotificationsByToAccountId getNotificationsByToAccountId=new GetNotificationsByToAccountId(toAccountId);
        List<Notification> notifications = this.notificationQueryService.handle(getNotificationsByToAccountId);
        return ResponseEntity.ok(notifications);

    }

}
