package com.inclusao.vagas_inclusivas.controller;

import com.inclusao.vagas_inclusivas.model.Empresa;
import com.inclusao.vagas_inclusivas.model.Vaga;
import com.inclusao.vagas_inclusivas.repository.EmpresaRepository;
import com.inclusao.vagas_inclusivas.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository;

    public VagaController(VagaRepository vagaRepository, EmpresaRepository empresaRepository) {
        this.vagaRepository = vagaRepository;
        this.empresaRepository = empresaRepository;
    }

    @PostMapping("/empresa/{empresaId}")
    public Vaga criarVaga(@PathVariable Long empresaId, @RequestBody Vaga vaga) {
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow();
        vaga.setEmpresa(empresa);
        return vagaRepository.save(vaga);
    }

    @GetMapping()
    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }

    @GetMapping("/empresa/{empresaId}")
    public List<Vaga> listarVagasPorEmpresa(@PathVariable Long empresaId) {
        return vagaRepository.findByEmpresaId(empresaId);
    }

    @PutMapping("/empresas/{empresaId}/vagas/{vagaId}")
    public Vaga atualizarVaga(@PathVariable Long empresaId, @PathVariable Long vagaId, @RequestBody Vaga vagaAtualizada) {
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow();
        vaga.setTitulo(vagaAtualizada.getTitulo());
        vaga.setDescricao(vagaAtualizada.getDescricao());
        vaga.setRequisitos(vagaAtualizada.getRequisitos());
        vaga.setTipoAdaptacao(vagaAtualizada.getTipoAdaptacao());
        vaga.setStatusVaga(vagaAtualizada.getStatusVaga());
        return vagaRepository.save(vaga);
    }

    @DeleteMapping("/empresas/{empresaId}/vagas/{vagaId}")
    public void deletarVaga(@PathVariable Long empresaId, @PathVariable Long vagaId) {
        Vaga vaga = vagaRepository.findById(vagaId).orElseThrow();
        vagaRepository.deleteById(vagaId);
    }
}
