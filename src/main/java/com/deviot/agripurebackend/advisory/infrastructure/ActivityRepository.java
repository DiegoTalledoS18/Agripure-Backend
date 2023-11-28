package com.deviot.agripurebackend.advisory.infrastructure;

import com.deviot.agripurebackend.advisory.domain.model.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    List<Activity> findActivitiesByProjectId(Long id);
}
