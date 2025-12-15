package dev.java10x.CadastroDeNinjas.Missoes;

// ex de rota: LOCALHOST:8080/adicionar

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // imforma que é uma rota para uma API
@RequestMapping("missoes") // mapeia a API
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Bem-vindo ao domínio de Missões";
    }

    @GetMapping("/listar") // mandar uma requisição para mostrar as missões
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listaMissoesPorId(@PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe em nossos registros");
        }
    }

    @PostMapping("/criar") // mandar uma requisição para criar as missões
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO dto) {
        MissoesDTO novaMissao = missoesService.criarMissao(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso" + novaMissao.getNome() + "ID: " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}") // mandar uma requisição para alterar as missões
    public ResponseEntity<?> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO dto){
        MissoesDTO missao = missoesService.atualizarMissao(id, dto);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe em nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}") // mandar uma requisição para deletar as missões
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso!" + id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não encontrada");
        }
    }


}
