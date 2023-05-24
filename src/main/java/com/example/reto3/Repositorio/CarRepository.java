package com.example.reto3.Repositorio;

import com.example.reto3.Modelo.Car;
import com.example.reto3.Repositorio.CRUD.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired //A una instancia de CarCrudRepository
    private CarCrudRepository carCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Car> findAll(){
        return(List<Car>) carCrudRepository.findAll();
    }

    public Optional<Car> getCar(long id){
        return carCrudRepository.findById(id);
    }

    public Car save(Car car){
        return carCrudRepository.save(car);
    }

    public void delete(Car car){
        carCrudRepository.delete(car);
    }
}
