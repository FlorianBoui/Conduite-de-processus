package Project;

import java.util.HashMap;
import java.util.Map;


public class Banque {
	 Map<String, Double> comptes;

	private static Banque sBanque = null;

	public static Banque getInstance() {
		if (sBanque == null)
			sBanque = new Banque();
		return sBanque;
	}
	 
	 public Banque(){
		 comptes = new HashMap<String, Double>();
	 }
	 
	 public void add_compte(String iban, double montant) {
		 this.comptes.put(iban, montant);
	 }
	 
	 public Boolean valide_montant(String iban, double montant) {
		 double retire = this.comptes.get(iban);
		 if(Double.compare(retire, montant) >= 0){
		 //if(retire >= montant) {
			 this.comptes.put(iban, retire - montant);
			 return true;
		 }else {
			 return false;
		 }
	 }

	 public double getMontant(String IBAN){
		return this.comptes.get(IBAN);
	 }

}
