package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    final private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }


    //Adicionar Ninja(CREATE)
    @PostMapping("/criar")
    public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO  ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID) : " + novoNinja.getId());
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){

        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ninjasPorId(@PathVariable Long id){
        NinjaDTO ninjaPorId = ninjaService.ninjasPorId(id);

        if(ninjaPorId != null){
            return ResponseEntity.ok(ninjaPorId);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " não existe nos nossos registros.");
        }
    }

    //Alterar dados dos Ninjas(UPDATE)
    @PutMapping ("/alterar/{id}")
    public ResponseEntity <?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado, HttpEntity<Object> httpEntity){
        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if(ninjaAlterado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não existe nos nossos registros!" );
        }
        else{
            return ResponseEntity.ok(ninjaAlterado);
        }
    }
    //Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}" )
    public ResponseEntity <String>  deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.ninjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso!");

            }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado, por favor inserir um ID de ninja válido!");
        }
    }



