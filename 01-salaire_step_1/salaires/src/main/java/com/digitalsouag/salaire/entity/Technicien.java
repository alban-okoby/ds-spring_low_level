package com.digitalsouag.salaire.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Technicien extends Employe {
    private double nbreUnite;
    private final static double COEFFICIENT = 5.0;

    public Technicien(String nom, String prenom, int age, LocalDateTime dateTime, double nbreUnite) {
        super(nom, prenom, age, dateTime);
        this.nbreUnite = nbreUnite;
    }

    @Override
    public double calculSalaire() {
        return (COEFFICIENT * nbreUnite);
    }

    @Override
    public String afficherNomPrenomsEmploye() {
        return ("Le Technicien : " + super.afficherNomPrenomsEmploye());
    }
}
