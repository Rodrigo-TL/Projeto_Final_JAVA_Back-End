package com.example.projetofinaljavabackend.controller;

import com.example.projetofinaljavabackend.model.Endereco;
import com.example.projetofinaljavabackend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public List<Endereco> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco) {
        return repository.save(endereco);
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable Long id, @RequestBody Endereco novoEndereco) {
        return repository.findById(id).map(endereco -> {
            endereco.setCep(novoEndereco.getCep());
            endereco.setLogradouro(novoEndereco.getLogradouro());
            endereco.setBairro(novoEndereco.getBairro());
            endereco.setLocalidade(novoEndereco.getLocalidade());
            endereco.setUf(novoEndereco.getUf());
            return repository.save(endereco);
        }).orElseThrow(() -> new RuntimeException("Endereço não encontrado com o id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
