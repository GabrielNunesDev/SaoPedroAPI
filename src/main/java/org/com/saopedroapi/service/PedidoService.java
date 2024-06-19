package org.com.saopedroapi.service;

import org.com.saopedroapi.model.Pedido;
import org.com.saopedroapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obterTodosPedidos() {
        return pedidoRepository.findByStatusTrue();
    }

    public Optional<Pedido> obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }


    public boolean deletarPedido(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setStatus(false);
            pedidoRepository.save(pedido);
            return true;
        } else {
            return false;
        }
    }
}