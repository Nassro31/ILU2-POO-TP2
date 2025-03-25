package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
		if(!isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui");
			donneesEtal[0] = "false";
		}
		else {
			donneesEtal[0] = "true";
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			donneesEtal[2] = etal.getProduit();
			donneesEtal[3] = etal.etatEtal()[3];
			donneesEtal[4] = etal.etatEtal()[4];
			System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + "." );
			System.out.println("En revoir " + donneesEtal[1]  + "passez une bonne journée ." );
		}
		return donneesEtal;
	}

}
