package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaResumoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Objeto de transferência de dados de uma Missão")
public class MissoesDTO {

    @Schema(
            description = "Identificador unico de uma missão ",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nome da missão",
            example = "Realizar escolta de um Kage"
    )
    private String nome;

    @Schema(
            description = "Dificuldade da missão",
            example = "Alta"
    )
    private String dificuldade;


    @Schema(
            description = "Ninjas associados à missão"
    )
    private List<NinjaResumoDTO> ninjas;

}
