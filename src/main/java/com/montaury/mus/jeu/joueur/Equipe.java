package com.montaury.mus.jeu.joueur;

import java.util.List;

public class Equipe {
    public final List<Joueur> joueurs;
    public String nom;

    public Equipe(List<Joueur> joueurs, String nom) {
        this.joueurs = joueurs;
        this.nom = nom;
    }

    public Equipe(Joueur joueur){
        joueurs = List.of(joueur);
        nom = null;
    }
}