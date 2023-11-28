package com.deviot.agripurebackend.advisory.application.internal.activity;

import com.deviot.agripurebackend.advisory.domain.Services.activity.IActivityCommandService;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.DeleteActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Activity;
import com.deviot.agripurebackend.advisory.infrastructure.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityCommandService implements IActivityCommandService {

    private final ActivityRepository activityRepository;
    @Override
    public String handle(CreateActivityCommand createActivityCommand) {
        Activity newActivity=Activity.builder()
                .projectId(createActivityCommand.projectId())
                .title(createActivityCommand.title())
                .description(createActivityCommand.description())
                .date(createActivityCommand.date())
                .completed(false)
                .build();

        activityRepository.save(newActivity);
        return "Activity created!!!";
    }

    @Override
    public String handle(DeleteActivityCommand deleteActivityCommand) {
        Optional<Activity> activity=activityRepository.findById(deleteActivityCommand.id());
        if(activity.isPresent()){
            activityRepository.deleteById(deleteActivityCommand.id());
            return "Activity deleted!!";
        }
        else{
            return "Activity with the given id doesn't exist";
        }
    }

    @Override
    public String handle(CompleteActivityCommand completeActivityCommand) {
        Optional<Activity> activity=activityRepository.findById(completeActivityCommand.id());
        if(activity.isPresent()){
            activity.get().setCompleted(true);
            activityRepository.save(activity.get());
            return "Activity completed!!";
        }
        else{
            return "Activity with the given id doesn't exist";
        }
    }
}
