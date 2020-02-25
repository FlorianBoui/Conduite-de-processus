package Project;

public class CarteBancaire extends Carte{
	static int id = 0;
	int idnum;
	private int code;
	private String iban;

	public CarteBancaire(String nom, String prenom, int code, String iban){
		id++;
		this.idnum = id;
		this.nom = nom;
		this.prenom = prenom;
		this.code = code;
		this.iban = iban;
		this.type = eTypeCarte.CREDIT;
	}

	public String getIban(){
		return this.iban;
	}

	public Boolean isCodeValid(int c){
		if(this.code == c){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "id: "+idnum+", nom: "+nom+", prenom: "+prenom+" type: "+type+", IBAN: "+iban;
	}
	
	public int getCode() {
		return this.code;
	}
	
}