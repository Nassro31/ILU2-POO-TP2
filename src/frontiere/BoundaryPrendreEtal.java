package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(! controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis desol�"+ nomVendeur +"mais il faut etre un hbaitant de notre village pour commencer ici ");
		}
		else {
			System.out.println("Bonjour"+ nomVendeur +"je vais regarder si je peux vous trouver un etal ");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Desolé"+ nomVendeur +"je n'ai plus d'etal qui ne soit pas occup� ");	
			}
			else {
				installerVendeur(nomVendeur);
            }
		}
	}

	private void installerVendeur(String nomVendeur) {
		int numeroEtal; 
        System.out.println("C'est parfait, il me reste un étal pour vous !");
        System.out.println("Il me faudrait quelques renseignements :");

        String produit = Clavier.entrerChaine("Quel produit voulez-vous vendre ? ");
        int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ? ");

        numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
        
        if (numeroEtal != -1) {
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro " + numeroEtal + " .");
        }
	}
}