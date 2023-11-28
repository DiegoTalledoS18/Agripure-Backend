package com.deviot.agripurebackend.ccm.domain.model.aggregates;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "date")
    private String date;

    @Column(name = "to_account_id")
    private Long toAccountId;

    @Column(name = "plant_id")
    private Long plantId;

    @Column(name = "from_account_id")
    private Long fromAccountId;

    @Column(name = "seen")
    private Boolean seen;





}

