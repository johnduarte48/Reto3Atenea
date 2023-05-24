package com.example.reto3.Repositorio;

import com.example.reto3.Modelo.Score;
import com.example.reto3.Repositorio.CRUD.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired //A una instancia de ScoreCrudRepository
    private ScoreCrudRepository scoreCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Score> findAll(){
        return(List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(long id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}

