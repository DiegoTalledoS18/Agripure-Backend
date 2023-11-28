package com.deviot.agripurebackend.advisory.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="farmer_id")
    private Long farmerId;

    @Column(name = "specialist_id")
    private Long specialistId;

    @Column(name="is_project_started")
    private boolean isProjectStarted;

    @Column(name="crop_id")
    private Long cropId;

    @Column(name="device")
    private Boolean device;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;


}
