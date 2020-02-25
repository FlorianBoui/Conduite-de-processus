package Project;

public class CarteEtudiant extends Carte {
	static int id;
	int idnum;
	String ine;
	
	public CarteEtudiant(String nom, String prenom, String ine) {
		id++;
		this.idnum = id;
		this.nom = nom;
		this.prenom = prenom;
		this.ine = ine;
		this.type = eTypeCarte.ETUDIANT;
	}
	
	@Override
	public String toString() {
		return "id: "+idnum+", nom: "+nom+", prenom: "+prenom+" type: "+type+", IBAN: "+ine;
	}
	
}