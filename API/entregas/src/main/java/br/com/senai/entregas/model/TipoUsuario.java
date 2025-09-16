package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@Getter
@Setter
// Obrigatorio para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor  // criar um construtor que recebe tudo(N obrigatorio)

// Anotacoes JPA a partir daqui
// Informa que essa classe e uma tabela
@Entity
@Table(name = "tipo_usuario")         // Permite que vc configure a tabela(Informar nome e outros dados)

public class TipoUsuario {

    // cada coluna e um atributo a classe

    @Id   // Define que e chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Define que a chave e gerenciada pelo BD

    @Column(name= "tipo_usuario_id", nullable = false)// Define/configura a coluna
    // nullable se pode ser nulo ou nao

    private Integer tipoUsuario;


    @Column(name= "descricao"
            , nullable = false
            , columnDefinition = "TEXT")
    private String descricao;



}
