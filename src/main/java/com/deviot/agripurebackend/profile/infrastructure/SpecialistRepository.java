package com.deviot.agripurebackend.profile.infrastructure;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Specialist findSpecialistByAccountId(Long accountId);
}
