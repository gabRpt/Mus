package com.montaury.mus.jeu.tour.phases;

import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.joueur.Equipe;
import com.montaury.mus.jeu.joueur.Joueur;
import com.montaury.mus.jeu.joueur.Opposants;
import org.junit.jupiter.api.Test;

import static com.montaury.mus.jeu.joueur.Fixtures.main;
import static com.montaury.mus.jeu.joueur.Fixtures.unJoueurAvec;
import static org.assertj.core.api.Assertions.assertThat;

class JeuTest {
  @Test
  void ne_doit_pas_se_derouler_si_personne_n_a_le_jeu() {
    Opposants opposants = new Opposants(
      new Equipe(unJoueurAvec(main(Carte.AS_BATON, Carte.QUATRE_PIECE, Carte.VALET_BATON, Carte.SIX_COUPE))),
      new Equipe(unJoueurAvec(main(Carte.VALET_PIECE, Carte.SIX_PIECE, Carte.QUATRE_BATON, Carte.AS_PIECE)))
    );

    boolean peutSeDerouler = new Jeu().peutSeDerouler(opposants);

    assertThat(peutSeDerouler).isFalse();
  }

  @Test
  void ne_doit_pas_se_derouler_si_un_des_joueurs_n_a_pas_le_jeu() {
    Opposants opposants = new Opposants(
      new Equipe(unJoueurAvec(main(Carte.AS_BATON, Carte.QUATRE_PIECE, Carte.VALET_BATON, Carte.SIX_COUPE))),
      new Equipe(unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.AS_PIECE)))
    );

    boolean peutSeDerouler = new Jeu().peutSeDerouler(opposants);

    assertThat(peutSeDerouler).isFalse();
  }

  @Test
  void devrait_se_derouler_si_les_deux_joueurs_ont_le_jeu() {
    Opposants opposants = new Opposants(
      new Equipe(unJoueurAvec(main(Carte.SIX_COUPE, Carte.SEPT_EPEE, Carte.VALET_BATON, Carte.VALET_COUPE))),
      new Equipe(unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.AS_PIECE)))
    );

    boolean peutSeDerouler = new Jeu().peutSeDerouler(opposants);

    assertThat(peutSeDerouler).isTrue();
  }

  @Test
  void devrait_faire_gagner_le_joueur_ayant_31_par_rapport_a_32() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.SIX_COUPE, Carte.ROI_EPEE, Carte.VALET_BATON, Carte.SIX_BATON));
    Joueur joueurZaku = unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.AS_PIECE));

    Joueur vainqueur = new Jeu().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurZaku);
  }

  @Test
  void devrait_faire_gagner_le_joueur_ayant_40_par_rapport_a_37() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.SEPT_BATON, Carte.ROI_EPEE, Carte.VALET_BATON, Carte.VALET_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.ROI_COUPE));

    Joueur vainqueur = new Jeu().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurZaku);
  }

  @Test
  void devrait_faire_gagner_le_joueur_ayant_36_par_rapport_a_33() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.SEPT_BATON, Carte.SIX_BATON, Carte.VALET_BATON, Carte.VALET_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.TROIS_BATON));

    Joueur vainqueur = new Jeu().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurEsku);
  }

  @Test
  void devrait_faire_gagner_le_joueur_esku_en_cas_d_egalite() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.VALET_EPEE, Carte.AS_BATON, Carte.VALET_BATON, Carte.VALET_COUPE));
    Joueur joueurZaku = unJoueurAvec(main(Carte.VALET_PIECE, Carte.CAVALIER_PIECE, Carte.ROI_BATON, Carte.AS_PIECE));

    Joueur vainqueur = new Jeu().meilleurParmi(new Opposants(new Equipe(joueurEsku), new Equipe(joueurZaku)));

    assertThat(vainqueur).isEqualTo(joueurEsku);
  }

  @Test
  void devrait_accorder_un_bonus_de_3_pour_31() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.VALET_EPEE, Carte.AS_BATON, Carte.VALET_BATON, Carte.VALET_COUPE));

    int pointsBonus = new Jeu().pointsBonus(joueurEsku);

    assertThat(pointsBonus).isEqualTo(3);
  }

  @Test
  void devrait_accorder_un_bonus_de_2_pour_32() {
    Joueur joueurEsku = unJoueurAvec(main(Carte.VALET_EPEE, Carte.DEUX_BATON, Carte.VALET_BATON, Carte.VALET_COUPE));

    int pointsBonus = new Jeu().pointsBonus(joueurEsku);

    assertThat(pointsBonus).isEqualTo(2);
  }
}