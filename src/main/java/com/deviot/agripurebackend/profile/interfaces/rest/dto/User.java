package com.deviot.agripurebackend.profile.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String email;
    String name;
    String description;
    String imageUrl;
    String location;
    String type;
    Long planId;
    Long accountId;

}
