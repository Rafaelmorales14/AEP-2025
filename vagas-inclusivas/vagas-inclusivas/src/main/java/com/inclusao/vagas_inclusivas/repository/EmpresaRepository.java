package com.inclusao.vagas_inclusivas.repository;

import com.inclusao.vagas_inclusivas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
