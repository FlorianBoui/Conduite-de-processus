package Project;

public class CarteVital extends Carte{
	static int id = 0;
	int idnum;
	String num_secu;
	
	public CarteVital(String nom, String prenom, String num_secu) {
		id++;
		this.idnum = id;
		this.nom = nom;
		this.prenom = prenom;
		this.num_secu = num_secu;
		this.type = eTypeCarte.MEDICAL;
	}
	
	@Override
	public String toString() {
		return "id: "+idnum+", nom: "+nom+", prenom: "+prenom+" type: "+type+", IBAN: "+num_secu;
	}
}