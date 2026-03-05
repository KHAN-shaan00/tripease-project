package com.example.tripease.dto.request;

import com.example.tripease.Enum.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CustomerRequest {

    private String name;
    private int age;
    private String emailId;
    private Gender gender;
}
