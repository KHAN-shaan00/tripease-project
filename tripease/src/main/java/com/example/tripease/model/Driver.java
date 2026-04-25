package com.example.tripease.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driver_id;
    private String name;
    private int age;
    private String emailId;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<Booking> booking = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    Cab cab;
}
