package com.montaury.mus;

import com.montaury.mus.jeu.Partie;
import com.montaury.mus.jeu.joueur.AffichageConsoleEvenementsDeJeu;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Opposants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mus {
  public static void main(String[] args) {
    System.out.print("Entrez votre nom: ");
    String nomJoueur = new Scanner(System.in).next();
    Joueur humain = Joueur.humain(nomJoueur);

    Partie partie = new Partie(new AffichageConsoleEvenementsDeJeu(humain));
    List<Joueur> joueursEquipe1 = new ArrayList<>();
    List<Joueur> joueursEquipe2 = new ArrayList<>();

    joueursEquipe1.add(humain);
    joueursEquipe1.add(Joueur.ordinateur());
    joueursEquipe2.add(Joueur.ordinateur());
    joueursEquipe2.add(Joueur.ordinateur());

    Partie.Resultat resultat = partie.jouer(new Opposants(new Equipe(joueursEquipe1,"Equipe 1"), new Equipe(joueursEquipe2,"Equipe 2")));

    System.out.println("Le vainqueur de la partie est " + resultat.vainqueur().nom());
  }
}
