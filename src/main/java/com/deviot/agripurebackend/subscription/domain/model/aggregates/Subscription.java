package com.deviot.agripurebackend.subscription.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "subscriptions")
@AllArgsConstructor
@NoArgsConstructor
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "valid_date")
    private String validDate;

    @Column(name = "active")
    private Boolean active;
}
