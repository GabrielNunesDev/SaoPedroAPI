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
        // Adicionar lógica de negócio para criar um Pedido
        // Por exemplo, validar dados do pedido, calcular valor total, etc.
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obterTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Optional<Pedido> atualizarPedido(Long id, Pedido detalhesPedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedidoExistente = pedidoOptional.get();
            // Atualizar os detalhes do pedido
            pedidoExistente.setCliente(detalhesPedido.getCliente());
            pedidoExistente.setFuncionario(detalhesPedido.getFuncionario());
            pedidoExistente.setProduto(detalhesPedido.getProduto());
            pedidoExistente.setValor(detalhesPedido.getValor());
            pedidoExistente.setFormaPagamento(detalhesPedido.getFormaPagamento());
            pedidoExistente.setQuantidadeItens(detalhesPedido.getQuantidadeItens());
            pedidoExistente.setDataPedido(detalhesPedido.getDataPedido());

            // Adicionar lógica de negócio adicional aqui, se necessário

            return Optional.of(pedidoRepository.save(pedidoExistente));
        } else {
            return Optional.empty();
        }
    }

    public boolean deletarPedido(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            pedidoRepository.delete(pedidoOptional.get());
            return true;
        } else {
            return false;
        }
    }
}