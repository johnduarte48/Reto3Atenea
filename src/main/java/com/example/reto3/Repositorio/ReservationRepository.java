package com.example.reto3.Repositorio;

import com.example.reto3.Modelo.Client;
import com.example.reto3.Modelo.DTOs.TotalAndClient;
import com.example.reto3.Modelo.Reservation;
import com.example.reto3.Repositorio.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired //A una instancia de ReservationCrudRepository
    private ReservationCrudRepository reservationCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Reservation> findAll(){
        return(List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(long id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Object[]> getTotalReservationsByClient(){

        return reservationCrudRepository.getTotalReservationsByClient();


    }
}
