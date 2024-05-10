package com.digitalsouag.salaire.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
class Commercial extends Employe {
    private double chiffreAffaire;

    public Commercial(String nom, String prenom, int age, LocalDateTime dateTime, double chiffreAffaire) {
        super(nom, prenom, age, dateTime);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double chiffreAffaire() {
        return chiffreAffaire;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public double calculSalaire() {
        return 0;
    }
}