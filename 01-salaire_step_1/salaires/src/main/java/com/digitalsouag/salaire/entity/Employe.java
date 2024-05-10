package com.digitalsouag.salaire.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Employe {
    @Id
    @GeneratedValue()
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private LocalDateTime deteEntree;

    public Employe() {

    }

    public Employe(String nom, String prenom, int age, LocalDateTime dateTime) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.deteEntree = dateTime;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDeteEntree() {
        return deteEntree;
    }

    public void setDeteEntree(LocalDateTime deteEntree) {
        this.deteEntree = deteEntree;
    }

    public String afficherNomPrenomsEmploye() {
        return getNom() + " " + getPrenom();
    }

    public abstract double calculSalaire();
}