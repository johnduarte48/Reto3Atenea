package com.example.reto3.Controller;

import com.example.reto3.Modelo.Gama;
import com.example.reto3.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService service;

    @GetMapping("/all")
    public List<Gama> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable long id) {
        return service.getGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama){
        return service.save(gama);
    }
}
