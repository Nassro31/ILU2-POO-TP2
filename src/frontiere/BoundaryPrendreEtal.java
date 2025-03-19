package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		int numeroEtal; 
		if(! controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis desolé"+ nomVendeur +"mais il faut etre un hbaitant de notre village pour commencer ici ");
		}
		else {
			System.out.println("Bonjour"+ nomVendeur +"je vais regarder si je peux vous trouver un etal ");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Desolé"+ nomVendeur +"je n'ai plus d'etal qui ne soit pas occupé ");	
			}
			else{
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait il me reste un etal pour vous !");
				System.out.println("Il me faudrait quelque renseignements :");
				String produit = Clavier.entrerChaine("Quel produit voulez vous vendre ? ");
				int nbProduit  = Clavier.entrerEntier("Combien  sohaitez  vous en  vendre ? ");
				if( (numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit)) != -1) {
					System.out.println("le vendeur "+ nomVendeur +"s'est installé a l'etal numero  "+ numeroEtal);	
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
