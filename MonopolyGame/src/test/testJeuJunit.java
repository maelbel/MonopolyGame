package test;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import MonopolyGame.Case;
import MonopolyGame.CaseAllerEnPrison;
import MonopolyGame.CaseChance;
import MonopolyGame.CaseDepart;
import MonopolyGame.CaseImpot;
import MonopolyGame.CasePrison;
import MonopolyGame.Jeu;
import MonopolyGame.Joueur;
import MonopolyGame.Pion;

class testJeuJunit {
	Jeu jeu = new Jeu();
	
	
	
	/*@ParameterizedTest(name = "{0}")
	
	@CsvSource({"1, 4, 5",
				"2, 3, 5",
				"6, 2, 8",
				"1, 2, 3",
				"6, 6, 12",
				"2, 2, 4",
				"3, 3, 6"})*/
	@Test
	void testSizeList() {
		assertEquals(0, jeu.size());
	}
	
	@Test
	void testAdd() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Joueur j2 = new Joueur ("Fabrice", "Chapeau");
		jeu.ajouterJoueur(j2);
		assertEquals(2, jeu.size());

		
	}
	
	@Test
	void testPions() {
		ArrayList <Pion> tousLesPions =  new ArrayList<Pion>();
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Joueur j2 = new Joueur ("Fabrice", "Chapeau");
		jeu.ajouterJoueur(j2);
		
		tousLesPions.add(j1.getPion());
		tousLesPions.add(j2.getPion());
		assertEquals(tousLesPions, jeu.tousLesPions());
	}
	
	
	@Test
	void testCaseDepart() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Pion p1 = j1.getPion();
		Case Depart = new CaseDepart();
		
		jeu.testerCase(Depart, p1, j1);
	}
	
	@Test
	void testCaseImpot() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Pion p1 = j1.getPion();
		Case Impot = new CaseImpot(200);
		
		jeu.testerCase(Impot, p1, j1);
		
	}
	@Test
	void testCaseChance() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Pion p1 = j1.getPion();
		Case Chance = new CaseChance();
		
		jeu.testerCase(Chance, p1, j1);
	}

	@Test
	void testCasePrison() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Pion p1 = j1.getPion();
		Case Prison = new CasePrison();
		
		jeu.testerCase(Prison, p1, j1);
	}

	@Test
	void testCaseAllerEnPrison() {
		Joueur j1 = new Joueur ("Claude", "Voiture");
		jeu.ajouterJoueur(j1);
		Pion p1 = j1.getPion();
		Case AllerEnPrison = new CaseAllerEnPrison();
		
		jeu.testerCase(AllerEnPrison, p1, j1);
	}
}
