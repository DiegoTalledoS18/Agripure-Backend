package com.deviot.agripurebackend.kms.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="scientific_name")
    private String scientificName;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="variety")
    private String variety;

    @Column(name="land_type")
    private String landType;

    @Column(name="weather_conditions")
    private String weatherConditions;

    @Column(name="distance_between_plants")
    private String distanceBetweenPlants;

    @Column(name="ideal_planting_depth")
    private String idealPlantingDepth;

    @Column(name = "fertilization_and_fumigation")
    private String fertilizationAndFumigation;

    @Column(name = "ph")
    @JsonProperty("pH")
    private Double pH;

    @Column(name="min_temperature")
    private Double minTemperature;

    @Column(name="max_temperature")
    private Double maxTemperature;

    @Column(name = "min_humidity")
    private Double minHumidity;

    @Column(name="max_humidity")
    private Double maxHumidity;
}
