package com.deviot.agripurebackend.advisory.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "farmer_id")
    private long farmerId;

    @Column(name = "specialist_id")
    private long specialistId;

    @Column(name = "is_chat_started")
    private Boolean isChatStarted;

}
