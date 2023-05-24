package com.example.reto3.Repositorio.CRUD;

import com.example.reto3.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation,Long> {
}
