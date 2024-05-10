package com.digitalsouag.salaire.entity;

import java.util.ArrayList;

public class Personnel {
    final static int MAX_EMPLOYE = 100;
    private int nbreEmployes;
    private ArrayList<Employe> collectionEmployes;

    public Personnel() {
        collectionEmployes = new ArrayList<Employe>();
        nbreEmployes = 0;
    }

    public void ajouterEmploye(Employe emp) {
        if (collectionEmployes.size() < MAX_EMPLOYE) {
            collectionEmployes.add(emp);
            nbreEmployes++;
        } else {
            System.out.println("Désolé, nombre max d'employés atteint !");
        }

    }

    public void afficherSalaires() {
        // Parcours tout les employés et affiche le salaire de chacun
        for (Employe employe: collectionEmployes) {
            System.out.println(employe.afficherNomPrenomsEmploye() + " gagne " + employe.calculSalaire() + " francs.");
        }
    }

    public double salaireMoyen() {
        double somSalaire = 0;
        // Parcours tout les employés et on additionne leurq salaires moyen
        for (Employe employe: collectionEmployes) {
            somSalaire += employe.calculSalaire();
        }

        return (collectionEmployes.size() > 0 ? somSalaire / collectionEmployes.size() : 0);

    }
}
