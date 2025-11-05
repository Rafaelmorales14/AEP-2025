package com.inclusao.vagas_inclusivas.controller;

import com.inclusao.vagas_inclusivas.model.Empresa;
import com.inclusao.vagas_inclusivas.repository.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        return empresaRepository.findById(id).orElseThrow();
    }

    @PostMapping()
    public Empresa criar(@RequestBody Empresa empresa) {
        Empresa empresaNovo = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaNovo).getBody();
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresaAtualizado) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        empresa.setNomeFantasia(empresaAtualizado.getNomeFantasia());
        empresa.setCnpj(empresaAtualizado.getCnpj());
        empresa.setEmail(empresaAtualizado.getEmail());
        empresa.setSenha(empresaAtualizado.getSenha());
        empresa.setCidade(empresaAtualizado.getCidade());
        empresa.setDescricaoInclusao(empresaAtualizado.getDescricaoInclusao());
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaRepository.deleteById(id);
    }

}
