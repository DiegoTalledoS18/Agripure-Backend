package com.deviot.agripurebackend.profile.infrastructure;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findProfileByAccountId(Long accountId);
}
