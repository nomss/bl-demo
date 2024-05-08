package com.ayeeti.blservice.location;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airport_name", nullable = false, unique = true)
    private String airportName;

    @Column(name = "airport_code", nullable = false)
    private String airportCode;
}