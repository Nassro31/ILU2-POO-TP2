package frontiere;

import controleur.ControlEmmenager;
import personnages.Gaulois;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int forceGaulois;
					System.out.println(
							"Bienvenue villageois" + nomVisiteur );
					StringBuilder force = new StringBuilder();
					force.append("Quelles est votre force ?");
					forceGaulois = Clavier.entrerEntier(force.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int effetPotionMax = 0;
		int effetPotionMin = 0;
		int forceDruide = 0;
		System.out.println(
				"Bienvenue druide" + nomVisiteur);
		StringBuilder force = new StringBuilder();
		force.append("quelle est votre force ? ");
		forceDruide = Clavier.entrerEntier(force.toString());
		while (effetPotionMin<effetPotionMax) {
			StringBuilder potionMin = new StringBuilder();
			potionMin.append("Quelle est la force de potion la plus faible que vous produisez");
			effetPotionMin = Clavier.entrerEntier(potionMin.toString());
			StringBuilder potionMax = new StringBuilder();
			potionMin.append("Quelle est la force de potion la plus forte que vous produisez");
			effetPotionMax = Clavier.entrerEntier(potionMax.toString());
			if (effetPotionMax<effetPotionMin) {
				System.out.println(
						"Attention druide vous vous etes tromp� entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}

