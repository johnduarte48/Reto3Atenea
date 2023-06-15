package com.example.reto3.Controller;

import com.example.reto3.Modelo.DTOs.CompletedAndCancelled;
import com.example.reto3.Modelo.DTOs.TotalAndClient;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return service.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable long id){
        return service.deleteReservation(id);
    }

    //Reto 5
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("dateOne") String dateOne,
                                                        @PathVariable("dateTwo") String dateTwo){
        return service.getReservationsBetweenDatesReport(dateOne,dateTwo);
    }
    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        return service.getReservationStatusReport();
    }
    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return service.getTopClientsReport();
    }
}