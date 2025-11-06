package com.inclusao.vagas_inclusivas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String requisitos;
    private String tipoAdaptacao;
    private String statusVaga;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<Candidatura> candidaturas;
}
