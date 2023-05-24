package com.example.reto3.Controller;

import com.example.reto3.Modelo.Car;
import com.example.reto3.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Car")
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/all")
    public List<Car> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable long id) {
        return service.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return service.save(car);
    }
}
