package com.example.reto3.Service;

import com.example.reto3.Modelo.Reservation;
import com.example.reto3.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll(){
        return repository.findAll();
    }

    public Optional<Reservation> getReservation(Long id){
        return repository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isEmpty()){
                return repository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservationUpdate = getReservation(reservation.getIdReservation());
            if(reservationUpdate.isPresent()){
                if(reservation.getStartDate()!=null) {
                    reservationUpdate.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null) {
                    reservationUpdate.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null) {
                    reservationUpdate.get().setStatus(reservation.getStatus());
                }
                return repository.save(reservationUpdate.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation(long id){
        Boolean rta=getReservation(id).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return rta;
    }
}
