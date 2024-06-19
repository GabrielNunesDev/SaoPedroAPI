package org.com.saopedroapi.service;

import org.com.saopedroapi.model.Funcionario;
import org.com.saopedroapi.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ResponseEntity<String> cadastrar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return ResponseEntity.ok("Funcionário cadastrado com sucesso!");
    }

    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    public ResponseEntity<String> atualizarFuncionario(Long id, Funcionario funcionario) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()) {
            funcionario.setId(id);
            funcionarioRepository.save(funcionario);
            return ResponseEntity.ok("Cadastro atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> excluirFuncionario(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok("Funcionário excluído com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}