package com.example.reto3.Service;


import com.example.reto3.Modelo.Car;
import com.example.reto3.Repositorio.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public List<Car> getAll(){
        return repository.findAll();
    }

    public Optional<Car> getCar(Long id){
        return repository.getCar(id);
    }

    public Car save(Car car){
        if (car.getIdCar()==null){
            return repository.save(car);
        }else{
            Optional<Car> carEncontrado = getCar(car.getIdCar());
            if (carEncontrado.isEmpty()){
                return repository.save(car);
            }else{
                return car;
            }
        }
    }

    public Car updateCar(Car car){
        if(car.getIdCar()!=null){
            Optional<Car> carUpdate = getCar(car.getIdCar());
            if(carUpdate.isPresent()){
                if(car.getBrand()!=null){
                    carUpdate.get().setBrand(car.getBrand());
                }
                if(car.getName()!=null) {
                    carUpdate.get().setName(car.getName());
                }
                if(car.getGama()!=null) {
                    carUpdate.get().setGama(car.getGama());
                }
                if(car.getYear()!=null) {
                    carUpdate.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null) {
                    carUpdate.get().setDescription(car.getDescription());
                }
                return repository.save(carUpdate.get());
            }else{
                return car;
            }
        }else{
            return car;
        }
    }
    public boolean deleteCar(long id){
        Boolean rta=getCar(id).map(car -> {
            repository.delete(car);
            return true;
        }).orElse(false);
        return rta;
    }
}
