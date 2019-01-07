package com.cesi.banque.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float montant;

    @JoinColumn(name = "numero_compte_debite")
    private int numeroCompteDebite;

    @JoinColumn(name = "numero_compte_credite")
    private int numeroCompteCredite;

    @JoinColumn(name = "credite_courant")
    private boolean crediteCourant;

    @JoinColumn(name = "debite_courant")
    private boolean debiteCourant;


    @JsonBackReference
    @ManyToOne()
    private CompteCourant compteCourant;

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public boolean isCrediteCourant() {
        return crediteCourant;
    }

    public int getNumeroCompteDebite() {
        return numeroCompteDebite;
    }

    public void setNumeroCompteDebite(int numeroCompteDebite) {
        this.numeroCompteDebite = numeroCompteDebite;
    }

    public int getNumeroCompteCredite() {
        return numeroCompteCredite;
    }

    public void setNumeroCompteCredite(int numeroCompteCredite) {
        this.numeroCompteCredite = numeroCompteCredite;
    }

    public void setCrediteCourant(boolean crediteCourant) {
        this.crediteCourant = crediteCourant;
    }

    public boolean isDebiteCourant() {
        return debiteCourant;
    }

    public void setDebiteCourant(boolean debiteCourant) {
        this.debiteCourant = debiteCourant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

}
