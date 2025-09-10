package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "pagamento", schema = "ecommerce")
public class Pagamento {
    @Id
    @Column(name = "pagamento_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "forma_pagamento", nullable = false, length = Integer.MAX_VALUE)
    private String formaPagamento;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "data_pagamento")
    private OffsetDateTime dataPagamento;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

}