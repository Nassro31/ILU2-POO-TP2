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
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        String[] donneesEtal = new String[5];

        donneesEtal[1] = nomVendeur;

        if (etal == null) {
            donneesEtal[0] = "false"; 
            return donneesEtal;
        }

        donneesEtal[0] = "true";
        donneesEtal[2] = etal.getProduit();
        donneesEtal[3] = String.valueOf(etal.etatEtal()[3]);
        donneesEtal[4] = String.valueOf(etal.etatEtal()[4]); 

        etal.libererEtal();

        return donneesEtal;
    }
}
