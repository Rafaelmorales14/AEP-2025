package com.inclusao.vagas_inclusivas.controller;

import com.inclusao.vagas_inclusivas.model.Candidatura;
import com.inclusao.vagas_inclusivas.model.Usuario;
import com.inclusao.vagas_inclusivas.model.Vaga;
import com.inclusao.vagas_inclusivas.repository.CandidaturaRepository;
import com.inclusao.vagas_inclusivas.repository.UsuarioRepository;
import com.inclusao.vagas_inclusivas.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    private final CandidaturaRepository candidaturaRepository;
    private final UsuarioRepository usuarioRepository;
    private final VagaRepository vagaRepository;

    public CandidaturaController(CandidaturaRepository candidaturaRepository,
                                 UsuarioRepository usuarioRepository,
                                 VagaRepository vagaRepository) {

        this.candidaturaRepository = candidaturaRepository;
        this.usuarioRepository = usuarioRepository;
        this.vagaRepository = vagaRepository;
    }

    @PostMapping("/usuarios/{usuarioId}/vagas/{vagaId}")
    public Candidatura criarCandidatura(@PathVariable Long usuarioId, @PathVariable Long vagaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow();
         Candidatura candidatura = new Candidatura();
         candidatura.setUsuario(usuario);
         candidatura.setVaga(vaga);
         candidatura.setStatusCandidatura("EM ANÁLISE");
         return candidaturaRepository.save(candidatura);
    }

    @GetMapping
    public List<Candidatura> listarCandidaturas() {
        return candidaturaRepository.findAll();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public List<Candidatura> listarPorUsuario(@PathVariable Long usuarioId) {
        return candidaturaRepository.findByUsuarioId(usuarioId);
    }

    @GetMapping("/vaga/{vagaId}")
    public List<Candidatura> listarPorVaga(@PathVariable Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    @PutMapping("/{id}")
    public Candidatura atualizarStatus(@PathVariable Long id, @RequestBody Candidatura candidaturaAtualizada) {
        Candidatura candidatura = candidaturaRepository.findById(id).orElseThrow();
        candidatura.setStatusCandidatura(candidaturaAtualizada.getStatusCandidatura());
        return candidaturaRepository.save(candidatura);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        candidaturaRepository.deleteById(id);
    }

}
