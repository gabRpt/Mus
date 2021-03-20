package com.montaury.mus.jeu.joueur;

import java.util.List;

public class Equipe {
    public final List<Joueur> joueurs;

    public Equipe(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Equipe(Joueur joueur){
        this(List.of(joueur));
    }
}