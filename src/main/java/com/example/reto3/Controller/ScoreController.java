package com.example.reto3.Controller;

import com.example.reto3.Modelo.Score;
import com.example.reto3.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable long id) {
        return service.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return service.save(score);
    }
}
