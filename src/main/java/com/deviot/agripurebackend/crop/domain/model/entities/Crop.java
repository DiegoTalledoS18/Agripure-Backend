package com.deviot.agripurebackend.crop.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "crops")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "farmer_id")
    private Long farmerId;

    @Column(name="plant_id")
    private Long plantId;

    @Column(name="specialist_id")
    private Long specialistId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;
}
