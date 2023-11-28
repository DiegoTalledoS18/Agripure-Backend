package com.deviot.agripurebackend.advisory.interfaces.rest;

import com.deviot.agripurebackend.advisory.application.internal.activity.ActivityCommandService;
import com.deviot.agripurebackend.advisory.application.internal.activity.ActivityQueryService;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.DeleteActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Activity;
import com.deviot.agripurebackend.advisory.domain.model.queries.activity.GetActivitiesByProjectId;
import com.deviot.agripurebackend.advisory.domain.model.queries.activity.GetActivityByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    private final ActivityCommandService activityCommandService;
    private final ActivityQueryService activityQueryService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody CreateActivityCommand createActivityCommand){
        this.activityCommandService.handle(createActivityCommand);
        return ResponseEntity.ok("Activity created !!");
    }

    @CrossOrigin
    @GetMapping("/activityByProjectId/{projectId}")
    public ResponseEntity<?> getActivityByProjectId(@PathVariable("projectId") Long projectId){
        GetActivitiesByProjectId getActivitiesByProjectId=new GetActivitiesByProjectId(projectId);
        List<Activity> activities=this.activityQueryService.handle(getActivitiesByProjectId);
        if(activities!=null){
            return ResponseEntity.ok(activities);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/activityById/{activityId}")
    public ResponseEntity<?> getActivityById(@PathVariable("activityId") Long activityId){
        GetActivityByIdQuery getActivityByIdQuery=new GetActivityByIdQuery(activityId);
        Activity activity=this.activityQueryService.handle(getActivityByIdQuery);
        if(activity!=null){
            return ResponseEntity.ok(activity);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @DeleteMapping("/deleteActivityById/{activityId}")
    public ResponseEntity<?> deleteActivityById(@PathVariable("activityId") Long activityId){
        DeleteActivityCommand deleteActivityCommand=new DeleteActivityCommand(activityId);
        String message=this.activityCommandService.handle(deleteActivityCommand);
        return ResponseEntity.ok(message);
    }
    @CrossOrigin
    @PutMapping("/completeActivity/{activityId}")
    public ResponseEntity<?> completeActivityById(@PathVariable("activityId") Long activityId){
        CompleteActivityCommand completeActivityCommand=new CompleteActivityCommand(activityId);
        String message=this.activityCommandService.handle(completeActivityCommand);
        return ResponseEntity.ok(message);
    }

}
