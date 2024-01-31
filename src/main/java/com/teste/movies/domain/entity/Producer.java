package com.teste.movies.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producer")
@Data
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producerName")
    private String producerName;

    public Producer(String producerName) {
        this.producerName = producerName;
    }

    public Producer() {

    }
}
