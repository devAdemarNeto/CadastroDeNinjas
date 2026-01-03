package dev.java10x.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
@Tag(name= "Ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(
            summary = "Mensagem de boas vindas",
            description = "Essa rota gera uma mensagem de boas vindas para quem à acessa"
    )
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    @PostMapping("/criar")
    @Operation(summary = "Cria um nova ninja")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja "),
            @ApiResponse(responseCode = "409", description = "E-mail já cadastrado")

    })
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }


    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja encontrado sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){

        NinjaDTO ninja =  ninjaService.listarNinjasPorId(id);

        if (ninja !=  null) {
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " nã existe em nossos registros");
        }
    }

    //Alterar dados dos ninjas(Updadte)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um  ninja por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja alterado com  sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possival alterar")
    })
    public ResponseEntity<?> alterarNinjasPorId(
            @Parameter(description = "Usuario informa o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuaria informa os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja =  ninjaService.atualizarNinja(id,ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " nã existe em nossos registros");
        }
    }


    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar ninja por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        return ninjaService.listarNinjasPorId(id) != null
                ? ResponseEntity.ok("Ninja deletado com sucesso")
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado");
    }

}
