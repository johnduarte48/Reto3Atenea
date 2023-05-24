package com.example.reto3.Service;

import com.example.reto3.Modelo.Message;
import com.example.reto3.Repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> getAll(){
        return repository.findAll();
    }

    public Optional<Message> getMessage(Long id){
        return repository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage()==null){
            return repository.save(message);
        }else{
            Optional<Message> messageEncontrado = getMessage(message.getIdMessage());
            if (messageEncontrado.isEmpty()){
                return repository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message updateMessage(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> messageUpdate = getMessage(message.getIdMessage());
            if(messageUpdate.isPresent()){
                if(message.getMessageText()!=null) {
                    messageUpdate.get().setMessageText(message.getMessageText());
                }
                return repository.save(messageUpdate.get());
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(long id){
        Boolean rta=getMessage(id).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
        return rta;
    }
}
