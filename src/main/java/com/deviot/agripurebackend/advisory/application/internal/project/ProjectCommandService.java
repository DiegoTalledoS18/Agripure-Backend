package com.deviot.agripurebackend.advisory.application.internal.project;

import com.deviot.agripurebackend.advisory.domain.Services.project.IProyectCommandService;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.AddDeviceProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.CreateProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.DeleteProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.project.StartProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.aggregates.Project;
import com.deviot.agripurebackend.advisory.infrastructure.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectCommandService implements IProyectCommandService {
    private final ProjectRepository projectRepository;

    @Override
    public String handle(AddDeviceProjectCommand addDeviceProjectCommand) {
        Optional<Project> project=projectRepository.findById(addDeviceProjectCommand.id());
        if(project.isPresent()){
            project.get().setDevice(true);
            projectRepository.save(project.get());
            return "Device changed!!";
        }
        else{
            return "Projet with the given id doesn't exist";
        }
    }

    @Override
    public String handle(CreateProjectCommand createProjectCommand) {
        Project newProject=Project.builder().farmerId(createProjectCommand.farmerId())
                .specialistId(createProjectCommand.specialistId())
                .isProjectStarted(createProjectCommand.isStarted())
                .cropId(createProjectCommand.cropId())
                .device(createProjectCommand.device())
                .name(createProjectCommand.name())
                .description(createProjectCommand.description())
                .startDate(createProjectCommand.startDate())
                .endDate(createProjectCommand.endDate())
                .build();
        projectRepository.save(newProject);
        return "Project created!!";
    }

    @Override
    public String handle(DeleteProjectCommand deleteProjectCommand) {
        Optional<Project> project=projectRepository.findById(deleteProjectCommand.projectId());
        if(project.isPresent()){
            projectRepository.deleteById(deleteProjectCommand.projectId());
            return "Project deleted!!";
        }
        else{
            return "Project with the given id doesn´t exist";
        }
    }

    @Override
    public String handle(StartProjectCommand startProjectCommand) {
        Optional<Project> project=projectRepository.findById(startProjectCommand.projectId());
        if(project.isPresent()){
            project.get().setProjectStarted(true);
            projectRepository.save(project.get());
            return "Project initialized!!";
        }
        else{
            return "Projet with the given id doesn't exist";
        }
    }
}
