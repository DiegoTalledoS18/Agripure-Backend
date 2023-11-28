package com.deviot.agripurebackend.account.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserAccount {
    String email;
    String password;
    String name;
    String description;
    String imageUrl;
    String location;
    String type;
    Long planId;

}
