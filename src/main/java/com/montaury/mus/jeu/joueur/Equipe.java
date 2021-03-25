package com.montaury.mus.jeu.joueur;

import java.util.List;

public class Equipe {
    public final List<Joueur> joueurs;
    public String nom;

    public Equipe(List<Joueur> joueurs, String nom) {
        this.joueurs = joueurs;
        this.nom = nom;

        for (Joueur j: joueurs) {
            j.setEquipe(this);
        }
    }

    public Equipe(Joueur joueur){
        joueurs = List.of(joueur);
        nom = null;
    }

    public List<Joueur> getJoueurs(){
        return joueurs;
    }
}
