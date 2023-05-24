package com.example.reto3.Service;

import com.example.reto3.Modelo.Score;
import com.example.reto3.Repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public List<Score> getAll(){
        return repository.findAll();
    }

    public Optional<Score> getScore(Long id){
        return repository.getScore(id);
    }

    public Score save(Score score){
        if (score.getIdScore()==null){
            return repository.save(score);
        }else{
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isEmpty()){
                return repository.save(score);
            }else{
                return score;
            }
        }
    }

    public Score updateScore(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> scoreUpdate = getScore(score.getIdScore());
            if(scoreUpdate.isPresent()){
                if(score.getMessageText()!=null) {
                    scoreUpdate.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null) {
                    scoreUpdate.get().setStars(score.getStars());
                }
                return repository.save(scoreUpdate.get());
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean deleteScore(long id){
        Boolean rta=getScore(id).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return rta;
    }
}
