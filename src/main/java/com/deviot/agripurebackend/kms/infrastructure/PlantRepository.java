package com.deviot.agripurebackend.kms.infrastructure;

import com.deviot.agripurebackend.kms.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
}
