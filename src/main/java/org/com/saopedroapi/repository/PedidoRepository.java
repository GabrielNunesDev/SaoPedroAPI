package org.com.saopedroapi.repository;

import org.com.saopedroapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatusTrue();
}
