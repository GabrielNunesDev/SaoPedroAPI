package org.com.saopedroapi.service;

import org.com.saopedroapi.model.Produto;
import org.com.saopedroapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> atualizarProduto(Long id, Produto produtoDetalhes) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();
            produtoExistente.setNome(produtoDetalhes.getNome());
            produtoExistente.setValorUnitario(produtoDetalhes.getValorUnitario());
            produtoExistente.setFormaFarmaceuticaEnum(produtoDetalhes.getFormaFarmaceuticaEnum());

            return Optional.of(produtoRepository.save(produtoExistente));
        } else {
            return Optional.empty();
        }
    }

    public boolean excluirProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}