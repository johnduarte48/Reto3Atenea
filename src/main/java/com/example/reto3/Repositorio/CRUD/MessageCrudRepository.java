package com.example.reto3.Repositorio.CRUD;

import com.example.reto3.Modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Long> {
}
