package com.example.reto3.Repositorio;

import com.example.reto3.Modelo.Message;
import com.example.reto3.Repositorio.CRUD.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired //A una instancia de MessageCrudRepository
    private MessageCrudRepository messageCrudRepository;
    //Aca se implementan todos los métodos para el repositorio de carros
    public List<Message> findAll(){
        return(List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(long id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}
