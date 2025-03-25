package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	boolean isVendeur(String nomVendeur) {
		 Etal etal = null;
		 etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		 return etal != null ;
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		donneesEtal[1] = nomVendeur;
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
