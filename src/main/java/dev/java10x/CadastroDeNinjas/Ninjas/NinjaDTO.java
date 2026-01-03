package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description =  "Objeto de transferência de dados de um Ninja")
public class NinjaDTO {


    @Schema(
            description = "Idesntificador único de um ninja",
            example = "1",
            accessMode =  Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nome do ninja",
            example = "Naruto Uzumaki"
    )
    private String nome;

    @Schema(
            description = "E-mail do ninja",
            example = "naruto@email.com"
    )
    private String email;

    @Schema(
            description = "Imagem do ninja",
            example = "https://meusite.com/imagens/naruto.png"
    )
    private String img_url;

    @Schema(
            description = "Idade do ninja",
            example = "18"
    )
    private int idade;

    @Schema(
            description = "Rank do ninja",
            example = "Genin"
    )
    private String rank;

    @Schema(
            description = "Missão associada ao ninja"
    )
    private Long missaoID;

}
