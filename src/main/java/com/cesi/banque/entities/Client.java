package com.cesi.banque.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nom;

    private String prenom;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<CompteCourant> compteCourants;

    public Set<CompteCourant> getCompteCourants(){
        return compteCourants;
    }

    public void setCompteCourants(Set<CompteCourant> compteCourants) {
        this.compteCourants = compteCourants;
    }


    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<CompteEpargne> compteEpargnes;

    public Set<CompteEpargne> getCompteEpargnes(){
        return compteEpargnes;
    }

    public void setCompteEpargnes(Set<CompteEpargne> compteEpargnes) {
        this.compteEpargnes = compteEpargnes;
    }



    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
