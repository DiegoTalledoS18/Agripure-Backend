package com.deviot.agripurebackend.advisory.domain.Services.activity;

import com.deviot.agripurebackend.advisory.domain.model.entities.Activity;
import com.deviot.agripurebackend.advisory.domain.model.queries.activity.GetActivitiesByProjectId;
import com.deviot.agripurebackend.advisory.domain.model.queries.activity.GetActivityByIdQuery;

import java.util.List;

public interface IActivityQueryService {
    Activity handle(GetActivityByIdQuery getActivityByIdQuery);
    List<Activity> handle(GetActivitiesByProjectId getActivitiesByProjectId);
}
