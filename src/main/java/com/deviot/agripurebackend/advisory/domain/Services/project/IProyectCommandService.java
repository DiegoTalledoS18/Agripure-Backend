package com.deviot.agripurebackend.advisory.domain.Services.project;

import com.deviot.agripurebackend.advisory.domain.model.commands.project.AddDeviceProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.CreateProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.DeleteProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.StartProjectCommand;

public interface IProyectCommandService {
    String handle(AddDeviceProjectCommand addDeviceProjectCommand);
    String handle(CreateProjectCommand createProjectCommand);
    String handle(DeleteProjectCommand deleteProjectCommand);

    String handle(StartProjectCommand startProjectCommand);
}
