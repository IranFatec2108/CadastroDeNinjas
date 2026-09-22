package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository ;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Metodo para listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Metodo para listar ninja por ID
    public NinjaModel ninjasPorId(Long id){
    Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
    return ninjaPorID.orElse(null);
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);

        ninja = ninjaRepository.save(ninja);

        return ninjaMapper.map(ninja);
    }

    //Deletar o Ninja - tem que ser um metodo void
    public void  deletarNinjaPorId(Long id){
      ninjaRepository.deleteById(id);
    }

    // Alterar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
