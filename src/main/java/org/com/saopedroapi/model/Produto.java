package org.com.saopedroapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.com.saopedroapi.enums.FormaFarmaceuticaEnum;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    BigDecimal valorUnitario;
    Integer quantidadeDisponivel;

    @Enumerated(EnumType.STRING)
    private FormaFarmaceuticaEnum formaFarmaceuticaEnum;

}
