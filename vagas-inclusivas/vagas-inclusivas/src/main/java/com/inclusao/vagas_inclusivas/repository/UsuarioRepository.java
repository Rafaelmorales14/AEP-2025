package com.inclusao.vagas_inclusivas.repository;

import com.inclusao.vagas_inclusivas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}
