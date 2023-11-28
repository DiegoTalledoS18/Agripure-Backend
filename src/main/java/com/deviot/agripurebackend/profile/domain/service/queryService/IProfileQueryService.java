package com.deviot.agripurebackend.profile.domain.service.queryService;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByAccountIdQuery;

public interface IProfileQueryService {

    Profile handle(GetProfileByAccountIdQuery getProfileByAccountIdQuery);

}
