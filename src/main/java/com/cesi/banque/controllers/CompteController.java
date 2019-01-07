package com.cesi.banque.controllers;

import com.cesi.banque.entities.Client;
import com.cesi.banque.entities.CompteCourant;
import com.cesi.banque.entities.CompteEpargne;
import com.cesi.banque.entities.repository.ClientRepository;
import com.cesi.banque.entities.repository.CompteCourantRepository;
import com.cesi.banque.entities.repository.CompteEpargneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/compte")
public class CompteController {
    @Autowired
    private CompteCourantRepository compteCourantRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @GetMapping("")
    public Optional<CompteCourant> getCompteCourant(@RequestParam Integer numero){
        return compteCourantRepository.findById(numero);
    }

    @GetMapping("/all")
    public Iterable<CompteCourant> getAllCompteCourant(){
        return compteCourantRepository.findAll();
    }

    @PostMapping("/courant")
    public CompteCourant addCompteCourant(@RequestBody CompteCourant compteCourant){
        Client client = clientRepository.findById(compteCourant.getClient().getId()).get();
        compteCourant.setClient(client);
        compteCourantRepository.save(compteCourant);
        return compteCourant;
    }

    @PostMapping("/epargne")
    public CompteEpargne addCompteEparnge(@RequestBody CompteEpargne compteEpargne){
        Client client = clientRepository.findById(compteEpargne.getClient().getId()).get();
        compteEpargne.setClient(client);
        compteEpargneRepository.save(compteEpargne);
        return compteEpargne;
    }

    @GetMapping("/client")
    public Client getClientComptes(@RequestParam Integer id){

        Client client = clientRepository.findById(id).get();

        return client;
    }
}