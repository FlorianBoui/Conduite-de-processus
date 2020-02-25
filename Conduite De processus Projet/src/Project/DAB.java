package Project;

import java.util.Locale;
import java.util.Scanner;

public class DAB{
	private static DAB sDAB = null;
	CarteBancaire c;

	public static DAB getInstance() {
		if (sDAB == null)
			sDAB = new DAB();
		return sDAB;
	}
	
	public DAB() {
		this.c = null;
	}
	
	public Boolean verifCarte(Carte card) {
		if(card.type == eTypeCarte.CREDIT) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insertionCarte(CarteBancaire card) {
		this.c = card;
	}
	
	public void ejectionCarte() {
		this.c = null;
	}
	
	public Boolean trouveCode() {
		int essai = 0;
		int codeentrer;
		
		Scanner scane;
		while(essai < 3) {
			System.out.print("Entrez votre code : ");
			scane = new Scanner(System.in);
			codeentrer = scane.nextInt();
			if(c.isCodeValid(codeentrer) == true) {
				break;
			}else{
				essai++;
			}
		}

		if(essai == 3) {
			ejectionCarte();
			System.out.println("Votre carte a été avaler.");
			return false;
		}else {
			return true;
		}
	}
	
	public void getMoney(double montant, Banque bq) {
		String CardIban = this.c.getIban();
		Boolean result = bq.valide_montant(CardIban, montant);
		if(result == true) {
			System.out.println("Votre montant de "+montant+" euros a bien été retiré.");
			this.ejectionCarte();
		}else {
			this.ejectionCarte();
			System.out.println("Le montant demandé est trop élevé");
			
		}
	}


	public double demandemontant() {
		System.out.print("Veuillez entrez le montant désiré à l'aide du pavet numérique: ");
		Scanner scan = new Scanner(System.in).useLocale(Locale.US);
		double choix = scan.nextDouble();
		return choix;
	}


}