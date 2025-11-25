package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity: Transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
@Data // Cria os geters e os seters
@NoArgsConstructor // cria construtores sem arqumentos
@AllArgsConstructor // Cria construtores com argumentos
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne - um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;



}
