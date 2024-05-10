package com.digitalsouag.salaire.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
public class Vendeur extends Commercial {
    private final static double POURCENTAGE_VENDEUR = 0.20;
    private final static double BONUS_VENDEUR = 400.0;

    public Vendeur(String nom, String prenom, int age, LocalDateTime dateTime, double chiffreAffaire) {
        super(nom, prenom, age, dateTime, chiffreAffaire);
    }

    @Override
    public double calculSalaire() {
        return ((POURCENTAGE_VENDEUR * getChiffreAffaire()) + BONUS_VENDEUR);
    }

    @Override
    public String afficherNomPrenomsEmploye() {
        return ("Le vendeur : " + super.afficherNomPrenomsEmploye());
    }
}
