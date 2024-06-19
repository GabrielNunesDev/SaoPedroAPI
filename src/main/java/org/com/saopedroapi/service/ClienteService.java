package org.com.saopedroapi.service;

import org.com.saopedroapi.model.Cliente;
import org.com.saopedroapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void cadastrar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            cliente.setId(id);
            clienteRepository.save(cliente);
            return Optional.of(cliente);
        } else {
            return Optional.empty();
        }
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}