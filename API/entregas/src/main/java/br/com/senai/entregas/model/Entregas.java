package br.com.senai.entregas.model;


import jakarta.persistence.Entit;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "entregas")
public class Entregas {
    private Integer entrega_id;
    private Integer usuario_id;
    private Integer endereco_id;
    private String descricao_produto;
    private Double preco_unitario;


}
