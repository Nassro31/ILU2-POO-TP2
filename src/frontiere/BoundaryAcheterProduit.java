package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol� " + nomAcheteur + " il faut �tre un habitant de notre " +
					"village pour commercer ici");
			return;
		}

		int choix;
		String produit = "";
		int quantite = 0;
		int i = 1;

		produit = Clavier.entrerChaine("Quel produit voulez vous acheter ? : ");
		Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursParProduit(produit);
		if (vendeurs == null) {
			System.out.println("D�sol�, personne ne vend ce produit au march�.");
		} else {
			for (Gaulois g : vendeurs) {
				System.out.println("- " + i + " " + g.getNom());
				i++;
			}
		}

		choix = Clavier.entrerEntier("Chez quel commer�ant voulez-vous acheter des fleurs ?");
		String nomVendeur = "";
		if(vendeurs != null) {
			do { 
				nomVendeur = vendeurs[choix-1].getNom();
			} while (choix-1 > vendeurs.length );
		}
		
		if (!controlAcheterProduit.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� " + nomAcheteur + " il faut �tre un habitant de notre " +
					"village pour commercer ici");
			return;
		}

		System.out.println(nomAcheteur + " se d�place jusqu'a l'�tal du vendeur " + nomVendeur);
		Etal etalvendeur = controlAcheterProduit.rechercherEtal(nomVendeur);
		int quantiteVendeur = etalvendeur.getQuantite();
		quantite = Clavier.entrerEntier("Combien de fleurs voulez vous acheter ? : ");

		if (quantiteVendeur == 0){
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " +  produit +
					", malheureusement il n�y en a plus !�");
		}
		if (Integer.valueOf(quantite) > quantiteVendeur){
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit +
					", malheureusement " + nomVendeur +
					" n�en a plus que" + quantiteVendeur + " "+ nomAcheteur +
					"ach�te tout le stock " + nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantiteVendeur);
		} else {
			System.out.println(nomAcheteur + " ach�te " + quantite + " " + produit + " � " + nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, Integer.valueOf(quantite));
		}
	}
}