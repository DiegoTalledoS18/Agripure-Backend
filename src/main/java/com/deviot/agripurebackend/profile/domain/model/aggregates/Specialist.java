package com.deviot.agripurebackend.profile.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "specialits")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name="expertise")
    private String expertise;

    @Column(name="contact_email")
    private String contactEmail;

    @Column(name="areas_of_focus")
    private String areasOfFocus;

}
