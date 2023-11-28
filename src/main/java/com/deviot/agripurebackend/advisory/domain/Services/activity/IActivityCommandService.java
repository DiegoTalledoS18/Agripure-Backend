package com.deviot.agripurebackend.advisory.domain.Services.activity;

import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.activity.DeleteActivityCommand;

public interface IActivityCommandService {
    String handle(CreateActivityCommand createActivityCommand);
    String handle(DeleteActivityCommand deleteActivityCommand);

    String handle(CompleteActivityCommand completeActivityCommand);
}
