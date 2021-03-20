package com.montaury.mus.jeu.joueur;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;

  private LinkedList<Equipe> listeEquipe = new LinkedList<Equipe>();
  private LinkedList<Joueur> listeJoueur = new LinkedList<Joueur>();

  public Opposants(Equipe equipeA, Equipe equipeB) {
    this.joueurEsku = equipeA.joueurs.get(0);
    this.joueurZaku = equipeB.joueurs.get(0);

    listeEquipe.add(equipeA);
    listeEquipe.add(equipeB);

    for (Equipe equipe : listeEquipe) {
      listeJoueur.addAll(equipe.joueurs);
    }
  }

  public void tourner() {
    Joueur tmp = listeJoueur.removeFirst();
    joueurEsku = listeJoueur.getFirst();
    joueurZaku = tmp;
    listeJoueur.addLast(tmp);
  }

  public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public Iterator<Joueur> itererDansLOrdre() {
    return new IteratorInfini(this);
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku, joueurZaku);
  }

  private static class IteratorInfini implements Iterator<Joueur> {
    private final Opposants opposants;
    private Joueur suivant;
    public IteratorInfini(Opposants opposants) {
      this.opposants = opposants;
      suivant = opposants.joueurEsku;
    }
    @Override
    public boolean hasNext() {
      return true;
    }
    @Override
    public Joueur next() {
      Joueur next = suivant;
      suivant = suivant == opposants.joueurEsku ? opposants.joueurZaku : opposants.joueurEsku;
      return next;
    }
  }
}
