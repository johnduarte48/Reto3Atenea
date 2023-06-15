package com.example.reto3.Service;

import com.example.reto3.Modelo.Client;
import com.example.reto3.Modelo.DTOs.CompletedAndCancelled;
import com.example.reto3.Modelo.DTOs.TotalAndClient;
import com.example.reto3.Modelo.Reservation;
import com.example.reto3.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    //Reto 5
    public List<Reservation> getReservationsBetweenDatesReport(String fechaA, String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();

        try {
            a=parser.parse(fechaA);
            b=parser.parse(fechaB);
        }catch (ParseException exception){
            exception.printStackTrace();
        }

        if(a.before(b)){
            return repository.getReservationsBetweenDates(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public CompletedAndCancelled getReservationStatusReport(){
        List<Reservation> completed = repository.getReservationsByStatus("completed");
        List<Reservation> cancelled = repository.getReservationsByStatus("cancelled");

        Long cantidadCompletada = (long) completed.size();
        Long cantidadCancelada = (long) cancelled.size();

        CompletedAndCancelled respuesta = new CompletedAndCancelled(cantidadCompletada, cantidadCancelada);
        return respuesta;
    }

    public List<TotalAndClient> getTopClientsReport(){
        List<TotalAndClient> respuesta=new ArrayList<>();
        List<Object[]> reporte=repository.getTotalReservationsByClient();

        for (Object[] pareja:reporte){
            respuesta.add(new TotalAndClient((Long) pareja[1], (Client) pareja[0]));
        }

        /*for (int i=0;i<reporte.size();i++){
            respuesta.add(new TotalAndClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }*/
        return respuesta;
    }

}
