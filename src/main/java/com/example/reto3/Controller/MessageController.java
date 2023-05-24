package com.example.reto3.Controller;

import com.example.reto3.Modelo.Message;
import com.example.reto3.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable long id) {
        return service.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return service.save(message);
    }
}