package com.cesi.banque.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "compte_courant")
public class CompteCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @JsonManagedReference
    @OneToMany(mappedBy = "compteCourant")
    private Set<Operation> operations;

    private String intitule;
    private float solde;
    private float decouvert;

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }
}
