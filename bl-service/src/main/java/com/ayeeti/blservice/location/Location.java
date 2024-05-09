package com.ayeeti.blservice.location;

import com.ayeeti.blservice.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOCATION")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airport_name", nullable = false, unique = true)
    private String airportName;

    @Column(name = "airport_code", nullable = false, unique = true)
    private String airportCode;

    @ManyToMany(mappedBy = "locations")
    private List<User> users = new ArrayList<>();
}