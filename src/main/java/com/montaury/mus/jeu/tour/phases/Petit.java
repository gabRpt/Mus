package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.carte.ValeurCarte;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Main;
import com.montaury.mus.jeu.joueur.Opposants;
import java.util.List;

import static com.montaury.mus.jeu.carte.ValeurCarte.Comparaison.PLUS_GRANDE;
import static com.montaury.mus.jeu.carte.ValeurCarte.Comparaison.PLUS_PETITE;

public class Petit extends Phase {
  public Petit() {
    super("Petit");
  }

  @Override
  protected Joueur meilleurParmi(Opposants opposants) {
    Joueur joueurEsku = opposants.joueurEsku();
    Joueur joueurZaku = opposants.joueurZaku();
    Joueur joueur2Equipe1 = opposants.dansLOrdre().get(2);
    Joueur joueur2Equipe2 = opposants.dansLOrdre().get(3);

    Main mainEquipe1 = joueurEsku.main();
    mainEquipe1.cartes().addAll(joueur2Equipe1.main().cartes());

    Main mainEquipe2 = joueurZaku.main();
    mainEquipe2.cartes().addAll(joueur2Equipe2.main().cartes());

    List<Carte> cartesEquipe1 = mainEquipe1.cartesDuPlusGrandAuPlusPetit();
    List<Carte> cartesEquipe2 = mainEquipe2.cartesDuPlusGrandAuPlusPetit();

    for (int i = Main.TAILLE - 1; i >= 0; i--) {
      ValeurCarte.Comparaison compare = cartesEquipe1.get(i).comparerAvec(cartesEquipe2.get(i));
      if (compare == PLUS_PETITE) {
        return joueurEsku;
      }
      if (compare == PLUS_GRANDE) {
        return joueurZaku;
      }
    }
    return joueurEsku;
  }
}
