package com.example.tripease.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DriverRequest {
    private String name;
    private int age;
    private String emailId;
}
