package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    //Adicionar Ninja(CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    public NinjaModel ninjasPorId(@PathVariable Long id){
        return ninjaService.ninjasPorId(id);
    }

    //Alterar dados dos Ninjas(UPDATE)
    @PutMapping ("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }
    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID" )
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }

}

