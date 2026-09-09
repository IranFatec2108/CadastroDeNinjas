package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    //GET -- mandar uma requisicao para listar as missões
    @GetMapping("/listar")
    public String mostrarMissao(){
        return "Missão listadas com sucesso :";
    }

    //POST -- mandar uma requisicao para criar missoes

    @PostMapping("/criar")

        public String criarMissao() {
            return "Missão criada com sucesso: ";

        }

    //PUT -- mandar uma requisicao para alterar missoes

    @PutMapping("/alterar")

    public String alterarMissao() {
        return "Missão alterada com sucesso: ";

    }

    //DELETE -- mandar uma requisicao para excluir missoes

    @DeleteMapping("/criar")

    public String deletarMissao() {
        return "Missão deletada com sucesso: ";

    }
    }


