package com.deviot.agripurebackend.advisory.infrastructure;

import com.deviot.agripurebackend.advisory.domain.model.aggregates.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findProjectsByFarmerId(Long id);
    List<Project> findProjectsBySpecialistId(Long id);

    Project findProjectByCropId(Long projectId);
}
