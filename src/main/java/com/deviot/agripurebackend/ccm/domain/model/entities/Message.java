package com.deviot.agripurebackend.ccm.domain.model.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contact_id")
    private long contactId;

    @Column(name = "author_id")
    private long authorId;

    @Column(name = "message")
    private String message;

    @Column(name = "hour")
    private String hour;

}
