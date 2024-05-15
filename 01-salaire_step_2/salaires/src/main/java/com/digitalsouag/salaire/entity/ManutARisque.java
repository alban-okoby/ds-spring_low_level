package com.digitalsouag.salaire.entity;

import com.digitalsouag.salaire.utils.PrimeDeRisque;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
public class ManutARisque extends Manutentionnaire implements PrimeDeRisque {
    public ManutARisque(String nom, String prenom, int age, LocalDateTime dateTime, double nbreHeure) {
        super(nom, prenom, age, dateTime, nbreHeure);
    }

    @Override
    public double calculSalaire() {
        return (super.calculSalaire() + PRIME);
    }
}
