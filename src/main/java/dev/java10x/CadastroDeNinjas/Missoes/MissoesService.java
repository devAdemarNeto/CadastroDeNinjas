package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Listar todas as missões
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Listar missão por id
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar missão
    public MissoesDTO criarMissao(MissoesDTO dto){
        MissoesModel model = missoesMapper.map(dto);
        model = missoesRepository.save(model);
        return missoesMapper.map(model);
    }

    // Atualizar missão
    public MissoesDTO atualizarMissao(Long id, MissoesDTO dto) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(dto);
            missaoAtualizada.setId(id);
            MissoesModel salva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(salva);
        }
        return null;
    }

        // Deletar missão
        public void deletarMissaoPorId(Long id) {
            missoesRepository.deleteById(id);
        }
}
