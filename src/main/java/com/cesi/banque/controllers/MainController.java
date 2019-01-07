package com.cesi.banque.controllers;

import com.cesi.banque.entities.Client;
import com.cesi.banque.entities.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="")
public class MainController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="/add")
    public String addNewUser (@RequestParam String nom
            , @RequestParam String prenom) {
        Client n = new Client();
        n.setNom(nom);
        n.setPrenom(prenom);
        clientRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="")
    public String postAddClient (@RequestBody Client newClient) {
        clientRepository.save(newClient);
        return "Client ajouté";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    @GetMapping(path="")
    public Optional<Client> getClient (@RequestParam Integer id) {
        return clientRepository.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteClient (@PathVariable Integer id){
        Optional<Client> OptionalClient = clientRepository.findById(id);
        if(!OptionalClient.isPresent()){
            return "Client introuvable";
        }
        clientRepository.deleteById(id);
        return "Client supprimé";
    }

    @PutMapping("/{id}")
    public String putClient (@PathVariable Integer id, @RequestBody Client updateClient){
        Optional<Client> OptionalClient = clientRepository.findById(id);
        if(!OptionalClient.isPresent()){
            return "Client introuvable";
        }
        Client client = OptionalClient.get();
        client.setPrenom(updateClient.getPrenom());
        client.setNom(updateClient.getNom());
        clientRepository.save(client);
        return "Client modifié";
    }

    /*@PatchMapping("/{id}")
    public String patchClient (@PathVariable Integer id, @RequestBody Client updateClient){
        Optional<Client> OptionalClient = clientRepository.findById(id);
        if(!OptionalClient.isPresent()){
            return "Client introuvable";
        }
        else{
            Client client = OptionalClient.get();
            client.setPrenom();
        }
        return "Client modifié";
    }*/
}