package com.digitalsouag.salaire.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
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

    public String afficherNomPrenomsEmploye() {
        return getNom() + " " + getPrenom();
    }

    public abstract double calculSalaire();
}