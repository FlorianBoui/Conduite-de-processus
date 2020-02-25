package Project;

public abstract class Carte{
	String nom;
	String prenom;
	eTypeCarte type;

	public String getNom(){
		return this.nom;
	}

	public String getPrenom(){
		return this.prenom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	
	public String toString() {
		return null;
	}

}