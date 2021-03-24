package com.montaury.mus.jeu.joueur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private List<Equipe> listeEquipe = new ArrayList<>();
  private LinkedList<Joueur> listeJoueur = new LinkedList<>();

  public Opposants(Equipe equipeA, Equipe equipeB) {
    listeEquipe.add(equipeA);
    listeEquipe.add(equipeB);

    //J1->E1 | J2->E2 | J3->E1 | J4->E2
    for(var i=0 ;i<equipeA.joueurs.size();i++){
      listeJoueur.add(equipeA.joueurs.get(i));
      listeJoueur.add(equipeB.joueurs.get(i));
    }
    joueurEsku = listeJoueur.getFirst();
    joueurZaku = listeJoueur.getLast();
  }

  public void tourner() {
    joueurZaku = listeJoueur.removeFirst();
    listeJoueur.addLast(joueurZaku);
    joueurEsku = listeJoueur.getFirst();
  }

  public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public List<Joueur> dansLOrdre() {
    return listeJoueur;
  }

  public List<Equipe> getListeEquipe() {return listeEquipe;}
}