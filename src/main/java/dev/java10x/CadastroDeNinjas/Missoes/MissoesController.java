package dev.java10x.CadastroDeNinjas.Missoes;

// ex de rota: LOCALHOST:8080/adicionar

import org.springframework.web.bind.annotation.*;

@RestController // imforma que é uma rota para uma API
@RequestMapping("missoes") // mapeia a API
public class MissoesController {

    @GetMapping("/listar") // mandar uma requisição para mostrar as missões
    public String listarMissao(){
        return "Missao listada com sucesso";
    }

    @PostMapping("/criar") // mandar uma requisição para criar as missões
    public String criarMissao() {
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar") // mandar uma requisição para alterar as missões
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar") // mandar uma requisição para deletar as missões
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }


}
