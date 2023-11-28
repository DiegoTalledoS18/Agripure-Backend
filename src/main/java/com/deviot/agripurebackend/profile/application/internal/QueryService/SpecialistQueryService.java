package com.deviot.agripurebackend.profile.application.internal.QueryService;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Specialist;
import com.deviot.agripurebackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;
import com.deviot.agripurebackend.profile.domain.service.queryService.ISpecialistQueryService;
import com.deviot.agripurebackend.profile.infrastructure.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialistQueryService implements ISpecialistQueryService {
    private final SpecialistRepository specialistRepository;
    @Override
    public Specialist handle(GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery) {
        Optional<Specialist> specialist=Optional.ofNullable(specialistRepository.findSpecialistByAccountId(getSpecialistByAccountIdQuery.accountId()));
        if(specialist.isPresent()){
            return specialist.get();
        }else {
            return null;
        }
    }
}
