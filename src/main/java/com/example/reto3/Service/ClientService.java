package com.example.reto3.Service;

import com.example.reto3.Modelo.Client;
import com.example.reto3.Repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll(){
        return repository.findAll();
    }

    public Optional<Client> getClient(Long id){
        return repository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient()==null){
            return repository.save(client);
        }else{
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()){
                return repository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client updateClient(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientUpdate = getClient(client.getIdClient());
            if(clientUpdate.isPresent()){
                if(client.getEmail()!=null){
                    clientUpdate.get().setEmail(client.getEmail());
                }
                if(client.getName()!=null) {
                    clientUpdate.get().setName(client.getName());
                }
                if(client.getPassword()!=null) {
                    clientUpdate.get().setPassword(client.getPassword());
                }
                if(client.getAge() != null) {
                    clientUpdate.get().setAge(client.getAge());
                }
                return repository.save(clientUpdate.get());
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteClient(long id){
        Boolean rta=getClient(id).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return rta;
    }
}
