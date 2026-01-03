package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaResumoDTO;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO dto){
        MissoesModel model = new MissoesModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setDificuldade(dto.getDificuldade());
        return model;
    }

    public MissoesDTO map(MissoesModel model){
        MissoesDTO dto = new MissoesDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setDificuldade(dto.getDificuldade());
        dto.setNinjas(
                model.getNinjas()
                        .stream()
                        .map(this::mapNinjaParaResumo)
                        .toList()
        );

        return dto;
    }

    private NinjaResumoDTO mapNinjaParaResumo(NinjaModel ninja) {
        return new NinjaResumoDTO(
                ninja.getId(),
                ninja.getNome(),
                ninja.getRank()
        );
    }

}
