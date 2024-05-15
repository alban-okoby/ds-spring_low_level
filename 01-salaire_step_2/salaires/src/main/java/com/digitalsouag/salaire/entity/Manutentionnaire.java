package com.digitalsouag.salaire.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Manutentionnaire extends Employe {
    private double nbreHeure;
    private final static double COEFFICIENT = 65.0;

    public Manutentionnaire(String nom, String prenom, int age, LocalDateTime dateTime, double nbreHeure) {
        super(nom, prenom, age, dateTime);
        this.nbreHeure = nbreHeure;
    }

    @Override
    public double calculSalaire() {
        return (COEFFICIENT * nbreHeure);
    }

    @Override
    public String afficherNomPrenomsEmploye() {
        return ("Le Manutentionnaire : " + super.afficherNomPrenomsEmploye());
    }

}
