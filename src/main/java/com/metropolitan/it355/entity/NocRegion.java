package com.metropolitan.it355.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "noc_region")
public class NocRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "noc", length = 5)
    private String noc;

    @Column(name = "region_name", length = 200)
    private String regionName;

}