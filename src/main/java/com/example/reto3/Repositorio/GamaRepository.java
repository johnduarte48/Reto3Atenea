package com.example.reto3.Repositorio;

import com.example.reto3.Modelo.Gama;
import com.example.reto3.Repositorio.CRUD.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    @Autowired //A una instancia de ClientCrudRepository
    private GamaCrudRepository gamaCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Gama> findAll(){
        return(List<Gama>) gamaCrudRepository.findAll();
    }

    public Optional<Gama> getGama(long id){
        return gamaCrudRepository.findById(id);
    }

    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }

    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
}
