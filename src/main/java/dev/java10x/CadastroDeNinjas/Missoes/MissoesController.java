package dev.java10x.CadastroDeNinjas.Missoes;

// ex de rota: LOCALHOST:8080/adicionar

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // imforma que é uma rota para uma API
@RequestMapping("missoes") // mapeia a API
@Tag(name = "Missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/boasvindas")
    @Operation(
            summary = "Mensagem de boas vindas",
            description = "Essa rota gera uma mensagem de boas vindas para quem à acessa"
    )
    public String boasVindas() {
        return "Bem-vindo ao domínio de Missões";
    }

    @GetMapping("/listar") // mandar uma requisição para mostrar as missões
    @Operation(summary = "Lista todas as missoes")
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listaMissoesPorId(
            @Parameter(description = "ID da missão")
            @PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe em nossos registros");
        }
    }

    @PostMapping("/criar") // mandar uma requisição para criar as missões
    @Operation(summary = "Cria uma nova missão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO dto) {
        MissoesDTO novaMissao = missoesService.criarMissao(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso" + novaMissao.getNome() + "ID: " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}") // mandar uma requisição para alterar as missões
    @Operation(summary = "Altera uma missão por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão alterada com  sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, não foi possival alterar")
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "ID da missão")
            @PathVariable long id,
            @RequestBody MissoesDTO dto){
        MissoesDTO missao = missoesService.atualizarMissao(id, dto);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe em nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}") // mandar uma requisição para deletar as missões
    @Operation(summary = "Deletar missão por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<String> deletarMissao(
            @Parameter(description = "ID da missão")
            @PathVariable Long id){

        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso! ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o id " + id + " não encontrada");
    }
}
