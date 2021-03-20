package com.montaury.mus.jeu.joueur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private Equipe equipeA;
  private Equipe equipeB;
  private LinkedList<Joueur> listeJoueur = new LinkedList<Joueur>();

  public Opposants(Equipe equipeJoueurEsku, Equipe equipeJoueurZaku) {
    this.joueurEsku = equipeJoueurEsku.getJoueurA();
    this.joueurZaku = equipeJoueurZaku.getJoueurA();

    this.equipeA = equipeJoueurEsku;
    this.equipeB = equipeJoueurZaku;

    listeJoueur.add(joueurEsku);
    listeJoueur.add(joueurZaku);
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

  public Equipe getEquipeA(){
  return equipeA;
  }
  public Equipe getEquipeB(){
    return equipeB;
  }

  public Iterator<Joueur> itererDansLOrdre() {
    return new IteratorInfini(this);
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku, joueurZaku);
  }

  private static class IteratorInfini implements Iterator<Joueur> {
    private final Opposants opposants;
    private Joueur joueurCourant;
    private ArrayList<Joueur> arrayListJoueurs = new ArrayList<Joueur>();
    private final int nbJoueurs = 2;

    public IteratorInfini(Opposants opposants) {
      this.opposants = opposants;
      this.joueurCourant = opposants.getEquipeA().getJoueurA();
      arrayListJoueurs.add(opposants.getEquipeA().getJoueurA());
      arrayListJoueurs.add(opposants.getEquipeB().getJoueurA());
    }

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Joueur next() {
      int indiceJoueurCourant = arrayListJoueurs.indexOf(joueurCourant);
      int indiceJoueurSuivant = (indiceJoueurCourant+1)%nbJoueurs;
      joueurCourant = arrayListJoueurs.get(indiceJoueurSuivant);
      return joueurCourant;
    }
  }
}
