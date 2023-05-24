package com.example.reto3.Service;

import com.example.reto3.Modelo.Gama;
import com.example.reto3.Repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository repository;

    public List<Gama> getAll(){
        return repository.findAll();
    }

    public Optional<Gama> getGama(Long id){
        return repository.getGama(id);
    }

    public Gama save(Gama gama){
        if (gama.getIdGama()==null){
            return repository.save(gama);
        }else{
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
            if (gamaEncontrado.isEmpty()){
                return repository.save(gama);
            }else{
                return gama;
            }
        }
    }

    public Gama updateGama(Gama gama){
        if(gama.getIdGama()!=null){
            Optional<Gama> gamaUpdate = getGama(gama.getIdGama());
            if(gamaUpdate.isPresent()){
                if(gama.getName()!=null) {
                    gamaUpdate.get().setName(gama.getName());
                }
                if(gama.getDescription()!=null) {
                    gamaUpdate.get().setDescription(gama.getDescription());
                }
                return repository.save(gamaUpdate.get());
            }else{
                return gama;
            }
        }else{
            return gama;
        }
    }
    public boolean deleteGama(long id){
        Boolean rta=getGama(id).map(gama -> {
            repository.delete(gama);
            return true;
        }).orElse(false);
        return rta;
    }
}
