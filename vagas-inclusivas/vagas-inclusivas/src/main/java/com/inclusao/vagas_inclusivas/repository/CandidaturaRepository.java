package com.inclusao.vagas_inclusivas.repository;

import com.inclusao.vagas_inclusivas.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long>{
    List<Candidatura> findByUsuarioId(Long usuarioId);
    List<Candidatura> findByVagaId(Long vagaId);
}
