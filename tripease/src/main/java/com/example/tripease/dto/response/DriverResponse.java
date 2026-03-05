package com.example.tripease.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
    private Integer driver_id;
    private String name;
    private int age;
    private String emailId;
}
