package com.teste.movies.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Studios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studioName")
    private String studioName;

    public Studios(String studioName) {
        this.studioName = studioName;
    }

    public Studios() {

    }
}
