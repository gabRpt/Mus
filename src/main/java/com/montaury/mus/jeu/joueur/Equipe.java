package com.montaury.mus.jeu.joueur;

public class Equipe {
    private final Joueur joueurA;

    public Equipe(Joueur joueurA) {
        this.joueurA = joueurA;
    }

    public Joueur getJoueurA() {
        return joueurA;
    }
}