package Project;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Boolean utilisateurQuitteDAB = false;

		Utilisateur p = new Utilisateur("Nehme", "Ali");
		CarteBancaire c1 = new CarteBancaire("Nehme", "Ali", 1234, "AZERGH34567");
		p.ajoutCarte(c1);
		CarteEtudiant c2 = new CarteEtudiant("Nehme", "Ali", "AZERGH34567");
		p.ajoutCarte(c2);
		CarteVital c3 = new CarteVital("Nehme", "Ali", "AZERGH34567");
		p.ajoutCarte(c3);

		DAB d = DAB.getInstance(); // Singleton
		Banque bq = Banque.getInstance();
		bq.add_compte("AZERGH34567", 200.0);
		Carte usedCard;

		while (!utilisateurQuitteDAB) {

			usedCard = p.choisirCarte();

			if (d.verifCarte(usedCard) == false) {
				System.out.println("Nous ne parvenons pas à lire cette carte, vérifier que cette carte est bien une carte de crédit.");
			}else {
				d.insertionCarte((CarteBancaire) usedCard);
				Boolean codevalide = d.trouveCode();

				if (codevalide == true) {
					System.out.println("Code bon.");
					System.out.println("Vous avez " + bq.getMontant(((CarteBancaire) usedCard).getIban()) + " euros dans votre compte.");
					double montant = d.demandemontant();
					d.getMoney(montant, bq);
				} else {
					p.carteAvalee(usedCard);
					p.afficheCarte();
				}
			}

			System.out.println("Voulez-vous partir du DAB ? [y/n]");
			Scanner s = new Scanner(System.in);
			if(s.next().charAt(0) == 'y')
				utilisateurQuitteDAB = true;


		}
	}

}
