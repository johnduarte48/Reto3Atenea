package com.example.reto3.Repositorio.CRUD;

import com.example.reto3.Modelo.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface ReservationCrudRepository extends CrudRepository<Reservation,Long> {

    //Reporte 1
    //SELECT * FROM Reservation WHERE startDate AFTER fechaA AND devolutionDate BEFORE fechaB

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    //REPORTE 2
    //SELECT * FROM Reservation WHERE status="valornecesitado"
    public List<Reservation> findAllByStatus(String status);

    //REPORTE 3
    //SELECT client, COUNT(client) FROM Reservation GROUP BY client ORDER BY COUNT (client) DESC;
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();
}
