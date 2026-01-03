package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO dto){



        NinjaModel model = new NinjaModel();

        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setIdade(dto.getIdade());
        model.setImg_url(dto.getImg_url());
        model.setRank(dto.getRank());

        if (dto.getMissaoID() != null) {
            MissoesModel missao = new MissoesModel();
            missao.setId(dto.getMissaoID());
            model.setMissoes(missao);
        }


        return model;
    }


    public NinjaDTO map(NinjaModel model){

        NinjaDTO dto = new NinjaDTO();

        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setIdade(model.getIdade());
        dto.setImg_url(model.getImg_url());
        dto.setRank(model.getRank());

        if (model.getMissoes() != null) {
            dto.setMissaoID(model.getMissoes().getId());
        }

        return dto;

    }

}
