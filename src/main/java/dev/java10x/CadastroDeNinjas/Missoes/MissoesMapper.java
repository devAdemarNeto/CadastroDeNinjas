package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO dto){
        MissoesModel model = new MissoesModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setDificuldade(dto.getDificuldade());
        model.setNinjas(dto.getNinjas());
        return model;
    }

    public MissoesDTO map(MissoesModel model){
        MissoesDTO dto = new MissoesDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setDificuldade(dto.getDificuldade());
        dto.setNinjas(model.getNinjas());
        return dto;
    }
}
