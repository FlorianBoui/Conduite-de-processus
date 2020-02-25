package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilisateur{
	String nom;
	String prenom;
	private List<Carte> carte;
  
  public Utilisateur(String nom, String prenom){
	  this.nom = nom;
	  this.prenom = prenom;
	  carte = new ArrayList<Carte>();
  }
  
  public void ajoutCarte(Carte c) {
	  carte.add(c);
  }
  
  public void supprimeCarte(Carte c) {
	  for(int i = 0; i < carte.size(); i++) {
		  if(carte.get(i) == c) {
			  carte.remove(i);
		  }
	  }
  }
  
  public void afficheCarte() {
	  for(int  i = 0; i < carte.size(); i++) {
		  System.out.println(i+". "+carte.get(i).toString());
	  }
	  System.out.println();
  }
  
  public Carte choisirCarte() {
	  afficheCarte();
	  System.out.print("Choisir une carte de crédit: ");
	  Scanner scan = new Scanner(System.in);
	  int choix = scan.nextInt();
	  while(choix < 0 || choix >= carte.size()) {
		  System.out.print("Re-choisir une carte de crédit: ");
		  scan = new Scanner(System.in);
		  choix = scan.nextInt();
	  }
	  
	  //scan.close();
	  return carte.get(choix);
  }
  
  public int trouveCode(Carte c) {
	  if(c.type == eTypeCarte.CREDIT) {
		  if(this.nom == c.nom && this.prenom == c.prenom) {
			  System.out.println("Le code est "+((CarteBancaire)c).getCode());
			  return ((CarteBancaire)c).getCode();
		  }else{
			  System.out.println("ce n'est pas votre carte.");
			  return -1;
		  }
	  }
	  System.out.println("Ceci n'est pas une carte de crédit");
	  return -1;
  }


  /*
  public int demandemontant() {
	  System.out.println("Code bon.\nVeuillez entrez le montant désiré à l'aide du pavet numérique: ");
	  Scanner scan = new Scanner(System.in);
	  int choix = scan.nextInt();
	  return choix;
  }
  */
  
  public void carteAvalee(Carte card) {
	  carte.remove(card);
  }


}