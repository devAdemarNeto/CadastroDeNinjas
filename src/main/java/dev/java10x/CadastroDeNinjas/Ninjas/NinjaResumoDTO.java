package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Resumo de um ninja associado a uma missão")
public class NinjaResumoDTO {
    @Schema(
            description = "Identificador único do ninja",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Nome do ninja",
            example = "Kakashi Hatake"
    )
    private String nome;

    @Schema(
            description = "Rank do ninja",
            example = "Jounin"
    )
    private String rank;

}
