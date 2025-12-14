package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//Entity: Transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
@Data // Cria os geters e os seters
@NoArgsConstructor // cria construtores sem arqumentos
@AllArgsConstructor // Cria construtores com argumentos
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) // Coluna única, só terá um e-mail por ninja
    private String email;

    @Column(name = "img_url")
    private String img_url;

    @Column(name = "idade")
    private int idade;

    @Column(name="rank")
    private String rank;

    // @ManyToOne - um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;
}
