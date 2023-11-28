package com.deviot.agripurebackend.profile.domain.service.queryService;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Specialist;
import com.deviot.agripurebackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;

public interface ISpecialistQueryService {
    Specialist handle(GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery);

}
