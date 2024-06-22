package org.com.saopedroapi.service;

import org.com.saopedroapi.model.Pedido;
import org.com.saopedroapi.model.Produto;
import org.com.saopedroapi.repository.PedidoRepository;
import org.com.saopedroapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        Optional<Produto> produtoOpt = produtoRepository.findById(pedido.getProduto().getId());
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            BigDecimal valorUnitario = produto.getValorUnitario();
            BigDecimal quantidade = new BigDecimal(pedido.getQuantidade());
            pedido.setValorTotal(valorUnitario.multiply(quantidade));
        }
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
