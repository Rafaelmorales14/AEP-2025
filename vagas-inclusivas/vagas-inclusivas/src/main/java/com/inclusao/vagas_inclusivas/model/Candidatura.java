package com.inclusao.vagas_inclusivas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Candidatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private String statusCandidatura;
}
