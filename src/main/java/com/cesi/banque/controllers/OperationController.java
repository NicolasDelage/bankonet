package com.cesi.banque.controllers;

import com.cesi.banque.entities.CompteCourant;
import com.cesi.banque.entities.CompteEpargne;
import com.cesi.banque.entities.Operation;
import com.cesi.banque.entities.repository.CompteCourantRepository;
import com.cesi.banque.entities.repository.CompteEpargneRepository;
import com.cesi.banque.entities.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/operation")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteCourantRepository compteCourantRepository;
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @PostMapping("")
    public Operation addOperation(@RequestBody Operation operation){

        Object compteCredite = new Object();
        Object compteDebite = new Object();

        if(operation.isCrediteCourant()){
            compteCredite = (CompteCourant)compteCourantRepository.findById(operation.getNumeroCompteCredite()).get();
            ((CompteCourant) compteCredite).setSolde(((CompteCourant) compteCredite).getSolde() + operation.getMontant());
        }
        else{
            compteCredite = (CompteEpargne)compteEpargneRepository.findById(operation.getNumeroCompteCredite()).get();
            ((CompteEpargne) compteCredite).setSolde(((CompteEpargne) compteCredite).getSolde() + operation.getMontant());
        }

        if(operation.isDebiteCourant()){
            compteDebite = (CompteCourant)compteCourantRepository.findById(operation.getNumeroCompteDebite()).get();
            ((CompteCourant) compteDebite).setSolde(((CompteCourant) compteDebite).getSolde() - operation.getMontant());
        }
        else{
            compteDebite = (CompteEpargne)compteEpargneRepository.findById(operation.getNumeroCompteDebite()).get();
            ((CompteEpargne) compteDebite).setSolde(((CompteEpargne) compteDebite).getSolde() - operation.getMontant());
        }


        operationRepository.save(operation);
        return operation;
    }

    @GetMapping("/{numero}")
    public List<Operation> getOperationsClient (@PathVariable Integer numero){
        List<Operation> operations = operationRepository.findOpByClientId(numero);
        return operations;
    }
}
