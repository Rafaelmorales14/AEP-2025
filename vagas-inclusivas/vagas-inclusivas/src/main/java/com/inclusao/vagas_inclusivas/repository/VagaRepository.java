package com.inclusao.vagas_inclusivas.repository;

import com.inclusao.vagas_inclusivas.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long>{
    List<Vaga> findByEmpresaId(Long empresaId);
}
