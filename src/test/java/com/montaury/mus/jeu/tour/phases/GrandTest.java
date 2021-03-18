package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Opposants;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.main;
import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurAvec;
import static org.assertj.core.api.Assertions.assertThat;

class GrandTest {
  @Test
  void devrait_faire_gagner_le_joueur_esku_s_il_a_la_plus_grande_carte() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.AS_BATON, Carte.CINQ_PIECE, Carte.CAVALIER_BATON, Carte.SIX_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.DEUX_BATON, Carte.TROIS_PIECE, Carte.SEPT_BATON, Carte.AS_PIECE));

    Joueur vainqueur = new Grand().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurEsku);
  }
  @Test
  void devrait_faire_gagner_le_joueur_zaku_s_il_a_la_plus_grande_carte() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.AS_BATON, Carte.CINQ_PIECE, Carte.SEPT_BATON, Carte.SIX_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.DEUX_BATON, Carte.TROIS_PIECE, Carte.CAVALIER_BATON, Carte.AS_PIECE));

    Joueur vainqueur = new Grand().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurZaku);
  }

  @Test
  void devrait_faire_gagner_le_joueur_qui_a_la_seconde_plus_grande_carte_si_la_premiere_est_egale() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.AS_BATON, Carte.CINQ_PIECE, Carte.VALET_BATON, Carte.SIX_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.DEUX_BATON, Carte.VALET_PIECE, Carte.QUATRE_BATON, Carte.SEPT_PIECE));

    Joueur vainqueur = new Grand().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurZaku);
  }

  @Test
  void devrait_faire_gagner_le_joueur_esku_si_les_deux_mains_sont_egales() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.AS_BATON, Carte.QUATRE_PIECE, Carte.VALET_BATON, Carte.SIX_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.VALET_PIECE, Carte.SIX_PIECE, Carte.QUATRE_BATON, Carte.AS_PIECE));

    Joueur vainqueur = new Grand().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurEsku);
  }
}