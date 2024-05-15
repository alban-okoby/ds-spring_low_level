package com.digitalsouag.salaire.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
public class Representant extends Commercial {
    private final static double POURCENTAGE_REPRESENTANT = 0.20;
    private final static double BONUS_REPRESENTANT = 800.0;

    public Representant(String nom, String prenom, int age, LocalDateTime dateTime, double chiffreAffaire) {
        super(nom, prenom, age, dateTime, chiffreAffaire);
    }

    @Override
    public double calculSalaire() {
        return ((POURCENTAGE_REPRESENTANT * getChiffreAffaire()) + BONUS_REPRESENTANT);
    }

    @Override
    public String afficherNomPrenomsEmploye() {
        return ("Le Représentant : " + super.afficherNomPrenomsEmploye());
    }
}
