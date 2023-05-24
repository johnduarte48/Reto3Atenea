package com.example.reto3.Controller;

import com.example.reto3.Modelo.Reservation;
import com.example.reto3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable long id) {
        return service.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }
}