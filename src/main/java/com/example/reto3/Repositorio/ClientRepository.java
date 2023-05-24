package com.example.reto3.Repositorio;


import com.example.reto3.Modelo.Car;
import com.example.reto3.Modelo.Client;
import com.example.reto3.Repositorio.CRUD.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired //A una instancia de ClientCrudRepository
    private ClientCrudRepository clientCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Client> findAll(){
        return(List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(long id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
