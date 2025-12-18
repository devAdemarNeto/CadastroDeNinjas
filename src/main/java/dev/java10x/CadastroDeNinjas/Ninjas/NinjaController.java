package dev.java10x.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota gera uma mensagem de boas vindas para quem à acessa")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um nova ninja", description = "Cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso" + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por id(Read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lsta o ninja por ID", description = "Rota lista um  ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja encontrado sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado")
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
    @Operation(summary = "Altera um  ninja por ID", description = "Rota altera um  ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com  sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado, não foi possival alterar")
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

    //Deletar ninja (Delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com id " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado");
        }
    }

}
